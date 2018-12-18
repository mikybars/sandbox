package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Meta4ClientSession implements Serializable {

	private static final long serialVersionUID = -3473147313502370674L;

	private String id;
	
	private String jSessionID;

	private LocalDateTime fechaCreacion;

	private LocalDateTime fechaUso;
	
	private long uso;

}
