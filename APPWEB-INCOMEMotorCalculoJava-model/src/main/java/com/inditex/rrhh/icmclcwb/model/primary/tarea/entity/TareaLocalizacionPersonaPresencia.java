package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TAREA_LOCALIZACION_PERSONA_PRESENCIA")
@Data
public class TareaLocalizacionPersonaPresencia {

  @EmbeddedId
  private TareaLocalizacionPersonaPresenciaPk pk;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NotBlank
  @Column(name = "CCL_ID_COD_ORIGEN", nullable = false, length = 48)
  private String cclIdCodOrigen;

  @NotBlank
  @Column(name = "CCL_ID_CADENA", nullable = false, length = 48)
  private String cclIdCadena;

  @NotBlank
  @Column(name = "CCL_ID_PERSON", nullable = false, length = 48)
  private String cclIdPerson;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
  private String cclIdOrigen;

  @NotBlank
  @Column(name = "STD_ID_LEG_ENT", nullable = false, length = 48)
  private String stdIdLegEnt;

  @NotBlank
  @Column(name = "CCL_ID_SECCION", nullable = false, length = 4)
  private String cclIdSeccion;

  @NotNull
  @Column(name = "MINUTOS", nullable = false)
  private Integer minutos;

  @NotNull
  @Column(name = "COD_TIPO_HORA", nullable = false)
  private Integer codTipoHora;

  @ManyToOne
  @JoinColumn(name = "ID_TIPO_DATO", nullable = false)
  private TipoDato tipoDato;

  @NotNull
  @Column(name = "ES_ACTIVO", nullable = false)
  private Boolean activo;

  @NotNull
  @Column(name = "FECHA", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fecha;

}
