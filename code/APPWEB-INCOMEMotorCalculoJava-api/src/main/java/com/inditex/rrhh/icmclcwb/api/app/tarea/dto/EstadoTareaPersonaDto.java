package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EstadoTareaPersonaDto implements Serializable {

  private static final long serialVersionUID = 690542159104929423L;

  private Integer id;

}
