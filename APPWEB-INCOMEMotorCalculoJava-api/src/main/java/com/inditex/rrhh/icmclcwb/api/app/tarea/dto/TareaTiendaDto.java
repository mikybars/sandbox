package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import lombok.Data;
import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Data
public class TareaTiendaDto implements Serializable {

    private static final long serialVersionUID = -5607507260079003307L;

    @ApiModelProperty(value = "Identificador de la tienda", required = false)
    private String id;

    @NotNull
    @ApiModelProperty(value = "Tarea", required = true)
    private Long idTarea;

    @NotBlank
    @ApiModelProperty(value = "Id de la tienda", required = true)
    private String idTienda;

}