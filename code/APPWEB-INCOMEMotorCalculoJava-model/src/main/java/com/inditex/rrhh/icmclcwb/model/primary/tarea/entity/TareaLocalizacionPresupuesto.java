package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Set;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPresupuesto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TAREA_LOCALIZACION_PRESUPUESTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaLocalizacionPresupuesto extends CommonFieldsTaskEntity {

  // TODO [JAVIEREV] Introducir campos, si es que procede: cumplida

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_LOCALIZACION_PRESUPUESTO")
  private Long id;

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
