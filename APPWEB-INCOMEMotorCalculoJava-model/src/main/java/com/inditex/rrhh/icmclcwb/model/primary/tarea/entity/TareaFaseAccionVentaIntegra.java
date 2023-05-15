package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "TAREA_FASE_ACCION_VENTA_INTEGRA")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TareaFaseAccionVentaIntegra {

  @EmbeddedId
  private TareaFaseAccionVentaIntegraPk pk;

}
