package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TareaLocalizacionPresupuestoVentaDto implements Serializable {

    @ApiModelProperty(value = "Identificador de la entidad", required = false)
    private String id;

    @NotNull
    @ApiModelProperty(value = "Identificador del tarea", required = true)
    private Long idTarea;
    
    @NotBlank
    @ApiModelProperty(value = "Identificador de la localizacion", required = true)
    private String stdIdWorkLocat;
    
    @NotNull
    @ApiModelProperty(value = "Identificador de la localizacion", required = true)
    private Long cclIdCodOrigen;
    
    @NotBlank
    @ApiModelProperty(value = "Id de la seccion", required = true)
    private String cclIdSeccion;
    
    @NotNull
    private Integer ordinal;
    
    @NotNull
    @ApiModelProperty(value = "Importe sin impuestos", required = true)
    private Double importeSinImpuestos;
    
    @NotNull
    @ApiModelProperty(value = "Importe con impuestos", required = true)
    private Double importeConImpuestos;
    
    @ApiModelProperty(value = "Tipo presupuesto", required = true)
    private Integer idTipoPresupuesto;
    
    @NotBlank
    @ApiModelProperty(value = "Id de concepto venta", required = true)
    private String icmIdConceptoVenta;
    
    @NotBlank
    @ApiModelProperty(value = "Id de origen", required = true)
    private String cclIdOrigen;
    
    @NotNull
    @ApiModelProperty(value = "Flag activo", required = true)
    private Boolean activo;

    @NotNull
    @ApiModelProperty(value = "Id de tipo de dato", required = true)
    private Integer idTipoDato;
}
