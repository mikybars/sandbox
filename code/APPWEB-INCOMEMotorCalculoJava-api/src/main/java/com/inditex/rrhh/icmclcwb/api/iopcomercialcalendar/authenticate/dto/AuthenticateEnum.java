package com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.authenticate.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AuthenticateEnum {

  OK("Authenticated OK");

  private final String value;

}
