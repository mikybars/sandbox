package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "TAREA_AGRUPACION_CADENA")
@Data
public class TareaAgrupacionCadena {

  @Id
  @Column(name = "ID_TAREA_AGRUPACION_CADENA")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
  private String cclIdOrigen;

  @NonNull
  @Column(name = "ICM_ID_AGRUPACION_ONLINE", nullable = false)
  private Long icmIdAgrupacionOnline;

  @NotBlank
  @Column(name = "CCL_ID_CADENA", nullable = false, length = 48)
  private String cclIdCadena;

  @NonNull
  @Column(name = "ES_MULTIPLE", nullable = false)
  private Boolean multiple;

}
