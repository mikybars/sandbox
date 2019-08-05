package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class TareaPersonaEstructuraDto implements Serializable {

    private static final long serialVersionUID = -543194407813312935L;

    @ApiModelProperty(value = "Identificador de la persona estructura", required = false)
    private String id;

    @ApiModelProperty(value = "Oridnal de la estructura")
    private Integer ordinalEstructura;

    @NotNull
    @ApiModelProperty(value = "Identificador del tarea", required = true)
    private Long idTarea;

    @NotBlank
    @ApiModelProperty(value = "Id origen", required = true)
    private String cclIdOrigen;

    @NotBlank
    @ApiModelProperty(value = "Id de la persona", required = true)
    private String stdIdHr;

    @NotBlank
    @ApiModelProperty(value = "Ordinal de la persona", required = true)
    private String stdOrHrPeriod;

    @NotBlank
    @ApiModelProperty(value = "Id local de la persona", required = true)
    private String cclIdPerson;

    @NotNull
    @ApiModelProperty(value = "Id estructura asociada al empleado por APV", required = true)
    private String icmIdEstrComision;

    @NotNull
    @ApiModelProperty(value = "Id tipo calculo asociado a la estructura", required = true)
    private String icmIdTpCalculo;

    @NotNull
    @ApiModelProperty(value = "Id tipo comisión asociado a la estructura ", required = true)
    private String icmIdTpComision;

    @NotNull
    @ApiModelProperty(value = "valor asociado a la seccion", required = true)
    private String valor;

    @NotNull
    @ApiModelProperty(value = "Seccion usada en el calculo", required = true)
    private String cclIdSeccionEfectiva;

    @NotNull
    @ApiModelProperty(value = "Seccion usada en la estructura", required = true)
    private String cclIdSeccionEstructura;

    @NotNull
    @ApiModelProperty(value = "Fecha de inicio en la estructura", required = true)
    private Date fechaInicio;

    @NotNull
    @ApiModelProperty(value = "Fecha de fin en la estructura", required = true)
    private Date fechaFin;

    @NotNull
    @ApiModelProperty(value = "Flag que indica si hay desplazamientos para el empleado", required = true)
    private Boolean desplazamiento;

    @ApiModelProperty(value = "Estructura de desplazamiento", required = false)
    private TareaPersonaEstructuraDesplazamientoDto estructuraDesplazamiento;

}
