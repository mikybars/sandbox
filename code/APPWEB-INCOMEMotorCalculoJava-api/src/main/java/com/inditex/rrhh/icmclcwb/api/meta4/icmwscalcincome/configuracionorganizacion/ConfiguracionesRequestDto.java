package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ConfiguracionesRequestDto extends GenericFilterParametersDto
    implements Serializable {

  private static final long serialVersionUID = 6004857776815885351L;

  private String idOrigen;

  private LocalDateTime fechaInicio;

  private LocalDateTime fechaFin;

  private List<ConfiguracionesRequestItemDto> items;

}
