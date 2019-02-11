package com.inditex.rrhh.icmclcwb.api.app.programacion.dto;

import lombok.Data;
import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;

@Data
public class ProgramacionTiendaDto implements Serializable {

    private static final long serialVersionUID = -5607507260079003307L;

    @ApiModelProperty(value = "Identificador", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private String id;

    @ApiModelProperty(value = "Programación", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long idProgramacion;

    @NotBlank
    @ApiModelProperty(value = "Id de la tienda", required = true, example = "56")
    private String idTienda;

}