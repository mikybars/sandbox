package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
	
@ApiModel(description = "Modelo TrabajoRunDto")
@Data
@EqualsAndHashCode(callSuper=false)
public class TrabajoRunDto implements Serializable {

    private static final long serialVersionUID = 8443425889094187729L;

    private final TrabajoRunDatosDto trabajoRunDatos = new TrabajoRunDatosDto();
    
    private final TrabajoRunDatosAuditoriaDto trabajoRunDatosAuditoria = new TrabajoRunDatosAuditoriaDto();

}
