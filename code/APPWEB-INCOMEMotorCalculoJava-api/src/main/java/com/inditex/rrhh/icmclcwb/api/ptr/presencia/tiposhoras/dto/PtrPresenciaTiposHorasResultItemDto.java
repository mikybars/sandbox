package com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto;

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
public class PtrPresenciaTiposHorasResultItemDto implements Serializable {

  private static final long serialVersionUID = -4840963129306061376L;

  private Integer origen;

  private Integer tipoHora;

  private Integer idCatalogoAplicacion;

  private Boolean excluidoDenom;

  private Boolean excluidoCalculo;

  private Boolean incluidoVenta;

  private Boolean incluidoChallenge;

  private Boolean incluidoEcommerce;

}
