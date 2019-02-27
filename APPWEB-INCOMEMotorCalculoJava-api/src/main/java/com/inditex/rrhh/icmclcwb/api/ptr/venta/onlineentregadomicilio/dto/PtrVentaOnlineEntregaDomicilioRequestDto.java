package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;

import lombok.Data;

@Data
public class PtrVentaOnlineEntregaDomicilioRequestDto implements Serializable {
    
    private static final long serialVersionUID = 233324946532771844L;

    @NotNull
    private String fechaDesde;
    
    @NotNull
    private String fechaHasta;

    private Integer pais;

    private Integer cadena;
    
    private Integer empresa;
    
    private List<Integer> tiendaOnline = new ArrayList<>();

    private Integer seccion;
    
    private PtrGroupTypeEnum agrupacion;
}
