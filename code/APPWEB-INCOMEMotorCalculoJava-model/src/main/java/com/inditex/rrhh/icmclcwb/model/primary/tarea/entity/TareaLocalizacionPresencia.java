package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TAREA_LOCALIZACION_PRESENCIA")
@Data
public class TareaLocalizacionPresencia extends DatosComunesJornada {

  @EmbeddedId
  private TareaLocalizacionPresenciaPk pk;

}
