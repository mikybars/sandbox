package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;

@ApiModel(description = "Modelo TareaDto")
@Data
@EqualsAndHashCode(callSuper = false)
public class TareaDto implements Serializable {

    private static final long serialVersionUID = -5607507260079003307L;

    @ApiModelProperty(value = "Identificador del tarea", required = false, accessMode = AccessMode.READ_ONLY)
    private Long id;

    @ApiModelProperty(value = "Estado actual del tarea", required = false, accessMode = AccessMode.READ_ONLY)
    private /* BigInteger */ EstadoTareaDto estado;

    @NotBlank
    @ApiModelProperty(value = "Id del páis origen a ejecutar", required = true)
    private String idPaisOrigen;

    @NotBlank
    @ApiModelProperty(value = "Id de la empresa a ejecutar", required = true)
    private String idEmpresa;

    @ApiModelProperty(value = "Ids de las tiendas a ejecutar", required = false)
    private List<TareaTiendaDto> tiendas;

    @ApiModelProperty(value = "Ids de los empleados a ejecutar", required = false)
    private List<TareaEmpleadoDto> empleados;

    @ApiModelProperty(value = "Id del usuario que solicito el tarea", required = true, accessMode = AccessMode.READ_ONLY)
    private String idUsuario;

    @ApiModelProperty(value = "Fecha en la que se creo el tarea", required = false, accessMode = AccessMode.READ_ONLY)
    private LocalDateTime fechaCreacion;

    @ApiModelProperty(value = "Fecha en la que se empieza a procesar", required = false, accessMode = AccessMode.READ_ONLY)
    private LocalDateTime fechaInicioTarea;

    @ApiModelProperty(value = "Fecha en la que se termina de procesar", required = false, accessMode = AccessMode.READ_ONLY)
    private LocalDateTime fechaFinTarea;

    @NotNull
    @ApiModelProperty(value = "Fecha inicio del periodo a procesar", required = true)
    private LocalDateTime fechaInicioPeriodo;

    @NotNull
    @ApiModelProperty(value = "Fecha fin del periodo a procesar", required = true)
    private LocalDateTime fechaFinPeriodo;

    @ApiModelProperty(value = "Programación asociada", required = false, accessMode = AccessMode.READ_ONLY)
    private Long idProgramacion;

}