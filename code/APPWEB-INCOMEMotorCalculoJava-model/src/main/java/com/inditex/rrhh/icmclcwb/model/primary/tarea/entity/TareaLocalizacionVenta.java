package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TAREA_LOCALIZACION_VENTA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TareaLocalizacionVenta extends DatosComunesVenta {

  @EmbeddedId
  private TareaLocalizacionVentaPk pk;

}
