package com.inditex.rrhh.icmclcwb.model.primary.localizacion.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "LOCALIZACION_FICTICIA_HISTORICO")
@Data
public class LocalizacionFicticiaHistorico {

  @EmbeddedId
  private LocalizacionFicticiaHistoricoPk pk;

  @NotNull
  @Column(name = "FECHA_FIN", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFin;

  @NotBlank
  @Column(name = "STD_ID_WORK_LOCAT", nullable = false, length = 48)
  private String stdIdWorkLocat;

  @NotBlank
  @Column(name = "CCL_ID_CADENA", nullable = false, length = 24)
  private String cclIdCadena;

  @NotBlank
  @Column(name = "STD_ID_COUNTRY", nullable = false, length = 8)
  private String stdIdCountry;

}
