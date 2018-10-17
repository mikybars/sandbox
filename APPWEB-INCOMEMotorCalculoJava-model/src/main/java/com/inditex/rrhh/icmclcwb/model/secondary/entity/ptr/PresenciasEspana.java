package com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr;

import java.sql.Date;

import lombok.Data;

@Data
public class PresenciasEspana {

	/**@Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    private long id;
    
	private Integer tipo;
	
	private Integer tienda;
	
	private Date fecha;
	
	private Integer seccion;
	
	private Integer persona;
	
	private Integer horas;//DUDA
	
	private Integer ccl_id_origen;
}
