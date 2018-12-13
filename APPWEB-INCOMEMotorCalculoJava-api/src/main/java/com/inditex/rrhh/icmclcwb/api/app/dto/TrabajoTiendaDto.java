package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.Data;
import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Data
public class TrabajoTiendaDto implements Serializable {

    private static final long serialVersionUID = -5607507260079003307L;

    @ApiModelProperty(value = "Identificador de la tienda", required = false)
    private String id;

    @NotNull
    @ApiModelProperty(value = "Trabajo", required = true)
    private Long idTrabajo;

    @NotBlank
    @ApiModelProperty(value = "Id de la tienda", required = true)
    private String idTienda;

}