package com.inditex.rrhh.icmclcwb.api.app.programacion.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
public class ProgramacionAmbitoEmpresaDto {

    @ApiModelProperty(value = "Identificador del ambito empresa de la programación", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long id;

    @ApiModelProperty(value = "Identificador del ambito de la programación", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long idProgramacionAmbito;

    @NotBlank
    @ApiModelProperty(value = "Id de la empresa", required = true, example = "8")
    private String idEmpresa;

}
