package com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizadoxml.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PtrVentaTotalizadoXmlRequestDto implements Serializable {

    private static final long serialVersionUID = -529195772706345954L;

    @NotNull
    private String fechaDesde;

    @NotNull
    private String fechaHasta;

    @NotNull
    private Integer pais;

    @NotNull
    private Integer cadena;

    private List<String> tienda = new ArrayList<>();
    
    private Integer seccion;
    
    private Integer temporada;
    
    private Integer producto;

    private String agrupacion;
    
    

}
