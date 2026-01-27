package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.EstadoPeriodoCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPipeConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;

import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class TareaMigrarComisionRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<Integer>
    implements TareaMigrarComisionRepositoryCustom {

  @Value("#{pipePrimaryQuery['TareaMigrarComisionRepositoryCustom.findCalculoComisionByTareaActual']}")
  private String sqlFindCalculoComision;

  @Value("#{pipePrimaryQuery['TareaMigrarComisionRepositoryCustom.deleteCalculoComisionByTarea']}")
  private String sqlDeleteCalculoComision;

  @Value("#{pipePrimaryQuery['TareaMigrarComisionRepositoryCustom.countPersonasByTarea']}")
  private String sqlCountPersonas;

  @Value("${app.envars.migracion.comision.page-size.default}")
  private int pageSize;

  @Override
  public List<TareaMigrarComisionDto> findCalculoComisionByTareaActual(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPipeConstants.SQL_PARAM_ICM_ID_TAREA_ACTUAL, tarea.getId());
    log.info("SQL Query ejecutada para la migracion: {}", this.sqlFindCalculoComision);
    return this.query(this.sqlFindCalculoComision, map,
        (rs, rowNum) -> TareaMigrarComisionDto
            .builder()
            .icmIdPeriodo(rs.getLong(SqlPipeConstants.SQL_RESULT_ICM_ID_PERIODO))
            .cclIdOrigen(rs.getLong(SqlPipeConstants.SQL_RESULT_CCL_ID_ORIGEN))
            .stdIdLegEnt(rs.getLong(SqlPipeConstants.SQL_RESULT_STD_ID_LEG_ENT))
            .cclIdPerson(rs.getLong(SqlPipeConstants.SQL_RESULT_CCL_ID_PERSON))
            .stdOrHrPeriod(rs.getLong(SqlPipeConstants.SQL_RESULT_STD_OR_HR_PERIOD))
            .idEstado(rs.getInt(SqlPipeConstants.SQL_RESULT_ID_ESTADO))
            .fechaInicioPeriodo(rs.getDate(SqlPipeConstants.SQL_RESULT_FECHA_INICIO_PERIODO).toLocalDate())
            .fechaFinPeriodo(rs.getDate(SqlPipeConstants.SQL_RESULT_FECHA_FIN_PERIODO).toLocalDate())
            .fecha(rs.getDate(SqlPipeConstants.SQL_RESULT_FECHA).toLocalDate())
            .tiendaCalculo(rs.getLong(SqlPipeConstants.SQL_RESULT_TIENDA_CALCULO))
            .fechaInicioEstructura(rs.getDate(SqlPipeConstants.SQL_RESULT_FECHA_INICIO_ESTRUCTURA).toLocalDate())
            .fechaFinEstructura(rs.getDate(SqlPipeConstants.SQL_RESULT_FECHA_FIN_ESTRUCTURA).toLocalDate())
            .cclIdSeccion(rs.getLong(SqlPipeConstants.SQL_RESULT_CCL_ID_SECCION))
            .banda(rs.getLong(SqlPipeConstants.SQL_RESULT_BANDA))
            .valor(rs.getFloat(SqlPipeConstants.SQL_RESULT_VALOR))
            .icmIdTpComision(rs.getString(SqlPipeConstants.SQL_RESULT_ICM_ID_TP_COMISION))
            .icmIdTpCalculo(rs.getString(SqlPipeConstants.SQL_RESULT_ICM_ID_TP_CALCULO))
            .icmGrupoManual(rs.getString(SqlPipeConstants.SQL_RESULT_ICM_GRUPO_MANUAL))
            .idTipoOpcionCalculo(rs.getLong(SqlPipeConstants.SQL_RESULT_ID_TIPO_OPCION_CALCULO))
            .cclIdCodOrigenDestino(rs.getLong(SqlPipeConstants.SQL_RESULT_CCL_ID_COD_ORIGEN_DESTINO))
            .codTipoHora(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_TIPO_HORA))
            .minutos(rs.getLong(SqlPipeConstants.SQL_RESULT_MINUTOS))
            .codTiendaPresenciaEmpleado(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_TIENDA_PRESENCIA_EMPLEADO))
            .codSeccionPresenciaEmpleado(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_SECCION_PRESENCIA_EMPLEADO))
            .minutosTienda(rs.getLong(SqlPipeConstants.SQL_RESULT_MINUTOS_TIENDA))
            .codTiendaPresencia(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_TIENDA_PRESENCIA))
            .codSeccionPresencia(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_SECCION_PRESENCIA))
            .importeTotal(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_TOTAL))
            .importeTotalSinAjuste(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_TOTAL_SIN_AJUSTE))
            .importeAjusteTotal(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_AJUSTE_TOTAL))
            .importeFisica(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_FISICA))
            .importeFisicaSinAjuste(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_FISICA_SIN_AJUSTE))
            .importeAjusteFisica(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_AJUSTE_FISICA))
            .importeOnlineIpod(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_ONLINE_IPOD))
            .importeOnlineIpodSinAjuste(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_ONLINE_IPOD_SIN_AJUSTE))
            .importeAjusteOnlineIpod(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_AJUSTE_ONLINE_IPOD))
            .importeOnlineSint(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_ONLINE_SINT))
            .importeOnlineSintSinAjuste(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_ONLINE_SINT_SIN_AJUSTE))
            .importeAjusteOnlineSint(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_AJUSTE_ONLINE_SINT))
            .importeOnlineEntregaTienda(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_ONLINE_ENTREGA_TIENDA))
            .importeOnlineEntregaTiendaSinAjuste(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_ONLINE_ENTREGA_TIENDA_SIN_AJUSTE))
            .importeAjusteOnlineEntregaTienda(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_AJUSTE_ONLINE_ENTREGA_TIENDA))
            .importeOnlineEntregaDomicilio(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_ONLINE_ENTREGA_DOMICILIO))
            .importeOnlineEntregaDomicilioSinAjuste(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_ONLINE_ENTREGA_DOMICILIO_SIN_AJUSTE))
            .importeAjusteOnlineEntregaDomicilio(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_AJUSTE_ONLINE_ENTREGA_DOMICILIO))
            .ventaTotal(rs.getFloat(SqlPipeConstants.SQL_RESULT_VENTA_TOTAL))
            .ventaFisica(rs.getFloat(SqlPipeConstants.SQL_RESULT_VENTA_FISICA))
            .ventaOnlineIpod(rs.getFloat(SqlPipeConstants.SQL_RESULT_VENTA_ONLINE_IPOD))
            .ventaOnlineSint(rs.getFloat(SqlPipeConstants.SQL_RESULT_VENTA_ONLINE_SINT))
            .ventaOnlineEntregaTienda(rs.getFloat(SqlPipeConstants.SQL_RESULT_VENTA_ONLINE_ENTREGA_TIENDA))
            .ventaOnlineEntregaDomicilio(rs.getFloat(SqlPipeConstants.SQL_RESULT_VENTA_ONLINE_ENTREGA_DOMICILIO))
            .objetivo(rs.getFloat(SqlPipeConstants.SQL_RESULT_OBJETIVO))
            .excepcionada(rs.getInt(SqlPipeConstants.SQL_RESULT_EXCEPCIONADA))
            .congelada(rs.getInt(SqlPipeConstants.SQL_RESULT_CONGELADA))
            .challengeVentaTotal(rs.getFloat(SqlPipeConstants.SQL_RESULT_CHALLENGE_VENTA_TOTAL))
            .challengeVentaCaja(rs.getFloat(SqlPipeConstants.SQL_RESULT_CHALLENGE_VENTA_CAJA))
            .challengeDevoluciones(rs.getFloat(SqlPipeConstants.SQL_RESULT_CHALLENGE_DEVOLUCIONES))
            .challengeVentaOnlineIpod(rs.getFloat(SqlPipeConstants.SQL_RESULT_CHALLENGE_VENTA_ONLINE_IPOD))
            .challengeVentaOnlinePicking(rs.getFloat(SqlPipeConstants.SQL_RESULT_CHALLENGE_VENTA_ONLINE_PICKING))
            .challengeVentaOnlineEntregaTienda(rs.getFloat(SqlPipeConstants.SQL_RESULT_CHALLENGE_VENTA_ONLINE_ENTREGA_TIENDA))
            .importeVentaFisicaIndividual(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_VENTA_FISICA_INDIVIDUAL))
            .importeDevolucionFisicaIndividual(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_DEVOLUCION_FISICA_INDIVIDUAL))
            .importeVentaOnlineIpod(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_VENTA_ONLINE_IPOD))
            .importeDevolucionIndividualIpod(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_DEVOLUCION_INDIVIDUAL_IPOD))
            .coeficienteReduccionJornada(rs.getFloat(SqlPipeConstants.SQL_RESULT_COEFICIENTE_REDUCCION_JORNADA))
            .icmCkIncIvaEvalPtpo(rs.getLong(SqlPipeConstants.SQL_RESULT_ICM_CK_INC_IVA_EVAL_PTPO))
            .codSeccionBanda(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_SECCION_BANDA))
            .tipoPorcentajePolitica(rs.getString(SqlPipeConstants.SQL_RESULT_TIPO_PORCENTAJE_POLITICA))
            .codTiendaBanda(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_TIENDA_BANDA))
            .build());
  }

  @Override
  public List<TareaMigrarComisionDto> deleteCalculoComisionByTareaActual(@NotNull final RunTareaDto runTareaDto,
      @NotNull final TareaAmbitoDto tareaAmbitoDto) {

    // Obtener el conteo de personas
    final long personCount = this.countPersonasByTarea(runTareaDto);

    // Calcular el número de páginas
    final int pageCount = (int) Math.ceil((double) personCount / (double) this.pageSize);

    final List<TareaMigrarComisionDto> result = new ArrayList<>();
    int count = 0;

    log.info("Trabajo[{}]Tarea[{}] :: Iniciando migración de comisiones con {} personas en {} páginas (pageSize: {})",
        runTareaDto.getTrabajo().getId(), runTareaDto.getTarea().getId(), personCount, pageCount, this.pageSize);

    // Iterar por páginas
    for (int i = 0; i < pageCount; i++) {
      final int offset = this.pageSize * i;

      final MapSqlParameterSource map = new MapSqlParameterSource();
      map.addValue(SqlPipeConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
      map.addValue(SqlPipeConstants.SQL_PARAM_FECHA_INICIO_PERIODO, runTareaDto.getTarea().getFechaInicioPeriodo());
      map.addValue(SqlPipeConstants.SQL_PARAM_STD_ID_LEG_ENT, runTareaDto.getTarea().getStdIdLegEnt());
      map.addValue(SqlPipeConstants.SQL_PARAM_ICM_ID_PERIODO, runTareaDto.getTrabajo().getIcmIdPeriodo());
      map.addValue(SqlPipeConstants.SQL_PARAM_CCL_ID_ORIGEN, tareaAmbitoDto.getCclIdOrigen());
      map.addValue(SqlPipeConstants.SQL_PARAM_ID_ESTADO, EstadoPeriodoCalculoPersonaEnum.CALCULADO.getId());
      map.addValue(SqlPipeConstants.SQL_PARAM_LIMIT, this.pageSize);
      map.addValue(SqlPipeConstants.SQL_PARAM_OFFSET, offset);

      final List<TareaMigrarComisionDto> data = this.query(this.sqlDeleteCalculoComision, map,
          (rs, rowNum) -> TareaMigrarComisionDto
              .builder()
              .icmIdPeriodo(rs.getLong(SqlPipeConstants.SQL_RESULT_ICM_ID_PERIODO))
              .cclIdOrigen(rs.getLong(SqlPipeConstants.SQL_RESULT_CCL_ID_ORIGEN))
              .stdIdLegEnt(rs.getLong(SqlPipeConstants.SQL_RESULT_STD_ID_LEG_ENT))
              .cclIdPerson(rs.getLong(SqlPipeConstants.SQL_RESULT_CCL_ID_PERSON))
              .stdOrHrPeriod(rs.getLong(SqlPipeConstants.SQL_RESULT_STD_OR_HR_PERIOD))
              .fecha(rs.getDate(SqlPipeConstants.SQL_RESULT_FECHA).toLocalDate())
              .tiendaCalculo(rs.getLong(SqlPipeConstants.SQL_RESULT_TIENDA_CALCULO))
              .cclIdSeccion(rs.getLong(SqlPipeConstants.SQL_RESULT_CCL_ID_SECCION))
              .valor(rs.getFloat(SqlPipeConstants.SQL_RESULT_VALOR))
              .cclIdCodOrigenDestino(rs.getLong(SqlPipeConstants.SQL_RESULT_CCL_ID_COD_ORIGEN_DESTINO))
              .banda(rs.getLong(SqlPipeConstants.SQL_RESULT_BANDA))
              .icmIdTpComision(rs.getString(SqlPipeConstants.SQL_RESULT_ICM_ID_TP_COMISION))
              .icmIdTpCalculo(rs.getString(SqlPipeConstants.SQL_RESULT_ICM_ID_TP_CALCULO))
              .icmGrupoManual(rs.getString(SqlPipeConstants.SQL_RESULT_ICM_GRUPO_MANUAL))
              .idTipoOpcionCalculo(rs.getLong(SqlPipeConstants.SQL_RESULT_ID_TIPO_OPCION_CALCULO))
              .codTipoHora(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_TIPO_HORA))
              .codSeccionPresenciaEmpleado(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_SECCION_PRESENCIA_EMPLEADO))
              .codTiendaPresencia(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_TIENDA_PRESENCIA))
              .build());

      result.addAll(data);
      count += data.size();
      log.info("Trabajo[{}]Tarea[{}] :: Procesada página {}/{}: {} registros recuperados, total acumulado: {}, offset: {}",
          runTareaDto.getTrabajo().getId(), runTareaDto.getTarea().getId(), i + 1, pageCount, data.size(), count, offset);
    }

    log.info("Trabajo[{}]Tarea[{}] :: Migración de comisiones completada. Total de registros procesados: {}",
        runTareaDto.getTrabajo().getId(), runTareaDto.getTarea().getId(), count);
    return result;
  }

  private long countPersonasByTarea(@NotNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPipeConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());

    final Long count = this.queryForObject(this.sqlCountPersonas, map, Long.class);
    log.info("Trabajo[{}]Tarea[{}] :: Conteo de personas: {}", runTareaDto.getTrabajo().getId(), runTareaDto.getTarea().getId(), count);

    return count != null ? count : 0L;
  }
}
