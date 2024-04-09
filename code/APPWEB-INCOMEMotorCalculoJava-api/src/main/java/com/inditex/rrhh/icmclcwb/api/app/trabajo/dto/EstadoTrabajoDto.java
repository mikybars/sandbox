package com.inditex.rrhh.icmclcwb.api.app.trabajo.dto;

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
public class EstadoTrabajoDto implements Serializable {

  private static final long serialVersionUID = -7864441917446430800L;

  private Integer id;

}
