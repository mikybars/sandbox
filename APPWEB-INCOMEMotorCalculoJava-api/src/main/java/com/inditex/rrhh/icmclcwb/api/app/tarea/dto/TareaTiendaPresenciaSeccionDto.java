package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
public class TareaTiendaPresenciaSeccionDto implements Serializable{

    private static final long serialVersionUID = -6629736646011201562L;

    @ApiModelProperty(value = "Identificador de la entidad", required = false, accessMode = AccessMode.READ_ONLY)
    private Long id;
    
    @NotNull
    @ApiModelProperty(value = "Tarea", required = true)
    private Long idTarea;
    
    @ApiModelProperty(value = "Fecha en la que se consultó la venta", required = true, accessMode = AccessMode.READ_ONLY)
    private LocalDate fecha;
    
    @NotBlank
    @ApiModelProperty(value = "Id de la tienda", required = true)
    private String idTienda;
    
    @NotNull
    @ApiModelProperty(value = "Tiempo seccion 1", required = false, accessMode = AccessMode.READ_ONLY)
    private Long minutos1;
    
    @NotNull
    @ApiModelProperty(value = "Tiempo seccion 2", required = false, accessMode = AccessMode.READ_ONLY)
    private Long minutos2;
    
    @NotNull
    @ApiModelProperty(value = "Tiempo seccion 3", required = false, accessMode = AccessMode.READ_ONLY)
    private Long minutos3;
    
}
