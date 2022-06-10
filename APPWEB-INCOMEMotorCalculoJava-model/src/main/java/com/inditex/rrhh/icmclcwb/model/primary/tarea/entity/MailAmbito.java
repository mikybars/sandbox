package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

/*
 * Copyright (c) 2022. Inditex
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "MAIL_AMBITO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MailAmbito {

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false)
  private String cclIdOrigen;

  @NotBlank
  @Column(name = "STD_ID_LEG_ENT", nullable = false)
  private String stdIdLegEnt;

  @NotBlank
  @Column(name = "MAIL", nullable = false)
  private String mail;

  @NotNull
  @Column(name = "ES_ACTIVO")
  private Boolean esActivo;

}
