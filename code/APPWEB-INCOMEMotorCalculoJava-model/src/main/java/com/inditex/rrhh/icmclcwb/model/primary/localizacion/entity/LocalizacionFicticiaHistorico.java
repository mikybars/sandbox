package com.inditex.rrhh.icmclcwb.model.primary.localizacion.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
