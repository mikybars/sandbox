/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

class TareaCalculoAjusteComisionPkTest {

  @Test
  void idTest() {

    final TareaCalculoAjusteComisionPk pk = new TareaCalculoAjusteComisionPk();
    pk.setId(8989L);

    assertEquals(8989L, pk.getId());
  }

  @Test
  void fechaInicioPeriodoTest() {

    final TareaCalculoAjusteComisionPk pk = new TareaCalculoAjusteComisionPk();
    final Date date = new Date();
    pk.setFechaInicioPeriodo(date);

    assertEquals(date, pk.getFechaInicioPeriodo());
  }

}
