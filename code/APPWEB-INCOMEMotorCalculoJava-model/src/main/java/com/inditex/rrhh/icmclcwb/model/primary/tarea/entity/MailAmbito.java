package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

/*
 * Copyright (c) 2022. Inditex
 */

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "MAIL_AMBITO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MailAmbito {

  @EmbeddedId
  private MailAmbitoPk pk;

  @NonNull
  @Column(name = "ES_ACTIVO")
  private Boolean esActivo;

}
