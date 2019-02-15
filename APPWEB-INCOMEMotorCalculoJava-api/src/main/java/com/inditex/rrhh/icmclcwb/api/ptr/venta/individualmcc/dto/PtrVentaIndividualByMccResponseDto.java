package com.inditex.rrhh.icmclcwb.api.ptr.venta.individualmcc.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaIndividualByMccResponseDto implements Serializable {

    private static final long serialVersionUID = -6508621508939069160L;
    
    private List<PtrVentaIndividualByMccResultItemDto> ventaIndividualByMCC;

}
