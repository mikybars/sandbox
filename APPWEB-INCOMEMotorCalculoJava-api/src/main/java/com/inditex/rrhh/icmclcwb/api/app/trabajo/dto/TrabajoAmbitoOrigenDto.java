package com.inditex.rrhh.icmclcwb.api.app.trabajo.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrabajoAmbitoOrigenDto {

    @ApiModelProperty(value = "Identificador del ambito origen del trabajo", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long id;

    @ApiModelProperty(value = "Identificador del ambito del trabajo", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long idTrabajo;

    @NotBlank
    @ApiModelProperty(value = "Id de la sociedad", required = true, example = "11")
    private String idOrigen;

}
