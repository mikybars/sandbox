package com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class RunTareaLocalizacionDto implements Serializable {

    private static final long serialVersionUID = -2999803240189313755L;
    
    @NotBlank
    private String idOrigen;

    @NotBlank
    private String idEmpresa;
    
    @NotBlank
    private String idCadena;

    @NotBlank
    private String idLocalizacion;
    
    @NotBlank
    private String idLocalizacionLocal;

}
