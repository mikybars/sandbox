package com.inditex.rrhh.icmclcwb.api.meta4.login.login.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LoginResponseDto implements Serializable {

  private static final long serialVersionUID = 8224685868544251698L;

  private String sessionID;

}
