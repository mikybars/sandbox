package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

/*
 * Copyright (c) 2021. Inditex
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TIPO_LIMPIEZA")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TipoLimpieza {

  @Id
  @Column(name = "ID_TIPO_LIMPIEZA")
  private Integer id;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

  @NotBlank
  @Column(name = "DESCRIPCION", length = /* TAMANO_DESC */ 255, nullable = false)
  private String descripcion;

}
