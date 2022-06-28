/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.ajuste.personas;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoResponseDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePoliticasRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteBajaItRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * javierev
 */
@ExtendWith(SpringExtension.class)
class CalculoAjusteBajaItServiceImplTest {

  private final static String SISTEMA_DESITNO = "ID SISTEMA DESTINO";

  private final static String CCL_ID_COD_ORIGEN = "ID ORIGEN";

  @Mock
  private PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

  @Mock
  private TareaCalculoAjusteBajaItRepositoryCustom tareaCalculoAjusteBajaItRepositoryCustom;

  @Mock
  private TareaAmbitoService tareaAmbitoService;

  @Mock
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @InjectMocks
  private CalculoAjusteBajaItServiceImpl calculoAjusteBajaItService;

  @Test
  void precondicionesTest() {

    when(this.tareaAmbitoService.findByTarea(any(TareaDto.class)))
        .thenReturn(Collections.singletonList(TareaAmbitoDto.builder().cclIdOrigen(CCL_ID_COD_ORIGEN).build()));
    when(this.meta4IcmWsCalcIncomeService.getSistemaDestino(any(SistemaDestinoRequestDto.class)))
        .thenReturn(SistemaDestinoResponseDto.builder().idSistemaDestino(SISTEMA_DESITNO).build());

    final List<IdPersonaLocalDto> personas = this.createPersonas();
    final TareaDto tarea = this.createTarea();
    this.calculoAjusteBajaItService.precondiciones(tarea, personas);

    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createTempPersonas();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createIndexTempPersonas();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createTempFechasBajaIt();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createIndexTempFechasBajaIt();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createTempFechasAcumuladasBajaIt();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createIndexTempFechasAcumuladasBajaIt();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createTempCalculoConAjuste();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createIndexTempCalculoConAjuste();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).insertTempPersonasBajaIt(tarea, personas,
        TipoPoliticaEnum.BAJA_IT);
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).insertTempFechasBajaIt(tarea);
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).insertTempFechasAcumuladasBajaIt();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1))
        .insertTempCalculoConAjusteBajaIt(Collections.singletonList(TipoPoliticaEnum.ANTIGUEDAD));
  }

  @Test
  void ajustarTest() {
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.calculoAjusteBajaItService.ajustar(algoritmoAjuste, new TareaDto());
    verify(this.tareaCalculoAjusteBajaItRepositoryCustom, times(1)).ajustar(algoritmoAjuste, new TareaDto());
  }

  @Test
  void postcondicionesTest() {
    this.calculoAjusteBajaItService.postcondiciones();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempPersonas();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempFechasBajaIt();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempFechasAcumuladasBajaIt();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempCalculoConAjuste();
  }

  @Test
  void ajustarExceptionTest() throws Exception {
    doThrow(new RuntimeException("Error")).when(this.tareaCalculoAjusteBajaItRepositoryCustom)
        .ajustar(any(AlgoritmoAjusteDto.class), any(TareaDto.class));
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    final TareaDto tarea = this.createTarea();
    final List<IdPersonaLocalDto> personas = this.createPersonas();
    assertThrows(RuntimeException.class,
        () -> {
          this.calculoAjusteBajaItService.ajustar(algoritmoAjuste, tarea,
              personas);
        });
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempPersonas();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempFechasBajaIt();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempFechasAcumuladasBajaIt();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempCalculoConAjuste();
  }

  private AlgoritmoAjusteDto createAlgoritmoAjuste() {
    final AlgoritmoAjusteDto algoritmoAjuste = new AlgoritmoAjusteDto();
    algoritmoAjuste.setId(1929);
    return algoritmoAjuste;
  }

  private List<IdPersonaLocalDto> createPersonas() {
    return Collections.singletonList(IdPersonaLocalDto
        .builder()
        .idPersonaLocal("ID PERSONA")
        .stdOrHrPeriod("OR PERSONA")
        .build());
  }

  private TareaDto createTarea() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(123L);
    return tarea;
  }

}
