package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class TareaPersonaEstructuraPoliticaDto implements Serializable {

    private static final long serialVersionUID = -4806531575285048264L;

    @ApiModelProperty(value = "Identificador de la persona estructura politica", required = false)
    private Long id;

    @NotNull
    @ApiModelProperty(value = "Identificador del tarea", required = true)
    private Long idTarea;

    @NotBlank
    @ApiModelProperty(value = "Id origen", required = true)
    private String idOrigen;

    @NotBlank
    @ApiModelProperty(value = "Id de la persona", required = true)
    private String idPersona;

    @NotBlank
    @ApiModelProperty(value = "Ordinal de la persona", required = true)
    private String orPersona;

    @NotBlank
    @ApiModelProperty(value = "Id local de la persona", required = true)
    private String idPersonaLocal;

    @NotNull
    @ApiModelProperty(value = "Id estructura asociada a la politica", required = true)
    private String idEstructuraPolitica;

    @NotNull
    @ApiModelProperty(value = "Id tipo politica", required = true)
    private String idTipoPolitica;

    @NotNull
    @ApiModelProperty(value = "Fecha de inicio en la politica", required = true)
    private Date fechaInicio;

    @NotNull
    @ApiModelProperty(value = "Fecha de fin en la politica", required = true)
    private Date fechaFin;

    @NotNull
    @ApiModelProperty(value = "Excluido deonminador", required = true)
    private Boolean excluidoDenominador;
}
