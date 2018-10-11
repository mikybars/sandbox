package com.inditex.rrhh.icmclcwb.model.primary.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "PROGRAMACION", schema = "INCOME")
@Data
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private /* BigInteger */ Long id;

	@NotNull
	@Column(name = "HORA", nullable = false)
	private Time hora;

	@NotNull
	@Column(name = "ACTIVA", nullable = false)
	private Boolean activa;

	@Column(name = "ID_PAIS", nullable = true)
	private String idPais;

	@Column(name = "ID_CADENA", nullable = true)
	private String idCadena;
	
	@Column(name = "ID_TIENDA", nullable = true)
	private String idTienda;

	@Column(name = "ID_EMPLEADO", nullable = true)
	private String idEmpleado;
	
	@NotBlank
	@Column(name = "USUARIO", nullable = false)
	private String usuario;

	@NotNull
	@Column(name = "PERIODO", nullable = false)
	private /* BigInteger */ Long periodo;

	@NotNull
	@Column(name = "FECHA_CREACION", nullable = false)
	private Date fechaCreacion;

	@NotNull
	@Column(name = "FECHA_EJECUCION", nullable = false)
	private Date fechaEjecucion;

}