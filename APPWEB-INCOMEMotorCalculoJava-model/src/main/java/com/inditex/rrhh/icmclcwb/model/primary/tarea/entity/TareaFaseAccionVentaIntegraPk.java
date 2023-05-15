package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.time.LocalDate;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Embeddable
@Data
public class TareaFaseAccionVentaIntegraPk {

  @OneToOne
  @JoinColumn(name = "ID_TAREA_FASE_ACCION", nullable = false)
  private TareaFaseAccion tareaFaseAccion;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "ID_TIPO_DATO", nullable = false)
  private TipoDato tipoDato;

  @NotNull
  @Column(name = "TIENDA", nullable = false)
  private String tienda;

  @NotNull
  @Column(name = "FECHA_DESINTEGRIDAD", nullable = false)
  private LocalDate fechaDesintegridad;

}
