package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@ApiModel(description = "Modelo TareaLimpiezaDto")
@Data
public class TareaLimpiezaDto implements Serializable {

    private static final long serialVersionUID = -170294147407207684L;

    @NotNull
    @ApiModelProperty(value = "Identificador del tarea", required = true)
    private Long idTarea;

    @ApiModelProperty(value = "Fecha en la que se realizó la limpieza", required = false,
            accessMode = AccessMode.READ_ONLY, hidden = true)
    private LocalDateTime fechaHoraLimpieza;

    @ApiModelProperty(value = "Nombre del usuario que solicito la limpieza", required = false,
            accessMode = AccessMode.READ_ONLY, hidden = true, example = "IAGOML")
    private String nombreUsuario;

    @NotNull
    @ApiModelProperty(value = "Flag que indica si se trata de una limpieza completa", required = true)
    private Boolean esCompleta;

    @NotNull
    @ApiModelProperty(value = "Flag que indica si se trata de una limpieza parcial", required = true)
    private Boolean esParcial;

}
