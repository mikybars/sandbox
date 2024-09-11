package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TAREA_LOCALIZACION_PERSONA_JORNADA")
@Data
public class TareaLocalizacionPersonaJornada extends DatosComunesPersonaJornada {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_LOCALIZACION_PERSONA_JORNADA")
  private Long id;

}
