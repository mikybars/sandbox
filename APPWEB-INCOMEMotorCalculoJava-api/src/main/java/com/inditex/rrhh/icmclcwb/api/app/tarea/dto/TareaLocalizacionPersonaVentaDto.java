package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;

public class TareaLocalizacionPersonaVentaDto implements Serializable {

    private static final long serialVersionUID = 2095913202391554577L;

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
    
//    @NotBlank// TODO: HABILITAR CUANDO AGRUPE CORRECTAMENTE
    @ApiModelProperty(value = "Id de la persona", required = true)
    private String idPersona;
       
    @NotNull
    @ApiModelProperty(value = "Importe sin iva de la venta", required = true)
    private Double importe;
    
    @ApiModelProperty(value = "Tipo importe venta", required = true)
    private Long idTipoImporteVenta;
}
