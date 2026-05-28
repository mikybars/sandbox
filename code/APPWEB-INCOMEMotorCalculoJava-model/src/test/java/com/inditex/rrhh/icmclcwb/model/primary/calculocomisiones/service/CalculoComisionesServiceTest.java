package com.inditex.rrhh.icmclcwb.model.primary.calculocomisiones.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.AmbitoFilter;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.ComisionLineDto;
import com.inditex.rrhh.icmclcwb.model.primary.calculocomisiones.repository.CalculoComisionesRepository;
import com.inditex.rrhh.icmclcwb.model.primary.calculocomisiones.repository.dto.EmpleadoAProcesarDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CalculoComisionesServiceTest {

  CalculoComisionesService service;

  @Mock
  CalculoComisionesRepository calculoComisionesRepository;

  @BeforeEach
  void beforeEach() {
    service = new CalculoComisionesService(calculoComisionesRepository);
  }

  @Nested
  class BuscarCalculoComisiones {

    @Test
    void whenNoEmpleadosFoundExpectEmptyResults() {
      CalculoComisionesFilterDto filter = CalculoComisionesFilterDto.builder()
          .idPeriodo(1L)
          .idOrigen(2L)
          .ambito(AmbitoFilter.EMPRESAS)
          .build();
      when(calculoComisionesRepository.findEmpleadosAProcesar(filter)).thenReturn(Collections.emptyList());

      CalculoComisionesResponseDto result = service.buscarCalculoComisiones(filter);

      assertThat(result.getData()).isEmpty();
      verify(calculoComisionesRepository, times(1)).findEmpleadosAProcesar(filter);
    }

    @Test
    void whenEmpleadosFoundExpectComisionesQueriedForEach() {
      CalculoComisionesFilterDto filter = CalculoComisionesFilterDto.builder()
          .idPeriodo(100L)
          .idOrigen(200L)
          .ambito(AmbitoFilter.EMPLEADOS)
          .build();
      EmpleadoAProcesarDto empleado1 = EmpleadoAProcesarDto.builder()
          .idPersona("EMP001")
          .idEmpresa("EMPRESA1")
          .idLugarTrabajo("TIENDA1")
          .build();
      EmpleadoAProcesarDto empleado2 = EmpleadoAProcesarDto.builder()
          .idPersona("EMP002")
          .idEmpresa("EMPRESA2")
          .idLugarTrabajo("TIENDA2")
          .build();
      List<ComisionLineDto> comisiones1 = List.of(
          ComisionLineDto.builder().idTipoComision("TC1").importe(100.0).build());
      List<ComisionLineDto> comisiones2 = List.of(
          ComisionLineDto.builder().idTipoComision("TC2").importe(200.0).build(),
          ComisionLineDto.builder().idTipoComision("TC3").importe(300.0).build());
      when(calculoComisionesRepository.findEmpleadosAProcesar(filter)).thenReturn(List.of(empleado1, empleado2));
      when(calculoComisionesRepository.findComisionesPorEmpleado(100L, 200L, "EMP001")).thenReturn(comisiones1);
      when(calculoComisionesRepository.findComisionesPorEmpleado(100L, 200L, "EMP002")).thenReturn(comisiones2);

      CalculoComisionesResponseDto result = service.buscarCalculoComisiones(filter);

      assertThat(result.getData()).hasSize(2);
      assertThat(result.getData().get(0).getIdEmpleado()).isEqualTo("EMP001");
      assertThat(result.getData().get(0).getIdEmpresa()).isEqualTo("EMPRESA1");
      assertThat(result.getData().get(0).getIdLugarTrabajo()).isEqualTo("TIENDA1");
      assertThat(result.getData().get(0).getComisiones()).hasSize(1);
      assertThat(result.getData().get(1).getIdEmpleado()).isEqualTo("EMP002");
      assertThat(result.getData().get(1).getComisiones()).hasSize(2);
      verify(calculoComisionesRepository, times(1)).findEmpleadosAProcesar(filter);
      verify(calculoComisionesRepository, times(1)).findComisionesPorEmpleado(100L, 200L, "EMP001");
      verify(calculoComisionesRepository, times(1)).findComisionesPorEmpleado(100L, 200L, "EMP002");
    }

    @Test
    void whenEmpleadoHasNoComisionesExpectEmptyComisionesList() {
      CalculoComisionesFilterDto filter = CalculoComisionesFilterDto.builder()
          .idPeriodo(10L)
          .idOrigen(20L)
          .ambito(AmbitoFilter.TIENDAS)
          .build();
      EmpleadoAProcesarDto empleado = EmpleadoAProcesarDto.builder()
          .idPersona("EMP999")
          .idEmpresa("EMP_EMPRESA")
          .idLugarTrabajo("EMP_TIENDA")
          .build();
      when(calculoComisionesRepository.findEmpleadosAProcesar(filter)).thenReturn(List.of(empleado));
      when(calculoComisionesRepository.findComisionesPorEmpleado(10L, 20L, "EMP999")).thenReturn(Collections.emptyList());

      CalculoComisionesResponseDto result = service.buscarCalculoComisiones(filter);

      assertThat(result.getData()).hasSize(1);
      assertThat(result.getData().get(0).getIdEmpleado()).isEqualTo("EMP999");
      assertThat(result.getData().get(0).getComisiones()).isEmpty();
    }
  }
}
