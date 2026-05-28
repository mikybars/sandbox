package com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto;

/*
 * Copyright (c) 2021. Inditex
 */
import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.dto.DocDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HorarioComercialFestivoDocDto extends DocDto implements Serializable {

  private static final long serialVersionUID = 5421128138637048027L;

  private String storeId;

  private String date;

  private String name;

  private String type;

}
