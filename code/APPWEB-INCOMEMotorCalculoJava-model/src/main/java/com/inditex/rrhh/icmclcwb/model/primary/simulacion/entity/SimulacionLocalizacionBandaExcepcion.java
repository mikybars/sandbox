package com.inditex.rrhh.icmclcwb.model.primary.simulacion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "SIMULACION_LOCALIZACION_BANDA_EXCEPCION")
@Data
public class SimulacionLocalizacionBandaExcepcion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_SIMULACION_LOCALIZACION_BANDA_EXCEPCION")
  private Long id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_SIMULACION", nullable = false)
  private Simulacion simulacion;

  @NotBlank
  @Column(name = "CCL_ID_COD_ORIGEN", nullable = false, length = 48)
  private String cclIdCodOrigen;

  @NotNull
  @Column(name = "BANDA", nullable = false, length = 48)
  private Integer banda;

  @NotBlank
  @Column(name = "CCL_ID_SECCION", nullable = false, length = 48)
  private String cclIdSeccion;

}
