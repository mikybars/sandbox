package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.AlgoritmoAjuste;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "TAREA_CALCULO_AJUSTE")
@Data
public class TareaCalculoAjuste {

  @EmbeddedId
  private TareaCalculoAjustePk pk;

  @OneToOne
  @JoinColumns({
      @JoinColumn(name = "ID_TAREA_PERSONA_ESTRUCTURA_POLITICA",
          referencedColumnName = "ID_TAREA_PERSONA_ESTRUCTURA_POLITICA", insertable = false,
          updatable = false),
      @JoinColumn(name = "FECHA_INICIO_PERIODO", referencedColumnName = "FECHA_INICIO_PERIODO",
          insertable = false, updatable = false)})
  private TareaPersonaEstructuraPolitica tareaPersonaEstructuraPolitica;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NonNull
  @Column(name = "FECHA", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fecha;

  @NotBlank
  @Column(name = "CCL_ID_PERSON", nullable = false, length = 48)
  private String cclIdPerson;

  @NotBlank
  @Column(name = "STD_OR_HR_PERIOD", nullable = false, length = 48)
  private String stdOrHrPeriod;

  @NonNull
  @Column(name = "IMPORTE", nullable = false, precision = 23, scale = 8)
  private BigDecimal importe;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_ALGORITMO_AJUSTE", nullable = false)
  private AlgoritmoAjuste algoritmoAjuste;

}
