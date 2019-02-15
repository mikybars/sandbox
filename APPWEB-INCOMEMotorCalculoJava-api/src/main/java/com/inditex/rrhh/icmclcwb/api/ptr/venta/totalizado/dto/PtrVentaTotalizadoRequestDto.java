package com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;

import lombok.Data;

@Data
public class PtrVentaTotalizadoRequestDto implements Serializable {

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

    private PtrGroupTypeEnum agrupacion;
    
    

}
