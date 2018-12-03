package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import groovy.transform.builder.Builder;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "Modelo TrabajoRunDto")
@Data
@Builder
public class TrabajoRunDto implements Serializable {

    private static final long serialVersionUID = 8443425889094187729L;

    @NotNull
    private TrabajoDto trabajoDto;
    
    private final TrabajoRunDatosDto trabajoRunDatos = new TrabajoRunDatosDto();

}
