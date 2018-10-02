package com.inditex.rrhh.icmclcwb.api.dto.ptr.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PresenciasTotalTiendaSeccionRequestDTO {

		private List<TiendaSeccionDTO> tiendaSeccion;
		private String fechaDesde;
		private String fechaHasta;
		private Integer tipo;
		private Integer cadena;
		
		
		public List<TiendaSeccionDTO> getTiendaSeccion() {
			return tiendaSeccion;
		}
		public void setTiendaSeccion(List<TiendaSeccionDTO> tiendaSeccion) {
			this.tiendaSeccion = tiendaSeccion;
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
}
		
	