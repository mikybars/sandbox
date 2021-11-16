package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class SearchTiendasFilterDto implements Serializable {

  private LocalDateTime fechaInicio;

  private LocalDateTime fechaFin;

  private String idOrigen;

  private List<String> idsEmpresa;

  private List<String> idsCadena;

  private List<SearchTiendasFilterParametersDto> item;

}
