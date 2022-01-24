package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "ALGORITMO")
@Data
public class Algoritmo {

  @Id
  @Column(name = "ID_ALGORITMO")
  private Integer id;

  @NotNull
  @Column(name = "ES_ACTIVO", nullable = false)
  private Boolean activo;

  @NotNull
  @Column(name = "ES_DESPLAZAMIENTO", nullable = false)
  private Boolean desplazamiento;

  @NotNull
  @Column(name = "ES_DESPLAZAMIENTO_BASE", nullable = false)
  private Boolean desplazamientoBase;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "ALGORITMO_TIPO_COMISION", joinColumns = {
      @JoinColumn(name = "ID_ALGORITMO")}, inverseJoinColumns = {@JoinColumn(name = "ID_TIPO_COMISION")})
  private Set<TipoComision> tipoComision;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "ALGORITMO_TIPO_CALCULO", joinColumns = {
      @JoinColumn(name = "ID_ALGORITMO")}, inverseJoinColumns = {@JoinColumn(name = "ID_TIPO_CALCULO")})
  private Set<TipoCalculo> tipoCalculo;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "ALGORITMO_TIPO_DATO", joinColumns = {
      @JoinColumn(name = "ID_ALGORITMO")}, inverseJoinColumns = {@JoinColumn(name = "ID_TIPO_DATO")})
  private Set<TipoDato> tipoDato;

}
