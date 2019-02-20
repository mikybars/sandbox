package com.inditex.rrhh.icmclcwb.api.ptr.venta.acumulada.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrObtenerVentaAcumuladaResponseDto implements Serializable {
    
    private static final long serialVersionUID = 1736601549392040680L;

    private List<PtrObtenerVentaAcumuladaResultItemDto> datoVentaTienda;
}
