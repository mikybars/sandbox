package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.math.BigDecimal;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPolitica;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoUnidadTiempo;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TAREA_PERSONA_ESTRUCTURA_POLITICA")
@Data
public class TareaPersonaEstructuraPolitica extends CommonFieldsTaskOrigin {

  @EmbeddedId
  private TareaPersonaEstructuraPoliticaPk pk;

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
  @Column(name = "ICM_ID_ESTR_POLITICAS", nullable = false)
  private String idEstructuraPolitica;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_POLITICA")
  private TipoPolitica tipoPolitica;

  @Column(name = "ES_EXCLUIDO_DENOMINADOR", nullable = false)
  private Boolean excluidoDenominador;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_UNIDAD_TIEMPO")
  private TipoUnidadTiempo tipoUnidadTiempo;

  @NotBlank
  @Column(name = "ICM_NUM_UNIDADES", nullable = false)
  private String numeroUnidades;

  @NotNull
  @Column(name = "ICM_PORCENTAJE", nullable = false, precision = 23, scale = 8)
  private BigDecimal valor;

  @NotNull
  @Column(name = "ICM_TRAMO", nullable = false)
  private Integer tramo;

  @NotNull
  @Column(name = "ICM_IMPORTE", nullable = true, precision = 23, scale = 8)
  private BigDecimal importe;

  @NotBlank
  @Column(name = "ICM_NUM_MESES_CALC_MEDIA", nullable = false)
  private String numMesesCalcMedia;

  @NotBlank
  @Column(name = "ICM_NUM_HORAS", nullable = false)
  private String numHoras;

  @NotBlank
  @Column(name = "ICM_ID_MOTIVO_BAJA", nullable = false)
  private String idMotivoBaja;

}
