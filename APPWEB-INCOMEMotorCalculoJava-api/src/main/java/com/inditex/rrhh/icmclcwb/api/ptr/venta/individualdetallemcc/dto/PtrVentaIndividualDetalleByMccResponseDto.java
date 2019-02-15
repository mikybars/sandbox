package com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetallemcc.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaIndividualDetalleByMccResponseDto implements Serializable {

    private static final long serialVersionUID = 6981788689203255861L;
    private List<PtrVentaIndividualDetalleByMccResultItemDto> ventaIndividualDetalleByMCC;

}
