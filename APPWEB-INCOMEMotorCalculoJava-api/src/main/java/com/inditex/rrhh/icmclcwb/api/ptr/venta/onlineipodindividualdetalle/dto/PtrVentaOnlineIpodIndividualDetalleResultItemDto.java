package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineIpodIndividualDetalle;

import lombok.Data;

@Data
public class PtrVentaOnlineIpodIndividualDetalleResultItemDto implements Serializable {

    private static final long serialVersionUID = -2372872440652586406L;

    @NotBlank
    private String fecha;

    private Integer pais;

    private Integer cadena;
    
    private Integer empresa;

    @NotBlank
    private Integer tienda;

    private Integer seccion;

    private List<Integer> vendedores;
    
    private String operacion;
    
    private List<PtrSeccionVentaOnlineIpodIndividualDetalle> listaSeccion;
}
