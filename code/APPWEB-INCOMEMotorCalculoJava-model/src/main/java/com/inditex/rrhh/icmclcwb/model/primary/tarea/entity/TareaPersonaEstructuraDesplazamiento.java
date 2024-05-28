package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoOpcionCalculo;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TAREA_PERSONA_ESTRUCTURA_DESPLAZAMIENTO")
@Data
public class TareaPersonaEstructuraDesplazamiento {

  @EmbeddedId
  private TareaPersonaEstructuraDesplazamientoPk pk;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_OPCION_CALCULO_EFECTIVA", nullable = false)
  private TipoOpcionCalculo tipoOpcionCalculoEfectiva;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_OPCION_CALCULO_ESTRUCTURA", nullable = false)
  private TipoOpcionCalculo tipoOpcionCalculoEstructura;

  @NotBlank
  @Column(name = "CCL_ID_COD_ORIGEN_DESTINO", nullable = false)
  private String cclIdCodOrigenDestino;

  @NotBlank
  @Column(name = "CCL_ID_PUESTO_DESTINO", nullable = false)
  private String cclIdPuestoDestino;

  @NotBlank
  @Column(name = "CCL_ID_SECCION_DESTINO", nullable = false)
  private String cclIdSeccionDestino;

  @NotBlank
  @Column(name = "ICM_ID_ESTR_COMISION", nullable = false, length = 48)
  private String icmIdEstrComision;

  @NotBlank
  @Column(name = "ICM_ID_TP_REQ_COMISION")
  private String icmIdTpReqCom;

  @NotBlank
  @Column(name = "STD_ID_WORK_LOCAT_DESTINO", nullable = false, length = 48)
  private String stdIdWorkLocatDestino;

  @NotNull
  @Column(name = "FECHA_INICIO", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicio;

  @NotNull
  @Column(name = "FECHA_FIN", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFin;

  @NotNull
  @Column(name = "ES_HORAS_ORIGEN", nullable = false)
  private Boolean horasOrigen;

  @NotNull
  @Column(name = "ES_HORAS_DESTINO", nullable = false)
  private Boolean horasDestino;

  @NotNull
  @Column(name = "ORDINAL_ESTRUCTURA", nullable = false)
  private Integer ordinalEstructura;

  @NotNull
  @Column(name = "ES_ACTIVO", nullable = false)
  private Boolean activo;

  @NotBlank
  @Column(name = "ICM_ID_ESTR_COMISION_PADRE", nullable = false, length = 48)
  private String icmIdEstrComisionPadre;

  @NotBlank
  @Column(name = "ICM_ID_ESTR_COMISION_BASE", nullable = false, length = 48)
  private String icmIdEstrComisionBase;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
  private String cclIdOrigen;

  @NotBlank
  @Column(name = "STD_ID_HR", nullable = false, length = 18)
  private String stdIdHr;

  @NotBlank
  @Column(name = "CCL_ID_PERSON", nullable = false, length = 48)
  private String cclIdPerson;

  @NotBlank
  @Column(name = "STD_OR_HR_PERIOD", nullable = false, length = 48)
  private String stdOrHrPeriod;

  @NotBlank
  @Column(name = "ICM_ID_ESTRUCTURA_AMBITO", nullable = false, length = 48)
  private String icmIdEstructuraAmbito;

  @NotBlank
  @Column(name = "ES_INCLUIR_TOTAL_CONDICIONES")
  private Boolean esIncluirTotalCondiciones;

}
