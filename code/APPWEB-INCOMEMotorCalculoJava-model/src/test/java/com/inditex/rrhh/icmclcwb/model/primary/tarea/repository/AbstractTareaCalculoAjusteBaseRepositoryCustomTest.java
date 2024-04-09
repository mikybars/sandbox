package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class AbstractTareaCalculoAjusteBaseRepositoryCustomTest {

  @Spy
  @InjectMocks
  private AbstractTareaCalculoAjusteBaseRepositoryCustom abstractTareaCalculoAjusteBaseRepositoryCustom = this.getClassMock();

  private AbstractTareaCalculoAjusteBaseRepositoryCustom getClassMock() {
    return Mockito.mock(AbstractTareaCalculoAjusteBaseRepositoryCustom.class, Mockito.CALLS_REAL_METHODS);
  }

  @Test
  void ajustarSqlAjustarNullTest(@Random final AlgoritmoAjusteDto algoritmoAjuste) {

    doReturn(null).when(this.abstractTareaCalculoAjusteBaseRepositoryCustom).getSqlAjustar();

    this.abstractTareaCalculoAjusteBaseRepositoryCustom.ajustar(algoritmoAjuste, new TareaDto());

    verify(this.abstractTareaCalculoAjusteBaseRepositoryCustom, times(1)).ajustar(algoritmoAjuste, new TareaDto());

  }

  @Test
  void getSqlAjustarTest(@Random final AlgoritmoAjusteDto algoritmoAjuste) {

    doReturn("sql").when(this.abstractTareaCalculoAjusteBaseRepositoryCustom).getSqlAjustarBase();

    final String result = this.abstractTareaCalculoAjusteBaseRepositoryCustom.getSqlAjustar(algoritmoAjuste);

    assertNotNull(result);
  }

  @Test
  void getSqlAjustarSqlAjustarBaseNullTest(@Random final AlgoritmoAjusteDto algoritmoAjuste) {

    doReturn(null).when(this.abstractTareaCalculoAjusteBaseRepositoryCustom).getSqlAjustarBase();

    final String result = this.abstractTareaCalculoAjusteBaseRepositoryCustom.getSqlAjustar(algoritmoAjuste);

    assertNull(result);
    verify(this.abstractTareaCalculoAjusteBaseRepositoryCustom, times(1)).getSqlAjustar(algoritmoAjuste);
  }

}
