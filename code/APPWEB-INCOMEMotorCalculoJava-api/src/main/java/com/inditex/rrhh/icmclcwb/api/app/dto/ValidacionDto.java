package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class ValidacionDto implements Serializable {

  private static final long serialVersionUID = -2130233513919563977L;

  private Boolean result;

  private Long idTareaFaseAccion;

  private Integer reaccionPeso;

  private String cclIdOrigen;

  private String stdIdLegEnt;

  private List<String> idPersonaLocal;

  private Boolean sincronizacion;

  private List<Integer> idMotivosDesplazamiento;

  private PresenciaOrigenDto comis;

  private PresenciaOrigenDto ptr;

  private List<String> idLocalizacionLocal;

}
