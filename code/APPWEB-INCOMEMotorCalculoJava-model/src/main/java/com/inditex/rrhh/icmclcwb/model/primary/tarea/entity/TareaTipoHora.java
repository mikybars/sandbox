package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TAREA_TIPO_HORA")
@Data
public class TareaTipoHora {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_TIPO_HORA")
  private Long id;

  @NotNull
  @Column(name = "COD_TIPO_HORA", nullable = false)
  private Integer idTipoHora;

  @Column(name = "ES_EXCLUIDO_CALCULO", nullable = false)
  private Boolean excluidoCalculo;

  @Column(name = "ES_EXCLUIDO_DENOMINADOR", nullable = false)
  private Boolean excluidoDenominador;

  @Column(name = "ES_INCLUIDO_VENTA", nullable = false)
  private Boolean incluidoVenta;

  @Column(name = "ES_INCLUIDO_CHALLENGE", nullable = false)
  private Boolean incluidoChallenge;

  @Column(name = "ES_INCLUIDO_ECOMMERCE", nullable = false)
  private Boolean incluidoEcommerce;

  @Column(name = "ES_EXCLUIDO_DENOMINADOR_Y_REPARTIDO_PROVINCIA", nullable = false)
  private Boolean excluidoDenominadorYRepartidoProvincia;

  @Column(name = "ES_INCLUIDO_CHALLENGE_PORCENTAJE", nullable = false)
  private Boolean incluidoChallengePorcentaje;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

}
