package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TareaPersonaEstructuraDesplazamientoDto implements Serializable {

    private static final long serialVersionUID = -7730621144181571265L;

    @ApiModelProperty(value = "Identificador de la persona estructura desplazamiento", required = false)
    private String id;

    @NotNull
    @ApiModelProperty(value = "Fecha de inicio en la estructura", required = true)
    private LocalDateTime fechaInicio;

    @NotNull
    @ApiModelProperty(value = "Fecha de fin en la estructura", required = true)
    private LocalDateTime fechaFin;

    @NotNull
    @ApiModelProperty(value = "Motivo del desplazamiento", required = true)
    private String idMotivoDesplazamiento;

    @NotNull
    @ApiModelProperty(value = "Tipo de opción de cálculo de la estructura", required = true)
    private Integer idTipoOpcionCalculoEstructura;

    @NotNull
    @ApiModelProperty(value = "Tipo de opción de cálculo usada en el propio cálculo", required = true)
    private Integer idTipoOpcionCalculoEfectiva;

    @NotNull
    @ApiModelProperty(value = "Tipo de cálculo", required = true)
    private String icmIdTpCalculo;

    @NotNull
    @ApiModelProperty(value = "Puesto del destino del desplazamiento", required = true)
    private String cclIdPuestoDestino;

    @NotNull
    @ApiModelProperty(value = "Sección del destino del desplazamiento", required = true)
    private String cclIdSeccionDestino;

    @NotNull
    @ApiModelProperty(value = "Lugar de trabajo del desitno del desplazamiento", required = true)
    private String cclIdCodOrigenDestino;

    @NotNull
    @ApiModelProperty(value = "valor asociado a la seccion", required = true)
    private String valor;

    @NotNull
    @ApiModelProperty(value = "Seccion usada en el calculo", required = true)
    private String cclIdSeccionEfectiva;

    @NotNull
    @ApiModelProperty(value = "Seccion de la estructura", required = true)
    private String cclIdSeccionEstructura;
}
