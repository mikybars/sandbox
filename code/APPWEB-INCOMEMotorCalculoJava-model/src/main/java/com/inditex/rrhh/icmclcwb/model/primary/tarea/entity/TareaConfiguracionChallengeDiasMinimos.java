package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "TAREA_CONFIGURACION_CHALLENGE_DIAS_MINIMOS")
@Data
public class TareaConfiguracionChallengeDiasMinimos extends CommonFieldsTaskOrigin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_CONFIGURACION_CHALLENGE_DIAS_MINIMOS")
  private Long id;

  @NotBlank
  @Column(name = "ICM_ID_TP_CALCULO", nullable = false, length = 48)
  private String icmIdTpCalculo;

  @NonNull
  @Column(name = "ICM_MIN_NUM_DAYS", nullable = false)
  private Integer icmMinNumDays;

}
