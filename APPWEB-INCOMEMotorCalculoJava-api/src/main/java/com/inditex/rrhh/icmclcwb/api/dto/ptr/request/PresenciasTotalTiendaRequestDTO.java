package com.inditex.rrhh.icmclcwb.api.dto.ptr.request;

import java.io.Serializable;
import java.util.List;
/**
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString**/
public class PresenciasTotalTiendaRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Integer> tienda;
	private String fechaDesde;
	private String fechaHasta;
	private Integer tipo;
	private Integer cadena;
	
	
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}