/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoComision;

import org.junit.jupiter.api.Test;

class TareaCalculoAjusteComisionTest {

  @Test
  void cclIdPersonTest() {

    final TareaCalculoAjusteComision entity = new TareaCalculoAjusteComision();
    final String texto = "PERSONA";
    entity.setCclIdPerson(texto);

    assertEquals(texto, entity.getCclIdPerson());
  }

  @Test
  void stdOrHrPeriodTest() {

    final TareaCalculoAjusteComision entity = new TareaCalculoAjusteComision();
    final String texto = "ORDINAL";
    entity.setStdOrHrPeriod(texto);

    assertEquals(texto, entity.getStdOrHrPeriod());
  }

  @Test
  void importeTest() {

    final TareaCalculoAjusteComision entity = new TareaCalculoAjusteComision();
    final BigDecimal importe = new BigDecimal("12.233");
    entity.setImporte(importe);

    assertEquals(importe, entity.getImporte());
  }

  @Test
  void tipoComisionTest() {

    final TareaCalculoAjusteComision entity = new TareaCalculoAjusteComision();
    final TipoComision comision = new TipoComision();
    comision.setId("001");
    entity.setTipoComision(comision);

    assertEquals(comision, entity.getTipoComision());
  }

  @Test
  void tareaTest() {

    final TareaCalculoAjusteComision entity = new TareaCalculoAjusteComision();
    final Tarea tarea = new Tarea();
    tarea.setId(12L);
    entity.setTarea(tarea);

    assertEquals(tarea, entity.getTarea());
  }

  @Test
  void pkTest() {

    final TareaCalculoAjusteComision entity = new TareaCalculoAjusteComision();
    final TareaCalculoAjusteComisionPk pk = new TareaCalculoAjusteComisionPk();
    pk.setId(8989L);
    entity.setPk(pk);

    assertEquals(pk, entity.getPk());
  }

}
