package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TrabajoTiendaComisionHistoricoDto implements Serializable {

    private static final long serialVersionUID = -3399439349202382151L;

    @ApiModelProperty(value = "Identificador de la tienda", required = false)
    private Long id;

    @NotNull
    @ApiModelProperty(value = "Identificador del trabajo", required = true)
    private Long idTrabajo;
    
    @NotBlank
    @ApiModelProperty(value = "Id de la tienda", required = true)
    private String idTienda;

    @NotBlank
    private String idTiendaMeta4;

    @NotNull
    private LocalDateTime fechaInicio;

    @NotNull
    private LocalDateTime fechaFin;

    @NotNull
    private Boolean comisionable;
}
