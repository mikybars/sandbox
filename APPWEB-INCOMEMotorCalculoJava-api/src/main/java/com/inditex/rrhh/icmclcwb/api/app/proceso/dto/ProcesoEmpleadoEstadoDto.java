package com.inditex.rrhh.icmclcwb.api.app.proceso.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class ProcesoEmpleadoEstadoDto implements Serializable {

    private static final long serialVersionUID = -5607507260079003307L;

    @EqualsAndHashCode.Exclude
    @ApiModelProperty(value = "Identificador", required = false)
    private String id;

    @EqualsAndHashCode.Exclude
    @NotNull
    @ApiModelProperty(value = "Proceso", required = true)
    private Long idProceso;

    @NotBlank
    @ApiModelProperty(value = "Id del empleado", required = true)
    private String idEmpleado;

    @NotBlank
    @ApiModelProperty(value = "Ordinal del empleado", required = true)
    private String orEmpleado;
    
    @NotBlank
    @ApiModelProperty(value = "Id del empleado", required = true)
    private String idEmpleadoLocal;

    @EqualsAndHashCode.Exclude
    @NotNull
    @ApiModelProperty(value = "Estado del empleado en la operación", required = true)
    private EstadoProcesoEmpleadoDto estado;

}