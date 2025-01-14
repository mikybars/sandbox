package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "TAREA_AGRUPACION_PRESENCIA")
@Data
public class TareaAgrupacionPresencia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_AGRUPACION_PRESENCIA")
  private Long id;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NonNull
  @Column(name = "FECHA", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fecha;

  @NonNull
  @Column(name = "ICM_ID_AGRUPACION_ONLINE", nullable = false)
  private Long icmIdAgrupacionOnline;

  @NotBlank
  @Column(name = "CCL_ID_SECCION", nullable = false, length = 4)
  private String cclIdSeccion;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
  private String cclIdOrigen;

  @NonNull
  @Column(name = "MINUTOS", nullable = false)
  private Integer minutos;

  @NonNull
  @Column(name = "ES_ACTIVO", nullable = false)
  private Boolean activo;

  @ManyToOne
  @JoinColumn(name = "ID_TIPO_DATO", nullable = false)
  private TipoDato tipoDato;

}
