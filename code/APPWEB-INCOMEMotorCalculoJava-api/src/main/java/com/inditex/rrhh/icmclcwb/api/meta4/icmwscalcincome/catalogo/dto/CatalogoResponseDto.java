package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogoResponseDto implements Serializable {

  private static final long serialVersionUID = 8369468264518702285L;

  private List<CatalogoResultItemDto> items;

}
