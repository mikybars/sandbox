package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CatalogoRequestDto implements Serializable {

  private static final long serialVersionUID = -2377342242871575415L;

  private String cclIdOrigen;

  private List<CatalogoRequestItemDto> items;

}
