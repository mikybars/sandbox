package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClaseResponseDto implements Serializable {

  private static final long serialVersionUID = -7332459724856163420L;

  private List<ClaseResultItemDto> items;
}
