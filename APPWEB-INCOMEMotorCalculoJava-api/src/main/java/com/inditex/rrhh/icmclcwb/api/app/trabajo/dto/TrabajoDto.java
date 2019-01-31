package com.inditex.rrhh.icmclcwb.api.app.trabajo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Modelo TrabajoDto")
@Data
@EqualsAndHashCode(callSuper = false)
public class TrabajoDto implements Serializable {

    private static final long serialVersionUID = -5607507260079003307L;

    @ApiModelProperty(value = "Identificador del trabajo", required = false, readOnly = true)
    private Long id;

    @ApiModelProperty(value = "Estado actual del trabajo", required = false, readOnly = true)
    private /* BigInteger */ EstadoTrabajoDto estado;

    @NotBlank
    @ApiModelProperty(value = "Id del páis origen a ejecutar", required = true)
    private String idPaisOrigen;

    @NotBlank
    @ApiModelProperty(value = "Id de la empresa a ejecutar", required = true)
    private String idEmpresa;

    @ApiModelProperty(value = "Ids de las tiendas a ejecutar", required = false)
    private List<TrabajoTiendaDto> tiendas;

    @ApiModelProperty(value = "Ids de los empleados a ejecutar", required = false)
    private List<TrabajoEmpleadoDto> empleados;

    @ApiModelProperty(value = "Id del usuario que solicito el trabajo", required = true, readOnly = true)
    private String idUsuario;

    @ApiModelProperty(value = "Fecha en la que se creo el trabajo", required = false, readOnly = true)
    private LocalDateTime fechaCreacion;

    @ApiModelProperty(value = "Fecha en la que se empieza a procesar", required = false, readOnly = true)
    private LocalDateTime fechaInicioTrabajo;

    @ApiModelProperty(value = "Fecha en la que se termina de procesar", required = false, readOnly = true)
    private LocalDateTime fechaFinTrabajo;

    @NotNull
    @ApiModelProperty(value = "Fecha inicio del periodo a procesar", required = true)
    private LocalDateTime fechaInicioPeriodo;

    @NotNull
    @ApiModelProperty(value = "Fecha fin del periodo a procesar", required = true)
    private LocalDateTime fechaFinPeriodo;

    @ApiModelProperty(value = "Programación asociada", required = false, readOnly = true)
    private Long idProgramacion;

}