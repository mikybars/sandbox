package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
public class TareaTiendaEmpleadoPresenciaSeccionDto implements Serializable {
    
    private static final long serialVersionUID = 8468136189566031963L;
    
    @ApiModelProperty(value = "Identificador de la entidad", required = false, accessMode = AccessMode.READ_ONLY)
    private Long id;
    
    @NotNull
    @ApiModelProperty(value = "Tarea", required = true)
    private TareaDto tarea;
    
    @ApiModelProperty(value = "Fecha en la que se consultó la presencia", required = true, accessMode = AccessMode.READ_ONLY)
    private LocalDate fecha;
    
    @NotBlank
    @ApiModelProperty(value = "Id de la tienda", required = true)
    private String idTienda; 
 
    @NotBlank
    @ApiModelProperty(value = "Id de empleado", required = true)
    private String idEmpleado;
    
    @NotNull
    @ApiModelProperty(value = "Tiempo seccion 1", required = false, accessMode = AccessMode.READ_ONLY)
    private Long minutos1;
    
    @NotNull
    @ApiModelProperty(value = "Tiempo seccion 2", required = false, accessMode = AccessMode.READ_ONLY)
    private Long minutos2;
    
    @NotNull
    @ApiModelProperty(value = "Tiempo seccion 3", required = false, accessMode = AccessMode.READ_ONLY)
    private Long minutos3;
    
    @NotNull
    @ApiModelProperty(value = "Tarea - Tipo Hora", required = true)
    private TareaTipoHoraDto tareaTipoHoraDto;
    
    @ApiModelProperty(value = "Flag activa", required = true)
    private Boolean activo;

}
