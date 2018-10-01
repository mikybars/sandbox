package com.inditex.rrhh.icmclcwb.api.dto.ptr.request;
/**
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString**/
public class TiendaSeccionDTO {

	private Integer tienda;
	private Integer seccion;
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
	
	
}
