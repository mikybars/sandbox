package com.inditex.rrhh.icmclcwb.api.ptr.presencia;

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
public class PtrSeccionPresenciasGenericType implements Serializable {

  private static final long serialVersionUID = -457548242622897810L;

  private Integer seccion;

  private Integer minutos;

}
