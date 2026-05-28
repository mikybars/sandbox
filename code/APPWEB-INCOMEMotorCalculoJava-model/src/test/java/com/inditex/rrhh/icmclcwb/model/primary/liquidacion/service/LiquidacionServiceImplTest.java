package com.inditex.rrhh.icmclcwb.model.primary.liquidacion.service;

import static java.util.Collections.emptyList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.CalculoConsultaRequestDTO;
import com.inditex.rrhh.icmclcwb.dto.CalculoEstadoRequestDTO;
import com.inditex.rrhh.icmclcwb.dto.CalculoEstadoResponseDTO;
import com.inditex.rrhh.icmclcwb.dto.EmpleadoConsultaItemDTO;
import com.inditex.rrhh.icmclcwb.dto.EmpleadoEstadoItemDTO;
import com.inditex.rrhh.icmclcwb.model.primary.liquidacion.repository.LiquidacionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.liquidacion.repository.LiquidacionRepository.ImporteRow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

@ExtendWith(MockitoExtension.class)
class LiquidacionServiceImplTest {

  @Mock
  LiquidacionRepository liquidacionRepository;

  @Captor
  ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  LiquidacionServiceImpl liquidacionService;

  @BeforeEach
  void setUp() {
    liquidacionService = new LiquidacionServiceImpl(liquidacionRepository);
  }

  @Nested
  class ConsultarCalculoBulk {

    @Test
    void whenSingleEmployeeWithResultsExpectOneItemWithImportes() {
      var empleado = new EmpleadoConsultaItemDTO(1L, 2, "EMP1", 100L, 1, LocalDate.of(2026, 1, 31), false);
      var request = new CalculoConsultaRequestDTO(List.of(empleado));
      var row = new ImporteRow("2", "EMP1", "100", "1", 3, "COM1", 150.0, null);
      when(liquidacionRepository.findImportes(any(MapSqlParameterSource.class), eq(false)))
          .thenReturn(List.of(row));

      var result = liquidacionService.consultarCalculoBulk(request);

      assertThat(result).hasSize(1);
      assertThat(result.get(0).getIdPeriodo()).isEqualTo(1L);
      assertThat(result.get(0).getIdEmpleado()).isEqualTo(100L);
      assertThat(result.get(0).getImportes()).hasSize(1);
      assertThat(result.get(0).getImportes().get(0).getIdTipoComision()).isEqualTo("COM1");
      assertThat(result.get(0).getImportes().get(0).getImporte()).isEqualTo(150.0);
    }

    @Test
    void whenIsDiarioTrueExpectFechaPopulated() {
      var fecha = LocalDate.of(2026, 1, 15);
      var empleado = new EmpleadoConsultaItemDTO(1L, 2, "EMP1", 100L, 1, LocalDate.of(2026, 1, 31), true);
      var request = new CalculoConsultaRequestDTO(List.of(empleado));
      var row = new ImporteRow("2", "EMP1", "100", "1", 3, "COM1", 150.0, fecha);
      when(liquidacionRepository.findImportes(any(MapSqlParameterSource.class), eq(true)))
          .thenReturn(List.of(row));

      var result = liquidacionService.consultarCalculoBulk(request);

      assertThat(result.get(0).getImportes().get(0).getFecha()).isEqualTo(fecha);
    }

    @Test
    void whenEmployeeHasNoDataExpectNotIncludedInResults() {
      var emp1 = new EmpleadoConsultaItemDTO(1L, 2, "EMP1", 100L, 1, LocalDate.of(2026, 1, 31), false);
      var emp2 = new EmpleadoConsultaItemDTO(1L, 2, "EMP1", 200L, 1, LocalDate.of(2026, 1, 31), false);
      var request = new CalculoConsultaRequestDTO(List.of(emp1, emp2));
      var row = new ImporteRow("2", "EMP1", "100", "1", 3, "COM1", 150.0, null);
      when(liquidacionRepository.findImportes(any(MapSqlParameterSource.class), eq(false)))
          .thenReturn(List.of(row))
          .thenReturn(emptyList());

      var result = liquidacionService.consultarCalculoBulk(request);

      assertThat(result).hasSize(1);
      assertThat(result.get(0).getIdEmpleado()).isEqualTo(100L);
    }

    @Test
    void whenEmptyEmpleadosExpectEmptyList() {
      var request = new CalculoConsultaRequestDTO(List.of());

      var result = liquidacionService.consultarCalculoBulk(request);

      assertThat(result).isEmpty();
      verify(liquidacionRepository, never()).findImportes(any(), any(Boolean.class));
    }
  }

  @Nested
  class ActualizarEstadoCalculoBulk {

    @Test
    void whenLiquidarActionExpectEstado6Bloqueado1() {
      var empleado = new EmpleadoEstadoItemDTO(1L, 2, "EMP1", 100L, 1);
      var request = new CalculoEstadoRequestDTO(
          CalculoEstadoRequestDTO.AccionEnum.LIQUIDAR, List.of(empleado));
      when(liquidacionRepository.updateEstado(any(MapSqlParameterSource.class))).thenReturn(1);

      liquidacionService.actualizarEstadoCalculoBulk(request);

      verify(liquidacionRepository, times(1)).updateEstado(paramsCaptor.capture());
      var params = paramsCaptor.getValue();
      assertThat(params.getValue("idEstadoDestino")).isEqualTo(6);
      assertThat(params.getValue("esBloqueado")).isEqualTo(1);
    }

    @Test
    void whenAnularActionExpectEstado2Bloqueado0() {
      var empleado = new EmpleadoEstadoItemDTO(1L, 2, "EMP1", 100L, 1);
      var request = new CalculoEstadoRequestDTO(
          CalculoEstadoRequestDTO.AccionEnum.ANULAR, List.of(empleado));
      when(liquidacionRepository.updateEstado(any(MapSqlParameterSource.class))).thenReturn(1);

      liquidacionService.actualizarEstadoCalculoBulk(request);

      verify(liquidacionRepository, times(1)).updateEstado(paramsCaptor.capture());
      var params = paramsCaptor.getValue();
      assertThat(params.getValue("idEstadoDestino")).isEqualTo(2);
      assertThat(params.getValue("esBloqueado")).isEqualTo(0);
    }

    @Test
    void whenEmployeeThrowsDataAccessExceptionExpectAddedToErrores() {
      var empleado = new EmpleadoEstadoItemDTO(1L, 2, "EMP1", 100L, 1);
      var request = new CalculoEstadoRequestDTO(
          CalculoEstadoRequestDTO.AccionEnum.LIQUIDAR, List.of(empleado));
      when(liquidacionRepository.updateEstado(any(MapSqlParameterSource.class)))
          .thenThrow(new DataAccessException("DB error") {});

      var result = liquidacionService.actualizarEstadoCalculoBulk(request);

      assertThat(result.getErrores()).hasSize(1);
      assertThat(result.getErrores().get(0).getIdEmpleado()).isEqualTo(100L);
      assertThat(result.getErrores().get(0).getDescripcion()).isEqualTo("DB error");
    }

    @Test
    void whenMultipleEmployeesOneFailsExpectOnlyFailedInErrores() {
      var emp1 = new EmpleadoEstadoItemDTO(1L, 2, "EMP1", 100L, 1);
      var emp2 = new EmpleadoEstadoItemDTO(1L, 2, "EMP1", 200L, 1);
      var request = new CalculoEstadoRequestDTO(
          CalculoEstadoRequestDTO.AccionEnum.LIQUIDAR, List.of(emp1, emp2));
      when(liquidacionRepository.updateEstado(any(MapSqlParameterSource.class)))
          .thenReturn(1)
          .thenThrow(new DataAccessException("fail") {});

      var result = liquidacionService.actualizarEstadoCalculoBulk(request);

      assertThat(result.getErrores()).hasSize(1);
      assertThat(result.getErrores().get(0).getIdEmpleado()).isEqualTo(200L);
      assertThat(result.getAccion()).isEqualTo(CalculoEstadoResponseDTO.AccionEnum.LIQUIDAR);
    }

    @Test
    void whenAllSucceedExpectEmptyErrores() {
      var empleado = new EmpleadoEstadoItemDTO(1L, 2, "EMP1", 100L, 1);
      var request = new CalculoEstadoRequestDTO(
          CalculoEstadoRequestDTO.AccionEnum.LIQUIDAR, List.of(empleado));
      when(liquidacionRepository.updateEstado(any(MapSqlParameterSource.class))).thenReturn(1);

      var result = liquidacionService.actualizarEstadoCalculoBulk(request);

      assertThat(result.getErrores()).isEmpty();
    }
  }
}
