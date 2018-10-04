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

import lombok.Data;

//@Entity
@Table(name = "TEST_INCOME_JOB")
public class PresenciaDetalleMock {
	

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


	@Column(name = "TIPO", nullable = false)
	private Integer tipo;

	@Column(name = "CADENA", nullable = true)
	private Integer cadena;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getSeccion() {
		return seccion;
	}

	public void setSeccion(Integer seccion) {
		this.seccion = seccion;
	}

	public Integer getPersona() {
		return persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaFinJob() {
		return fechaFinJob;
	}

	public void setFechaFinJob(Date fechaFinJob) {
		this.fechaFinJob = fechaFinJob;
	}
	
	
	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getCadena() {
		return cadena;
	}

	public void setCadena(Integer cadena) {
		this.cadena = cadena;
	}

}
