package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MotivosDesplazamientoResponseDto implements Serializable {

  private static final long serialVersionUID = -8746827304482711682L;

  private List<MotivosDesplazamientoItemDto> items;

}
