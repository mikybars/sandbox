package com.inditex.rrhh.icmclcwb.model.primary.simulacion.entity;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "CONDICION")
@Data
public class Condicion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_CONDICION")
  private Long id;

  @NotBlank
  @Column(name = "ICM_ID_TP_CALCULO", nullable = false, length = 48)
  private String icmIdTpCalculo;

  @NotBlank
  @Column(name = "ICM_ID_TP_COMISION", nullable = false, length = 48)
  private String icmIdTpComision;

  @NotNull
  @Column(name = "ICM_VALOR", nullable = false, precision = 23, scale = 8)
  private BigDecimal valor;

  @NotBlank
  @Column(name = "CCL_ID_SECCION", nullable = false, length = 4)
  private String cclIdSeccion;

  @NotNull
  @Column(name = "ICM_ORD_TOPE", nullable = false, length = 48)
  private Integer tope;

  @Column(name = "ES_DIA_LUNES", nullable = false)
  private Boolean diaL;

  @Column(name = "ES_DIA_MARTES", nullable = false)
  private Boolean diaM;

  @Column(name = "ES_DIA_MIERCOLES", nullable = false)
  private Boolean diaX;

  @Column(name = "ES_DIA_JUEVES", nullable = false)
  private Boolean diaJ;

  @Column(name = "ES_DIA_VIERNES", nullable = false)
  private Boolean diaV;

  @Column(name = "ES_DIA_SABADO", nullable = false)
  private Boolean diaS;

  @Column(name = "ES_DIA_DOMINGO", nullable = false)
  private Boolean diaD;

  @NotNull
  @Column(name = "ES_FESTIVO", nullable = false)
  private Boolean festivo;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "SIMULACION_CONDICION", joinColumns = {
      @JoinColumn(name = "ID_CONDICION")},
      inverseJoinColumns = {
          @JoinColumn(name = "ID_SIMULACION")})
  private Set<Simulacion> simulacion;

}
