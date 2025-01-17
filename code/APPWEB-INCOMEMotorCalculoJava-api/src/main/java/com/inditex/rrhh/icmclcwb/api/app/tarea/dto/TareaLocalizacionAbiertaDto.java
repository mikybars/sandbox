package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaLocalizacionAbiertaDto implements Serializable {

  private static final long serialVersionUID = 5072975705443047327L;

  private String id;

  @NotNull
  private Long idTarea;

  @NotNull
  private Long cclIdCodOrigen;

  @NotBlank
  private String cclIdSeccion;

  @NotNull
  private Date fecha;

  @NotNull
  private Boolean abierto;

}
