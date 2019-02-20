package com.inditex.rrhh.icmclcwb.api.app.programacion.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
public class ProgramacionAmbitoDto {

    @ApiModelProperty(value = "Identificador del ambito de la programación", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long id;

    @ApiModelProperty(value = "Identificador de la programación", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long idProgramacion;

    @NotBlank
    @ApiModelProperty(value = "Id de la sociedad", required = true, example = "0001")
    private String idSociedad;

    private List<ProgramacionAmbitoOrigenDto> origen;

    private List<ProgramacionAmbitoEmpresaDto> empresa;

    private List<ProgramacionAmbitoPersonaDto> persona;

    private List<ProgramacionAmbitoLocalizacionDto> localizacion;

}
