package com.inditex.rrhh.icmclcwb.api.app.dto;

/*
 * Copyright (c) 2022. Inditex
 */
import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class IdTareaFaseDto implements Serializable {

  private static final long serialVersionUID = 5877004626774810613L;

  @NotBlank
  private String idTareaFase;

}
