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
public class IdTipoDatoDto implements Serializable {

  private static final long serialVersionUID = 3630643129878733468L;

  private Integer id;

}
