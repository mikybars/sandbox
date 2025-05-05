package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

/*
 * Copyright (c) 2021. Inditex
 */
import java.math.BigDecimal;
import java.util.Date;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoComision;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TAREA_CALCULO_AJUSTE_COMISION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaCalculoAjusteComision {

  @EmbeddedId
  private TareaCalculoAjusteComisionPk pk;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NotBlank
  @Column(name = "CCL_ID_PERSON", nullable = false, length = 48)
  private String cclIdPerson;

  @NotBlank
  @Column(name = "STD_OR_HR_PERIOD", nullable = false, length = 48)
  private String stdOrHrPeriod;

  @NotNull
  @Column(name = "IMPORTE", nullable = false, precision = 23, scale = 8)
  private BigDecimal importe;

  @NotNull
  @Column(name = "FECHA", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fecha;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_COMISION", nullable = false)
  private TipoComision tipoComision;

}
