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
@Table(name = "TAREA_LOCALIZACION_CALCULAR")
@Data
public class TareaLocalizacionCalcular extends CommonFieldsTask {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_LOCALIZACION_CALCULAR")
  private Long id;

  @NotBlank
  @Column(name = "CCL_ID_COD_ORIGEN", nullable = false, length = 48)
  private String cclIdCodOrigen;

  @NotBlank
  @Column(name = "STD_ID_WORK_LOCAT", nullable = false, length = 48)
  private String stdIdWorkLocat;

  @NonNull
  @Column(name = "ES_CALCULA", nullable = false)
  private Boolean calcula;

}
