package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;
import java.util.Set;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPresupuesto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TAREA_LOCALIZACION_PRESUPUESTO")
@Data
public class TareaLocalizacionPresupuesto {

  // TODO [JAVIEREV] Introducir campos, si es que procede: cumplida

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_LOCALIZACION_PRESUPUESTO")
  private Long id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
  private String cclIdOrigen;

  @NotBlank
  @Column(name = "STD_ID_LEG_ENT", nullable = false, length = 48)
  private String stdIdLegEnt;

  @NotBlank
  @Column(name = "STD_ID_WORK_LOCAT", nullable = false, length = 48)
  private String stdIdWorkLocat;

  @NotBlank
  @Column(name = "CCL_ID_COD_ORIGEN", nullable = false, length = 48)
  private String cclIdCodOrigen;

  @NotBlank
  @Column(name = "CCL_ID_SECCION", nullable = false, length = 48)
  private String cclIdSeccion;

  @NotNull
  @Column(name = "FECHA_INICIO", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicio;

  @NotNull
  @Column(name = "FECHA_FIN", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFin;

  @NotNull
  @Column(name = "IMPORTE_SIN_IMPUESTOS", nullable = false)
  private Double importeSinImpuestos;

  @NotNull
  @Column(name = "IMPORTE_CON_IMPUESTOS", nullable = false)
  private Double importeConImpuestos;

  @NotNull
  @Column(name = "ICM_BANDA", nullable = false)
  private Integer banda;

  @NotNull
  @Column(name = "ICM_ORDINAL", nullable = false)
  private Integer ordinal;

  @NotNull
  @Column(name = "ICM_CK_EXCEPCION")
  private Boolean excepcion;

  @NotNull
  @Column(name = "ES_ACTIVO", nullable = false)
  private Boolean activo;

  @ManyToOne
  @JoinColumn(name = "ID_TIPO_PRESUPUESTO", nullable = false)
  private TipoPresupuesto tipoPresupuesto;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "TAREA_LOCALIZACION_PRESUPUESTO_TAREA_PERSONA_ESTRUCTURA", joinColumns = {
      @JoinColumn(name = "ID_TAREA_LOCALIZACION_PRESUPUESTO")},
      inverseJoinColumns = {
          @JoinColumn(name = "ID_TAREA_PERSONA_ESTRUCTURA"), @JoinColumn(name = "TAREA_PERSONA_ESTRUCTURA")})
  private Set<TareaPersonaEstructura> estructura;

}
