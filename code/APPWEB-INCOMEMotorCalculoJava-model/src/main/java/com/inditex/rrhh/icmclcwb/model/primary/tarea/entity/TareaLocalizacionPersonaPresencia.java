package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TAREA_LOCALIZACION_PERSONA_PRESENCIA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaLocalizacionPersonaPresencia extends DatosComunesPersonaJornada {

  @EmbeddedId
  private TareaLocalizacionPersonaPresenciaPk pk;

}
