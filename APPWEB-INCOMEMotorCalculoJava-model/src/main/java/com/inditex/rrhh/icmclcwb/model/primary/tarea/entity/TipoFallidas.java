package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

/*
 * Copyright (c) 2022. Inditex
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TIPO_FALLIDAS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoFallidas {

  @Id
  @Column(name = "ID_TIPO_FALLIDAS")
  private Integer id;

  @NotNull
  @Column(name = "DESCRIPCION")
  private String descripcion;

}
