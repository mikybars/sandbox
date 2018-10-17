package com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "PRESENCIAS_HORARIOS")
@Data
public class PresenciaDetalleMock {
	
	@Id
	@Column(name = "ID")
	private Integer id;

	@NotNull
	@Column(name = "TIENDA", nullable = false)
	private Integer tienda;

	@NotBlank
	@Column(name = "SECCION", nullable = false)
	private Integer seccion;
	
	@NotNull
	@Column(name = "PERSONA", nullable = false)
	private Integer persona;

	@NotNull
	@Column(name = "HORAS", nullable = true)
	private Integer horas;

	@Column(name = "FECHA", nullable = false)
	private Date fecha;


	@Column(name = "TIPO", nullable = false)
	private Integer tipo;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEstado() {
		return tienda;
	}

	public void setEstado(Integer estado) {
		this.tienda = estado;
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


	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}


	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

}
