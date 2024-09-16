package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TAREA_LOCALIZACION_VENTA")
@Data
public class TareaLocalizacionVenta extends DatosComunesVenta {

  @EmbeddedId
  private TareaLocalizacionVentaPk pk;

}
