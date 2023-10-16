package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class SaveProcesoDto implements Serializable {

  private static final long serialVersionUID = -5223418179902973150L;

  private String idAmbito;

  private String idOrigen;

  private String nombreUsuario;

  private String idOrganization;

  private Long idPeriodo;

  private Long idTrabajo;

  private String idTipoEjecucionCalculo;

  private List<SaveProcesoParametersDto> item;

}
