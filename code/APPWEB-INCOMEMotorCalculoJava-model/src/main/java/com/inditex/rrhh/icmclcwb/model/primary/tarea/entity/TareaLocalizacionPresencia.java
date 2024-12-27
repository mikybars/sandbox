package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TAREA_LOCALIZACION_PRESENCIA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaLocalizacionPresencia extends DatosComunesJornada {

  @EmbeddedId
  private TareaLocalizacionPresenciaPk pk;

}
