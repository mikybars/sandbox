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
@Table(name = "TIPO_CALCULO")
@Data
public class TipoCalculo {

  @Id
  @Column(name = "ID_TIPO_CALCULO", length = 24)
  private String id;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

  @ManyToMany(mappedBy = "tipoCalculo")
  private List<Algoritmo> algoritmo = new ArrayList<Algoritmo>();

}
