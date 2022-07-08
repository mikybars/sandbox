package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

/*
 * Copyright (c) 2022. Inditex
 */
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
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

  @EmbeddedId
  private MailAmbitoPk pk;

  @NotNull
  @Column(name = "ES_ACTIVO")
  private Boolean esActivo;

}
