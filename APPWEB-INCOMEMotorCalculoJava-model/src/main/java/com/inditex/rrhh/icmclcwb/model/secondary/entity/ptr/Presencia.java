package com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.Job;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.JobEstado;

import lombok.Data;

//@Entity
@Table(name = "TEST_INCOME_JOB")
public class Presencia {
	
	
	
	/**	private Integer tienda;
	private Integer seccion;
	private List<Integer> persona;
	private Date fechaDesde;
	private Date fechaHasta;
	private Integer tipo;
	private Integer cadena;
	**/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "TIENDA", nullable = false)
	private Integer estado;

	@NotBlank
	@Column(name = "SECCION", nullable = false)
	private Integer seccion;
	
	@NotNull
	@Column(name = "PERSONA", nullable = false)
	private Integer persona;

	@NotNull
	@Column(name = "FECHA", nullable = false)
	private Date fechaCreacion;

	@Column(name = "FECHA_VENCIMIENTO", nullable = true)
	private Date fechaFinJob;
	
	
	//FALTAN HORAS Y TOTAL HORAS
	
}
