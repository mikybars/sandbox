package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;

import lombok.Data;

@Data
public class PtrVentaOnlinePickingRequestDto implements Serializable {
    
    private static final long serialVersionUID = 7536621533080093360L;

    @NotNull
    private String fechaDesde;
    
    @NotNull
    private String fechaHasta;

    private Integer pais;

    private Integer cadena;
    
    private Integer empresa;
    
    private List<Integer> tiendaOnline = new ArrayList<>();

    private List<Integer> tienda = new ArrayList<>();
    
    private Integer seccion;
    
    private PtrGroupTypeEnum agrupacion;
}
