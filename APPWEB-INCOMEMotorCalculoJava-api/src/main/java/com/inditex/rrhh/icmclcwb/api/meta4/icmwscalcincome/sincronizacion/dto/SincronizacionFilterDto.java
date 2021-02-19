package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class SincronizacionFilterDto implements Serializable {

    private static final long serialVersionUID = 1L ;

    private List<SincronizacionFilterParametersDto> items;

}
