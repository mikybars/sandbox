package com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.authenticate.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticateDto implements Serializable {

  private static final long serialVersionUID = 900712075147219381L;

  private String message;

  private String accessToken;

  private String refreshToken;

  private LocalDateTime creationDate;

}
