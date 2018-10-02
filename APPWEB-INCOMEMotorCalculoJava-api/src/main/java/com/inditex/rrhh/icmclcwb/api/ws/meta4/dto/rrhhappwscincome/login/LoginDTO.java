package com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.login;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LoginDTO implements Serializable {

	private static final long serialVersionUID = 8224685868544251698L;

	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String language;

}