package com.inditex.rrhh.icmclcwb.api.meta4.login.login.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SesionMeta4Dto implements Serializable {

	private static final long serialVersionUID = -3473147313502370674L;

	private String id;

	private String user;

	private String language;

	private String password;

	private LocalDateTime fechaCreacion;
	
	private Boolean activa;

}