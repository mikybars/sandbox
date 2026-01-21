package com.inditex.rrhh.icmclcwb.model.primary.simulacion.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SIMULACION")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Simulacion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_SIMULACION")
  private Long id;

  @NotNull
  @Column(name = "FECHA_HORA_CREACION", nullable = false)
  private LocalDateTime fechaHoraCreacion;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
  private String cclIdOrigen;

  @NotBlank
  @Column(name = "STD_ID_LEG_ENT", nullable = false, length = 48)
  private String stdIdLegEnt;

  @NotBlank
  @Column(name = "CCL_ID_CADENA", nullable = false, length = 24)
  private String cclIdCadena;

  @NotBlank
  @Column(name = "STD_OR_HR_PERIOD", nullable = false, length = 48)
  private String stdOrHrPeriod;

  @NotBlank
  @Column(name = "CCL_ID_PERSON", nullable = false, length = 48)
  private String cclIdPerson;

  @NotBlank
  @Column(name = "STD_ID_HR", nullable = false, length = 18)
  private String stdIdHr;

  @NotNull
  @Column(name = "ICM_ID_PERIODO", nullable = false)
  private Long icmIdPeriodo;

  @NotNull
  @Column(name = "FECHA_INICIO", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicio;

  @NotNull
  @Column(name = "FECHA_FIN", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFin;

  @NotBlank
  @Column(name = "STD_ID_WORK_LOCAT", nullable = false, length = 48)
  private String stdIdWorkLocat;

  @NotBlank
  @Column(name = "CCL_ID_COD_ORIGEN", nullable = false, length = 48)
  private String cclIdCodOrigen;

  @ManyToMany(mappedBy = "simulacion")
  private List<Condicion> condicion;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_VENTA_LOCALIZACION_SIMULACION", nullable = false)
  private TipoVentaLocalizacionSimulacion idTipoVentaLocalizacionSimulacion;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_PRESENCIA_LOCALIZACION_SIMULACION", nullable = false)
  private TipoPresenciaLocalizacionSimulacion idTipoPresenciaLocalizacionSimulacion;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_PRESENCIA_PERSONA_SIMULACION", nullable = false)
  private TipoPresenciaPersonaSimulacion idTipoPresenciaPersonaSimulacion;

}
