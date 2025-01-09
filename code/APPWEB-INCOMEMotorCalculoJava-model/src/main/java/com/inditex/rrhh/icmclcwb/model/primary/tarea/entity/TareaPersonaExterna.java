package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "TAREA_PERSONA_EXTERNA")
@Data
public class TareaPersonaExterna extends CommonFieldsTask {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_PERSONA_EXTERNA")
  private Long id;

  @NotBlank
  @Column(name = "CCL_ID_PERSON", nullable = false)
  private String cclIdPerson;

}
