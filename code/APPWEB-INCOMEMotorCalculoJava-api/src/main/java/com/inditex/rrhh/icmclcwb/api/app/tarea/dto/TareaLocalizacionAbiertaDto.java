package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
public class TareaLocalizacionAbiertaDto implements Serializable {

  private static final long serialVersionUID = 5072975705443047327L;

  private String id;

  @NonNull
  private Long idTarea;

  @NonNull
  private Long cclIdCodOrigen;

  @NotBlank
  private String cclIdSeccion;

  @NonNull
  private Date fecha;

  @NonNull
  private Boolean abierto;

}
