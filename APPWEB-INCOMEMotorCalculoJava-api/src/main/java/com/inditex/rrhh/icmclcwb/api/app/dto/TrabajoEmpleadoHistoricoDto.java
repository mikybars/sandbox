package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
public class TrabajoEmpleadoHistoricoDto implements Serializable {

    private static final long serialVersionUID = 1168987218682802281L;

    @ToString.Exclude
    @ApiModelProperty(value = "Identificador del empleado", required = false)
    private String id;
    
    @ToString.Exclude
    @NotNull
    @ApiModelProperty(value = "Identificador del trabajo", required = true)
    private Long idTrabajo;
    
    @NotBlank
    @ApiModelProperty(value = "Id del empleado", required = true)
    private String idEmpleado;

    @NotBlank
    private String orEmpleado;
    
    @NotBlank
    private String idEmpleadoLocal;
    
    @NotBlank
    private String idTienda;

    @NotBlank
    private String idTiendaMeta4;
    
    @NotNull
    private Date fechaInicio;

    @NotNull
    private Date fechaFin;
}
