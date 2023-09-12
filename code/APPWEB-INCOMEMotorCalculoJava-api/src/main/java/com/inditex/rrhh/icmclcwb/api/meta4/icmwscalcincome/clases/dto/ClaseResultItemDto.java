package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClaseResultItemDto implements Serializable {

  private static final long serialVersionUID = -5748711829300381625L;

  @NotNull
  private String idOrigen;

  @NotNull
  private String idClase;

  private List<String> idsEstadoSil;
}
