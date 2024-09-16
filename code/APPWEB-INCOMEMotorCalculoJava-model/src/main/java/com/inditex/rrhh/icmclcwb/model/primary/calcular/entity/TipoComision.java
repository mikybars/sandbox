package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "TIPO_COMISION")
@Data
public class TipoComision {

  @Id
  @Column(name = "ID_TIPO_COMISION", length = 24)
  private String id;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

  @ManyToMany(mappedBy = "tipoComision")
  private List<Algoritmo> algoritmo = new ArrayList<Algoritmo>();

}
