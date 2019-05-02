package com.inditex.rrhh.icmclcwb.api.app.periodo.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
public class PeriodoLocalizacionPersonaDto {

    @ApiModelProperty(value = "Identificador del periodo", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long idPeriodo;

    @ApiModelProperty(value = "Identificador del origen", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long idOrigen;

    @ApiModelProperty(value = "Identificador de la empresa", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long idEmpresa;

    @ApiModelProperty(value = "Identificador de la localizacion", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long idLocalizacion;
    
    @ApiModelProperty(value = "Identificador de la persona", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long idPersona;
    
}
