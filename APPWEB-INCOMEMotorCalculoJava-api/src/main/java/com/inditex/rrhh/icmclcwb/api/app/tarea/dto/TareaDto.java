package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;

@ApiModel(description = "Modelo TareaDto")
@Data
public class TareaDto implements Serializable {

    private static final long serialVersionUID = -7287619714621366577L;

    @ApiModelProperty(value = "Identificador de la tarea", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long id;

    @ApiModelProperty(value = "Estado actual de la tarea", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private /* BigInteger */ EstadoTareaDto estado;

    @ApiModelProperty(value = "Trabajo asociado", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long idTrabajo;

    @ApiModelProperty(value = "Fecha en la que se creo el tarea", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private LocalDateTime fechaCreacion;

    @ApiModelProperty(value = "Fecha en la que se empieza a procesar la tarea", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private LocalDateTime fechaInicioTarea;

    @ApiModelProperty(value = "Fecha en la que se termina de procesar la tarea", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private LocalDateTime fechaFinTarea;

    @NotBlank
    @ApiModelProperty(value = "Id de la sociedad", required = true, example = "0001")
    private String idSociedad;

    @NotBlank
    @ApiModelProperty(value = "Id de la empresa", required = true, example = "8")
    private String idEmpresa;

    @ApiModelProperty(value = "Ambito de la tarea", required = false)
    private List<TareaAmbitoDto> ambito;

    @ApiModelProperty(value = "Ambito persona de la tarea", required = false)
    private List<TareaAmbitoPersonaDto> persona;

    @ApiModelProperty(value = "Ambito localizacion de la tarea", required = false)
    private List<TareaAmbitoLocalizacionDto> localizacion;

    @ApiModelProperty(value = "Validaciones", required = false)
    private List<RunTareaValidarDto> runTareaValidar = new ArrayList<>();

}
