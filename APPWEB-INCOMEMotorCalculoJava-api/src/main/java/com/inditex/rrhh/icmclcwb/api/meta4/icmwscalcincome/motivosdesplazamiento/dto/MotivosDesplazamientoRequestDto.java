package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MotivosDesplazamientoRequestDto implements Serializable {

  private static final long serialVersionUID = -693259473153416287L;

  private List<MotivosDesplazamientoRequestItemDto> items;

}
