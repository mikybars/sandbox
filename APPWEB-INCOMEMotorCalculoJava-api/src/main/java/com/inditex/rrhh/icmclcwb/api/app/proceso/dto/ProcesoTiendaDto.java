package com.inditex.rrhh.icmclcwb.api.app.proceso.dto;

import lombok.Data;
import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Data
public class ProcesoTiendaDto implements Serializable {

    private static final long serialVersionUID = -5607507260079003307L;

    @ApiModelProperty(value = "Identificador de la tienda", required = false)
    private String id;

    @NotNull
    @ApiModelProperty(value = "Proceso", required = true)
    private Long idProceso;

    @NotBlank
    @ApiModelProperty(value = "Id de la tienda", required = true)
    private String idTienda;

}