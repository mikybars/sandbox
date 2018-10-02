package com.inditex.rrhh.icmclcwb.api.dto.ptr.response;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasTotalTiendaRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PresenciasTotalTiendaResponseDTO {
	//TODO Pendiente de definir campos
	private List<Integer> tienda;
	private String fechaDesde;
	private String fechaHasta;
	private Integer minutos;
	
	
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
}
