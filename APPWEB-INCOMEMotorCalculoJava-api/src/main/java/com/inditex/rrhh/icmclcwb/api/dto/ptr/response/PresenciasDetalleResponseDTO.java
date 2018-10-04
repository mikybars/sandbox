package com.inditex.rrhh.icmclcwb.api.dto.ptr.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PresenciasDetalleResponseDTO implements Serializable{
	private Integer tienda;
	private Integer seccion;
	private Integer persona;
	private Date fechaDesde;
	private Date fechaHasta;
	private Integer minutos;
	private Integer tipo;
	private Integer cadena; //Obligatorio	
	
	
	public Integer getMinutos() {
		return minutos;
	}
	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}
	
	
	
	public Integer getTienda() {
		return tienda;
	}
	public void setTienda(Integer tienda) {
		this.tienda = tienda;
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
	public Date getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
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
