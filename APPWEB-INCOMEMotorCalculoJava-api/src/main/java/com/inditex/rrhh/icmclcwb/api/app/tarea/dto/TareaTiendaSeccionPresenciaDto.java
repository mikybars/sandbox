package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TareaTiendaSeccionPresenciaDto {

    @ApiModelProperty(value = "Identificador de la entidad", required = false, accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Long id;

    @NotNull
    @ApiModelProperty(value = "Tarea", required = true)
    private Long idTarea;

    @ApiModelProperty(value = "Fecha en la que se consultó la venta", required = true, accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private LocalDate fecha;

    @NotBlank
    @ApiModelProperty(value = "Id de la tienda", required = true)
    private String idTienda;

    @NotBlank
    @ApiModelProperty(value = "Id de la seccion", required = true)
    private String idSeccion;

    @NotNull
    @ApiModelProperty(value = "Tiempo seccion", required = false, accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Long minutos;

}
