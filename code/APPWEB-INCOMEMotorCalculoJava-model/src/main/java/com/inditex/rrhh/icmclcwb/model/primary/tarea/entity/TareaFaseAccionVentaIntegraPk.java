package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.io.Serializable;
import java.util.Date;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Embeddable
@Data
public class TareaFaseAccionVentaIntegraPk implements Serializable {

  @OneToOne
  @JoinColumn(name = "ID_TAREA_FASE_ACCION", nullable = false)
  private TareaFaseAccion tareaFaseAccion;

  @NonNull
  @ManyToOne
  @JoinColumn(name = "ID_TIPO_DATO", nullable = false)
  private TipoDato tipoDato;

  @NonNull
  @Column(name = "TIENDA", nullable = false)
  private String tienda;

  @NonNull
  @Column(name = "FECHA_DESINTEGRIDAD", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaDesintegridad;

}
