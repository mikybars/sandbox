package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

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

    private Integer seccion;
    
    private List<Integer> tiendaOnline = new ArrayList<>();
}
