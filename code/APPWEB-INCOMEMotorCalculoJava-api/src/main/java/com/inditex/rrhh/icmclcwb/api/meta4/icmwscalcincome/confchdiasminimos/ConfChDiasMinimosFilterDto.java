package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ConfChDiasMinimosFilterDto implements Serializable {

  private static final long serialVersionUID = -496921289540066156L;

  private LocalDateTime fechaInicio;

  private LocalDateTime fechaFin;

  private String idOrigen;

  private List<ConfChDiasMinimosFilterParametersDto> item;

}
