package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;

public class TareaTiendaVentaDto implements Serializable {

    private static final long serialVersionUID = 7346380084790080025L;

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
    @ApiModelProperty(value = "Importe sin iva de la venta", required = true)
    private Double importe;
    
    @ApiModelProperty(value = "Tipo importe venta", required = true)
    private Long idTipoImporteVenta;
}
