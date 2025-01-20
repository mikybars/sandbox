package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaPersonaEstructuraDto implements Serializable {

  private static final long serialVersionUID = -543194407813312935L;

  private String id;

  private Integer ordinalEstructura;

  @NotNull
  private Long idTarea;

  @NotBlank
  private String cclIdOrigen;

  @NotBlank
  private String stdIdHr;

  @NotBlank
  private String stdOrHrPeriod;

  @NotBlank
  private String cclIdPerson;

  @NotBlank
  private String icmIdEstrComision;

  @NotBlank
  private String icmIdTpCalculo;

  @NotBlank
  private String icmIdTpComision;

  @NotBlank
  private String valor;

  @NotBlank
  private String cclIdSeccionEfectiva;

  @NotBlank
  private String cclIdSeccionEstructura;

  @NotNull
  private Date fechaInicio;

  @NotNull
  private Date fechaFin;

  @NotNull
  private Boolean desplazamiento;

  @NotNull
  private Boolean desplazamientoBase;

  private TareaPersonaEstructuraDesplazamientoDto estructuraDesplazamiento;

  @NotNull
  private Boolean activo;

  private Boolean diaL;

  private Boolean diaM;

  private Boolean diaX;

  private Boolean diaJ;

  private Boolean diaV;

  private Boolean diaS;

  private Boolean diaD;

  @NotBlank
  private String icmIdEstrComisionBase;

  @NotBlank
  private String icmIdEstrComisionPadre;

  @NotNull
  private Integer tope;

  @NotBlank
  private String icmIdTpEstructura;

  @NotNull
  private LocalDate fechaInicioPeriodo;

  private Boolean festivo;

  private String grupoManual;

}
