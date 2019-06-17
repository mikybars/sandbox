package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class TareaCadenaPresenciaDto implements Serializable {

    private static final long serialVersionUID = 4483874671738606557L;

    @ApiModelProperty(value = "Identificador de la entidad", required = false, accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Long id;

    @NotNull
    @ApiModelProperty(value = "Tarea", required = true)
    private Long idTarea;

    @ApiModelProperty(value = "Fecha en la que se consultó la venta", required = true, accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private LocalDate fecha;

    @NotBlank
    @ApiModelProperty(value = "Id de la cadena", required = true)
    private String idCadena;

    @NotNull
    @ApiModelProperty(value = "Tiempo", required = false, accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Long minutos;

    @NotNull
    @ApiModelProperty(value = "Tipo de dato", required = true)
    private Long idTipoDato;

    @NotNull
    @ApiModelProperty(value = "Flag activo", required = true)
    private Boolean activo;
}
