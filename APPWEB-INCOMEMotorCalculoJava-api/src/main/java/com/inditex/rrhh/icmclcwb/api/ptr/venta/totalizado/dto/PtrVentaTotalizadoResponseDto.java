package com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaTotalizadoResponseDto implements Serializable {

    private static final long serialVersionUID = -2758503405995399894L;

    private List<PtrVentaTotalizadoResultItemDto> ventaTotalizado;

}
