package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TAREA_AGRUPACION_CADENA")
@Data
public class TareaAgrupacionCadena {

  @Id
  @Column(name = "ID_TAREA_AGRUPACION_CADENA")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
  private String cclIdOrigen;

  @NotNull
  @Column(name = "ICM_ID_AGRUPACION_ONLINE", nullable = false)
  private Long icmIdAgrupacionOnline;

  @NotBlank
  @Column(name = "CCL_ID_CADENA", nullable = false, length = 48)
  private String cclIdCadena;

  @NotNull
  @Column(name = "ES_MULTIPLE", nullable = false)
  private Boolean multiple;

}
