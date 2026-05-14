package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.joda.time.DateTime;

@Entity
@Table(name = "TAREA_CALCULO_PERSONA_PRECIO_HORA")
@Data
public class TareaCalculoPersonaPrecioHora {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_CALCULO_PERSONA_PRECIO_HORA")
  private Long id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NotBlank
  @Column(name = "ICM_ID_PERIODO", nullable = false, length = 48)
  private String icmIdPeriodo;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
  private String cclIdOrigen;

  @NotBlank
  @Column(name = "STD_ID_LEG_ENT", nullable = false, length = 48)
  private String stdIdLegEnt;

  @NotBlank
  @Column(name = "CCL_ID_PERSON", nullable = false, length = 48)
  private String cclIdPerson;

  @NotBlank
  @Column(name = "STD_OR_HR_PERIOD", nullable = false, length = 48)
  private String stdOrHrPeriod;

  @NotBlank
  @Column(name = "FECHA", nullable = false)
  private DateTime fecha;

  @NotBlank
  @Column(name = "PRECIO_HORA", nullable = false, precision = 23, scale = 8)
  private BigDecimal precioHora;

}
