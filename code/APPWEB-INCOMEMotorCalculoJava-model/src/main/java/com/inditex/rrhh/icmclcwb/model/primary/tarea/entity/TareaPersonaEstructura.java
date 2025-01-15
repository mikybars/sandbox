package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TAREA_PERSONA_ESTRUCTURA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaPersonaEstructura extends CommonFieldsTask {

  @EmbeddedId
  private TareaPersonaEstructuraPk pk;

  @NotBlank
  @Column(name = "CCL_ID_SECCION_ESTRUCTURA", nullable = false, length = 4)
  private String cclIdSeccionEstructura;

  @NotBlank
  @Column(name = "CCL_ID_SECCION_EFECTIVA", nullable = false, length = 4)
  private String cclIdSeccionEfectiva;

  @NotBlank
  @Column(name = "STD_ID_HR", nullable = false, length = 18)
  private String stdIdHr;

  @NotBlank
  @Column(name = "STD_OR_HR_PERIOD", nullable = false, length = 48)
  private String stdOrHrPeriod;

  @NotBlank
  @Column(name = "CCL_ID_PERSON", nullable = false, length = 48)
  private String cclIdPerson;

  @NotBlank
  @Column(name = "ICM_ID_ESTR_COMISION", nullable = false, length = 48)
  private String icmIdEstrComision;

  @Column(name = "ORDINAL_ESTRUCTURA", nullable = true)
  private Integer ordinalEstructura;

  @NotBlank
  @Column(name = "ICM_ID_TP_CALCULO", nullable = false, length = 48)
  private String icmIdTpCalculo;

  @NotBlank
  @Column(name = "ICM_ID_TP_COMISION", nullable = false, length = 48)
  private String icmIdTpComision;

  @NotNull
  @Column(name = "ICM_VALOR", nullable = false, precision = 23, scale = 8)
  private BigDecimal valor;

  @NotNull
  @Column(name = "ES_DESPLAZAMIENTO", nullable = false)
  private Boolean desplazamiento;

  @NotNull
  @Column(name = "ES_DESPLAZAMIENTO_BASE", nullable = false)
  private Boolean desplazamientoBase;

  @NotNull
  @Column(name = "ES_ACTIVO", nullable = false)
  private Boolean activo;

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

  @NotBlank
  @Column(name = "ICM_ID_ESTR_COMISION_PADRE", nullable = false, length = 48)
  private String icmIdEstrComisionPadre;

  @NotBlank
  @Column(name = "ICM_ID_ESTR_COMISION_BASE", nullable = false, length = 48)
  private String icmIdEstrComisionBase;

  @NotNull
  @Column(name = "ICM_ORD_TOPE", nullable = false, length = 48)
  private Integer tope;

  @NotBlank
  @Column(name = "ICM_ID_TP_ESTRUCTURA", nullable = false, length = 48)
  private String icmIdTpEstructura;

  @NotNull
  @Column(name = "ICM_GRUPO_MANUAL", nullable = false)
  private String icmGrupoManual;

  @NotNull
  @Column(name = "ES_FESTIVO", nullable = false)
  private Boolean festivo;

  @ManyToMany(mappedBy = "estructura")
  private List<TareaLocalizacionPresupuesto> presupuesto;

}
