package com.inditex.rrhh.icmclcwb.model.primary.liquidacion.service;

import java.util.List;
import java.util.stream.Stream;

import com.inditex.rrhh.icmclcwb.api.app.liquidacion.service.LiquidacionService;
import com.inditex.rrhh.icmclcwb.dto.CalculoConsultaRequestDTO;
import com.inditex.rrhh.icmclcwb.dto.CalculoConsultaResultadoItemDTO;
import com.inditex.rrhh.icmclcwb.dto.CalculoEstadoErrorItemDTO;
import com.inditex.rrhh.icmclcwb.dto.CalculoEstadoRequestDTO;
import com.inditex.rrhh.icmclcwb.dto.CalculoEstadoResponseDTO;
import com.inditex.rrhh.icmclcwb.dto.EmpleadoConsultaItemDTO;
import com.inditex.rrhh.icmclcwb.dto.EmpleadoEstadoItemDTO;
import com.inditex.rrhh.icmclcwb.dto.ImporteComisionItemDTO;
import com.inditex.rrhh.icmclcwb.model.primary.liquidacion.repository.LiquidacionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.liquidacion.repository.LiquidacionRepository.ImporteRow;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LiquidacionServiceImpl implements LiquidacionService {

  private static final int ESTADO_LIQUIDAR = 6;

  private static final int ESTADO_ANULAR = 2;

  private static final int BLOQUEADO_SI = 1;

  private static final int BLOQUEADO_NO = 0;

  private final LiquidacionRepository liquidacionRepository;

  @Override
  public List<CalculoConsultaResultadoItemDTO> consultarCalculoBulk(CalculoConsultaRequestDTO request) {
    return request.getEmpleados().stream()
        .flatMap(empleado -> {
          List<ImporteRow> rows = liquidacionRepository.findImportes(
              buildConsultaParams(empleado), empleado.getIsDiario());
          return rows.isEmpty() ? Stream.empty() : Stream.of(buildResultadoItem(empleado, rows));
        })
        .toList();
  }

  @Override
  public CalculoEstadoResponseDTO actualizarEstadoCalculoBulk(CalculoEstadoRequestDTO request) {
    int idEstadoDestino = resolveEstadoDestino(request.getAccion());
    int esBloqueado = resolveEsBloqueado(request.getAccion());

    List<CalculoEstadoErrorItemDTO> errores = request.getEmpleados().stream()
        .flatMap(empleado -> {
          try {
            liquidacionRepository.updateEstado(buildEstadoParams(empleado, idEstadoDestino, esBloqueado));
            return Stream.empty();
          } catch (DataAccessException ex) {
            return Stream.of(buildErrorItem(empleado, ex.getMessage()));
          }
        })
        .toList();

    return new CalculoEstadoResponseDTO()
        .accion(CalculoEstadoResponseDTO.AccionEnum.valueOf(request.getAccion().name()))
        .errores(errores);
  }

  private MapSqlParameterSource buildConsultaParams(EmpleadoConsultaItemDTO empleado) {
    return new MapSqlParameterSource()
        .addValue("idPeriodo", empleado.getIdPeriodo())
        .addValue("idOrigen", String.valueOf(empleado.getIdOrigen()))
        .addValue("idEmpresa", empleado.getIdEmpresa())
        .addValue("idEmpleado", String.valueOf(empleado.getIdEmpleado()))
        .addValue("ordinal", String.valueOf(empleado.getOrdinal()))
        .addValue("fechaFin", empleado.getFechaFin());
  }

  private MapSqlParameterSource buildEstadoParams(
      EmpleadoEstadoItemDTO empleado, int idEstadoDestino, int esBloqueado) {
    return new MapSqlParameterSource()
        .addValue("idPeriodo", empleado.getIdPeriodo())
        .addValue("idOrigen", String.valueOf(empleado.getIdOrigen()))
        .addValue("idEmpresa", empleado.getIdEmpresa())
        .addValue("idEmpleado", String.valueOf(empleado.getIdEmpleado()))
        .addValue("ordinal", String.valueOf(empleado.getOrdinal()))
        .addValue("idEstadoDestino", idEstadoDestino)
        .addValue("esBloqueado", esBloqueado);
  }

  private CalculoConsultaResultadoItemDTO buildResultadoItem(
      EmpleadoConsultaItemDTO empleado, List<ImporteRow> rows) {
    ImporteRow first = rows.get(0);
    List<ImporteComisionItemDTO> importes = rows.stream()
        .map(row -> new ImporteComisionItemDTO()
            .idTipoComision(row.idTipoComision())
            .importe(row.importe())
            .fecha(row.fecha()))
        .toList();
    return new CalculoConsultaResultadoItemDTO()
        .idPeriodo(empleado.getIdPeriodo())
        .idOrigen(Integer.valueOf(first.idOrigen()))
        .idEmpresa(first.idEmpresa())
        .idEmpleado(Long.valueOf(first.idEmpleado()))
        .ordinal(Integer.valueOf(first.ordinal()))
        .idEstado(first.idEstado())
        .importes(importes);
  }

  private CalculoEstadoErrorItemDTO buildErrorItem(EmpleadoEstadoItemDTO empleado, String descripcion) {
    return new CalculoEstadoErrorItemDTO()
        .idPeriodo(empleado.getIdPeriodo())
        .idOrigen(empleado.getIdOrigen())
        .idEmpresa(empleado.getIdEmpresa())
        .idEmpleado(empleado.getIdEmpleado())
        .ordinal(empleado.getOrdinal())
        .descripcion(descripcion);
  }

  private int resolveEstadoDestino(CalculoEstadoRequestDTO.AccionEnum accion) {
    return accion == CalculoEstadoRequestDTO.AccionEnum.LIQUIDAR ? ESTADO_LIQUIDAR : ESTADO_ANULAR;
  }

  private int resolveEsBloqueado(CalculoEstadoRequestDTO.AccionEnum accion) {
    return accion == CalculoEstadoRequestDTO.AccionEnum.LIQUIDAR ? BLOQUEADO_SI : BLOQUEADO_NO;
  }
}
