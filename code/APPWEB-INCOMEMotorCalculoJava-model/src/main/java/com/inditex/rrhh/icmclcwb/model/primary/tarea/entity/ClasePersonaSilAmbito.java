package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "CLASE_PERSONA_SIL_AMBITO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ClasePersonaSilAmbito {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_CLASE_PERSONA_SIL_AMBITO")
  private Long id;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false)
  private String cclIdOrigen;

  @NotBlank
  @Column(name = "STD_ID_LEG_ENT", nullable = false)
  private String stdIdLegEnt;

  @NotBlank
  @Column(name = "CLASE", nullable = false)
  private Integer clase;

  @NotBlank
  @Column(name = "ESTADO")
  private Integer estado;

}
