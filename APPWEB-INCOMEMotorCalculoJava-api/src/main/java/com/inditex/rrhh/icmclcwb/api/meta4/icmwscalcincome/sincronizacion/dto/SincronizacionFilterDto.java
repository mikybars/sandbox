package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SincronizacionFilterDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<SincronizacionFilterParametersDto> items;

}
