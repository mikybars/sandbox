package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
public class TareaAmbitoGlobalEmpresaDto implements Serializable {

    @ApiModelProperty(value = "Identificador de la entidad", required = false, accessMode = AccessMode.READ_ONLY)
    private Long id;

    @NotNull
    @ApiModelProperty(value = "Tarea", required = true)
    private Long idTarea;
    
    @NotBlank
    @ApiModelProperty(value = "Identificador del origen", required = true)
    private String cclIdOrigen;

    @NotBlank
    @ApiModelProperty(value = "Identificador de la empresa", required = true)
    private String stdIdLegEnt;

}
