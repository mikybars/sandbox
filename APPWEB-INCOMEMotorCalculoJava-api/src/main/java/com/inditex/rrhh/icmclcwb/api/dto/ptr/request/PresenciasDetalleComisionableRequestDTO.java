package com.inditex.rrhh.icmclcwb.api.dto.ptr.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PresenciasDetalleComisionableRequestDTO  implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer tienda;
	private Integer seccion;
	private Integer persona;
	private Date fechaDesde;
	private Date fechaHasta;
	private Integer tipo;
	private Integer cadena;
	
	
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
