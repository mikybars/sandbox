package com.inditex.rrhh.icmclcwb.api.ptr.venta.acumulada.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrObtenerVentaAcumuladaRequestDto implements Serializable{

    private static final long serialVersionUID = -8462764353425130134L;
    
    private String fechaHoraInicio;
    
    private String fechaHoraFin;
    
    private List<Integer> cadena;
    
    private List<Integer> pais;
    
    private Integer online;
    
    private Integer ventaComercial;
}
