package com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;

import lombok.Data;

@Data
public class EndpointResponseDto implements Serializable {

  @Serial
  private static final long serialVersionUID = -2693622743316270172L;

  private List<HorarioComercialFestivoDocDto> data;

}
