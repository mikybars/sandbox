package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class PresenciaOrigenDto implements Serializable {

  private Integer horasSeccion1;

  private Integer horasSeccion2;

  private Integer horasSeccion3;

  private Integer horasSeccion4;

}
