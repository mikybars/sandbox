package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class SearchEmpleadosFilterDto implements Serializable {

  private static final long serialVersionUID = -1370919432460766787L;

  private LocalDateTime fechaInicio;

  private LocalDateTime fechaFin;

  private String idOrigen;

  private List<String> idsEmpresa;

  private List<String> idsCadena;

}
