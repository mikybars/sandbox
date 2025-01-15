package com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
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
public class PtrPresenciaTiposHorasRequestDto implements Serializable {

  private static final long serialVersionUID = 8473916136604243658L;

  @NotNull
  private Integer origen;

  private Integer tipoHora;

  private Integer idCatalogoAplicacion;

  private Boolean incluidoVenta;

  private Boolean incluidoChallenge;

  private Boolean incluidoEcommerce;

  private Boolean excluidoDenom;

  private Boolean excluidoCalculo;

}
