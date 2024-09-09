package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TAREA_LOCALIZACION_PERSONA_VENTA")
@Data
public class TareaLocalizacionPersonaVenta extends DatosComunesPersonaVenta {

  @EmbeddedId
  private TareaLocalizacionPersonaVentaPk pk;

}
