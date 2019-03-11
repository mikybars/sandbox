package com.inditex.rrhh.icmclcwb.api.ptr.venta;

import java.util.List;

import lombok.Data;

@Data
public class PtrSeccionVentaOnlineIpodIndividualDetalle {

    private Integer seccion;
    
    private List<Integer> vendedores;
}
