package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClaseResultItemDto implements Serializable {

  private static final long serialVersionUID = -5748711829300381625L;

  @NonNull
  private String idOrigen;

  @NonNull
  private String idClase;

  private List<String> idsEstadoSil;
}
