package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
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
