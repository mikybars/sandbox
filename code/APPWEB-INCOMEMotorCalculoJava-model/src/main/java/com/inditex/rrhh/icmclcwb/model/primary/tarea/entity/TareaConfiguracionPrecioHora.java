package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TAREA_CONFIGURACION_PRECIO_HORA")
@Data
public class TareaConfiguracionPrecioHora {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_CONFIGURACION_PRECIO_HORA")
  private Long id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NotNull
  @Column(name = "ICM_CK_TP_HORA_COMIS", nullable = false)
  private Boolean icmCkTpHoraComis;

  @NotNull
  @Column(name = "ICM_CK_TP_HORA_INC_PTPO", nullable = false)
  private Boolean icmCkTpHoraIncPtpo;

  @NotNull
  @Column(name = "FECHA_INICIO", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicio;

  @NotNull
  @Column(name = "FECHA_FIN", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFin;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
  private String cclIdOrigen;

}
