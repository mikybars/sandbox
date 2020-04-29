package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TareaLocalizacionPresupuestoDto {

    @NotNull
    @ApiModelProperty(value = "Tarea", required = true)
    private Long idTarea;

    @ApiModelProperty(value = "Fecha de inicio del presupuesto", required = true, accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private LocalDate fechaInicio;

    @ApiModelProperty(value = "Fecha de fin del presupuesto", required = true, accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private LocalDate fechaFin;

    @NotBlank
    @ApiModelProperty(value = "Id de la localizacion", required = true)
    private String cclIdCodOrigen;

    @NotBlank
    @ApiModelProperty(value = "Id de la seccion", required = true)
    private String cclIdSeccion;

    @NotBlank
    @ApiModelProperty(value = "Id de empresa", required = true)
    private String stdIdLegEnt;

    @NotBlank
    @ApiModelProperty(value = "Id de pais", required = true)
    private String cclIdOrigen;

}
