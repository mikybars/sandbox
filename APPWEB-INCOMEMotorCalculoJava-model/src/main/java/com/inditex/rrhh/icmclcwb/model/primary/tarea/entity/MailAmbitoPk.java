package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

/*
 * Copyright (c) 2022. Inditex
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Embeddable
@Data
public class MailAmbitoPk implements Serializable {

  private static final long serialVersionUID = 9211701161591707073L;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false)
  private String cclIdOrigen;

  @NotBlank
  @Column(name = "STD_ID_LEG_ENT", nullable = false)
  private String stdIdLegEnt;

  @NotBlank
  @Column(name = "MAIL", nullable = false)
  private String mail;

}
