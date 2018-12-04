package com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PtrVentaTotalizadoRequestDto implements Serializable {

    private static final long serialVersionUID = -529195772706345954L;

    @NotNull
    private String fechaDesde;

    @NotNull
    private String fechaHasta;

    @NotNull
    private String pais;

    // TODO: XSD simple Postman permite multiple
    @NotNull
    private List<String> cadena;

    private List<String> tienda;

    private String agrupacion;

}
