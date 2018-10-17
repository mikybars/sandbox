package com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class PresenciaGHRS {
	
	/**@Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    private long id;
    
	private Integer tipo;
	
	private Integer tienda;
	
	private Date fecha;
	
	private Integer seccion;
	
	private Integer persona;
	
	private Integer horas;
	
	private Integer ccl_id_origen;
	
}