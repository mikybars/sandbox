package com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PtrVentaTotalizadoResponseDto implements Serializable {

  private static final long serialVersionUID = -2758503405995399894L;

  private List<PtrVentaTotalizadoResultItemDto> ventaTotalizado;

}
