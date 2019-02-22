package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
public class TareaAmbitoDto {

    @ApiModelProperty(value = "Identificador del ambito origen de la tarea", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long id;

    @ApiModelProperty(value = "Identificador de la tarea", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long idTarea;

    @NotBlank
    @ApiModelProperty(value = "Id del origen", required = true, example = "11")
    private String idOrigen;
    
    @NotBlank
    @ApiModelProperty(value = "Id del catalogo", required = true, example = "11")
    private String idCatalogo;

}
