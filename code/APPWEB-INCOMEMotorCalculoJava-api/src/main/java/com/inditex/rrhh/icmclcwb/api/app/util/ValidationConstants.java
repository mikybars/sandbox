package com.inditex.rrhh.icmclcwb.api.app.util;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.List;

/**
 * Constantes relacionadas con validaciones y prevalidaciones de tareas.
 */
public class ValidationConstants {

  /**
   * IDs de acciones no bloqueantes que se ejecutan en paralelo desde RunValidacionesAgrupadasService. Estas acciones NO deben ejecutarse en
   * las prevalidaciones estándar para evitar duplicación.
   */
  public static final List<Integer> ID_ACCIONES_NO_BLOQUEANTES = List.of(32, 33, 34, 35, 36);

  private ValidationConstants() {
  }

}
