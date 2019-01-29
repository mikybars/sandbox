package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import lombok.Data;

import java.io.Serializable;

@Data
public class Meta4ClientCredentials implements Serializable {

	private static final long serialVersionUID = -3473147313502370674L;

	private String user;

	private String language;

	private String password;

}
