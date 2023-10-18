package com.inditex.rrhh.icmclcwb.model.primary.proceso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TIPO_SISTEMA_DESTINO")
@Data
public class TipoSistemaDestino {

  @Id
  @Column(name = "ID_TIPO_SISTEMA_DESTINO")
  private Integer id;

  @Column(name = "ICM_ID_TP_SISTEMA", nullable = false)
  private String icmIdTpSistema;

  @Column(name = "NOMBRE", nullable = false, length = 128)
  private String nombre;

}
