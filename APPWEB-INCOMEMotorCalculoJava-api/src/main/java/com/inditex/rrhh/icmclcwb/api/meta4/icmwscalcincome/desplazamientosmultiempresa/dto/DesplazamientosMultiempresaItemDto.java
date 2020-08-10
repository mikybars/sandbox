package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class DesplazamientosMultiempresaItemDto implements Serializable {

    private static final long serialVersionUID = -4731031654989577515L;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFin;

    private String idOrigen;

    private String idEmpresa;

}
