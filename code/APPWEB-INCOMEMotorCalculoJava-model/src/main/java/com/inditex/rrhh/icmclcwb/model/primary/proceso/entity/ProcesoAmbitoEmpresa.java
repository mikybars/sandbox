package com.inditex.rrhh.icmclcwb.model.primary.proceso.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PROCESO_AMBITO_EMPRESA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcesoAmbitoEmpresa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_PROCESO_AMBITO_EMPRESA")
  private Long id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_PROCESO", nullable = false)
  private Proceso proceso;

  @NotNull
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
  private String cclIdOrigen;

  @NotNull
  @Column(name = "STD_ID_LEG_ENT", nullable = false, length = 48)
  private String stdIdLegEnt;

}
