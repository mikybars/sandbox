package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;

public class TareaLocalizacionVentaDto implements Serializable {

    private static final long serialVersionUID = -1628018951831382514L;
    
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
    
    @NotBlank
    @ApiModelProperty(value = "Id de la seccion", required = true)
    private String idSeccion;
    
    @NotNull
    @ApiModelProperty(value = "Importe sin iva de la venta en la seccion 1", required = true)
    private Double importe;
    
    @NotNull
    @ApiModelProperty(value = "Importe con iva de la venta en la seccion 1", required = true)
    private Double importeConImpuestos;
    
    @ApiModelProperty(value = "Tipo importe venta", required = true)
    private Long idTipoImporteVenta;
    
    @NotNull
    @ApiModelProperty(value = "Flag activo", required = true)
    private Boolean activo; 

}
