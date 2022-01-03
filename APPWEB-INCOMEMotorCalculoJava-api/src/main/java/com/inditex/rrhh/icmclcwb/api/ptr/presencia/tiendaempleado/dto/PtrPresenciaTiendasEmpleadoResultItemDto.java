package com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto;

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
public class PtrPresenciaTiendasEmpleadoResultItemDto {

  private Integer tienda;

  private Integer origen;

  private Integer empresa;

  private Integer cadena;

  private Integer gestionLocal;

}
