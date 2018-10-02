package com.inditex.rrhh.icmclcwb.api.dto.ptr.response;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.TiendaSeccionDTO;

public class PresenciasTotalTiendaSeccionResponseDTO {
	private Integer tienda;
	private String fechaDesde;
	private String fechaHasta;
	private Integer seccion;
	private Integer minutos;
	

	public Integer getTienda() {
		return tienda;
	}
	public void setTienda(Integer tienda) {
		this.tienda = tienda;
	}
	public String getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public String getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public Integer getSeccion() {
		return seccion;
	}
	public void setSeccion(Integer seccion) {
		this.seccion = seccion;
	}
	public Integer getMinutos() {
		return minutos;
	}
	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}

}
