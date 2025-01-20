package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ALGORITMO")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
