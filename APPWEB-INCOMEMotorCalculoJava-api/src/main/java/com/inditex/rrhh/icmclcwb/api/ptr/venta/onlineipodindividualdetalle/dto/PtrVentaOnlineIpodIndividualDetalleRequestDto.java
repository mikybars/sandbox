package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupSellerTypeEnum;

import lombok.Data;

@Data
public class PtrVentaOnlineIpodIndividualDetalleRequestDto implements Serializable {

    private static final long serialVersionUID = -7476782901000109281L;

    @NotNull
    private String fechaDesde;
    
    @NotNull
    private String fechaHasta;

    private Integer pais;

    private Integer cadena;
    
    private Integer empresa;
    
    private List<Integer> tiendaOnline = new ArrayList<>();

    private List<Integer> tienda = new ArrayList<>();
    
    private List<Integer> seccion = new ArrayList<>();

    private List<Integer> vendedores = new ArrayList<>();
    
    private String operacion;

    private PtrGroupSellerTypeEnum agrupacion;
}
