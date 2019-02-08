package com.inditex.rrhh.icmclcwb.api.ptr.venta.ventadiaria.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PtrVentaDiariaRequestDto implements Serializable {

    private static final long serialVersionUID = 4713111931960404447L;

    @NotNull
    private Integer idTienda;
    
    @NotNull
    private String fechaInicio;

    @NotNull
    private String fechaFin;

    @NotNull
    private List<Integer> idTipoSeccion = new ArrayList<>();


}
