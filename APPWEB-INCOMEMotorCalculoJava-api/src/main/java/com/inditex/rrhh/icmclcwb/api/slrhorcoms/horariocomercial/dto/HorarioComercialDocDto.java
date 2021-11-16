/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercial.dto;

import java.io.Serializable;
import java.util.Date;

import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.DocDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class HorarioComercialDocDto extends DocDto implements Serializable {

  private static final long serialVersionUID = 4232659811133655433L;

  private String excepcion;

  private String tienda;

  private Date fecha;

  private String festivo;

  private boolean apertura;

  private Date inicio;

  private String idTipoTemporadaComercial;

  private String temporada;

  private int idTienda;

  @JsonProperty("final")
  private Date finald;

  private String tipoExcepcion;

  private String horario;

  private String idExcepcion;

  private String idCadena;

  private String cadena;

  private String id;

  private int diaSemana;

  private Date ultimaFechaModificacion;

  private Object _version_;

  private String franja1Fin;

  private String franja1Inicio;

}
