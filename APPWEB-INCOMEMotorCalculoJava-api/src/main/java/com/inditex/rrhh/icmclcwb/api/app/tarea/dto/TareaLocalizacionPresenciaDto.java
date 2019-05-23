package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
public class TareaLocalizacionPresenciaDto implements Serializable {

    private static final long serialVersionUID = 7784542525634439198L;

    @ApiModelProperty(value = "Identificador de la entidad", required = false, accessMode = AccessMode.READ_ONLY)
    private Long id;
    
    @NotNull
    @ApiModelProperty(value = "Tarea", required = true)
    private Long idTarea;
    
    @ApiModelProperty(value = "Fecha en la que se consultó la venta", required = true, accessMode = AccessMode.READ_ONLY)
    private LocalDate fecha;
    
    @NotBlank
    @ApiModelProperty(value = "Id de la localizacion", required = true)
    private String idLocalizacion;
    
    @NotNull
    @ApiModelProperty(value = "Tiempo", required = false, accessMode = AccessMode.READ_ONLY)
    private Long minutos;
    
    @NotNull
    @ApiModelProperty(value = "Tipo de dato", required = true)
    private Long idTipoDato;
    
    @NotNull
    @ApiModelProperty(value = "Flag activo", required = true)
    private Boolean activo; 
}
