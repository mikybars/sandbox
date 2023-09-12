package com.inditex.rrhh.icmclcwb.ms.app.tarea;

/*
 * Copyright (c) 2021. Inditex
 */
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TareaPriorityEnum {
  PROGRAMADA(1, 2), MANUAL(2, 4), REENCOLADA(3, 6);

  private final Integer id;

  private final Integer priority;
}
