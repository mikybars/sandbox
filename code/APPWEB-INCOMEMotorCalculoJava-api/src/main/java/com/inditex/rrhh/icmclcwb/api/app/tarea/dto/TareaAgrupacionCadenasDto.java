package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TareaAgrupacionCadenasDto implements Serializable {

  private static final long serialVersionUID = -519102628504860525L;

  private Long id;

  private List<String> cadenas;

}
