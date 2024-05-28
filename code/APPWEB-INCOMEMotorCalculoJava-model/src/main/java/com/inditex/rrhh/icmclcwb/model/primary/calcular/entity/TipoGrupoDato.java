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
import lombok.Data;

@Entity
@Table(name = "TIPO_GRUPO_DATO")
@Data
public class TipoGrupoDato {

  @Id
  @Column(name = "ID_TIPO_GRUPO_DATO")
  private Integer id;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

  @NotBlank
  @Column(name = "DESCRIPCION", length = /* TAMANO_DESC */ 255, nullable = false)
  private String descripcion;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "TIPO_GRUPO_DATO_TIPO_DATO", joinColumns = {
      @JoinColumn(name = "ID_TIPO_GRUPO_DATO")}, inverseJoinColumns = {@JoinColumn(name = "ID_TIPO_DATO")})
  private Set<TipoDato> tipoDato;

}
