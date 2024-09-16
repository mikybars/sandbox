package com.inditex.rrhh.icmclcwb.api.app.run.calcular.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;

import lombok.Data;

@Data
public class RunAlgoritmoDto implements Serializable {

  private static final long serialVersionUID = 3457685218214124882L;

  private AlgoritmoDto algoritmo;

  private String sqlCalcular;

}
