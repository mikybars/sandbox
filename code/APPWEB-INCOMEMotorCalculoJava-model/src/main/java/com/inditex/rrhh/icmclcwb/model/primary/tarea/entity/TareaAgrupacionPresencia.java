package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "TAREA_AGRUPACION_PRESENCIA")
@Data
public class TareaAgrupacionPresencia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_AGRUPACION_PRESENCIA")
  private Long id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NotNull
  @Column(name = "FECHA", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fecha;

  @NotNull
  @Column(name = "ICM_ID_AGRUPACION_ONLINE", nullable = false)
  private Long icmIdAgrupacionOnline;

  @NotBlank
  @Column(name = "CCL_ID_SECCION", nullable = false, length = 4)
  private String cclIdSeccion;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
  private String cclIdOrigen;

  @NotNull
  @Column(name = "MINUTOS", nullable = false)
  private Integer minutos;

  @NotNull
  @Column(name = "ES_ACTIVO", nullable = false)
  private Boolean activo;

  @ManyToOne
  @JoinColumn(name = "ID_TIPO_DATO", nullable = false)
  private TipoDato tipoDato;

}
