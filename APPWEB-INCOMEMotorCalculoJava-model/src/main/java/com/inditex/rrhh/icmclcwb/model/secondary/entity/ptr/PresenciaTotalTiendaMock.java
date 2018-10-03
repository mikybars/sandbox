package com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr;

import java.util.List;

public class PresenciaTotalTiendaMock {
	private List<Integer> tienda;
	private String fechaDesde;
	private String fechaHasta;
	
	
	public List<Integer> getTienda() {
		return tienda;
	}
	public void setTienda(List<Integer> tienda) {
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
	public Integer getMinutos() {
		return minutos;
	}
	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}
	private Integer minutos;
}
