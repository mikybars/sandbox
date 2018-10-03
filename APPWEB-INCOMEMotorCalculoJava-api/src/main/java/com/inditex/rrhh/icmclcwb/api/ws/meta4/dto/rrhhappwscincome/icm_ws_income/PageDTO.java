package com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.math.NumberUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PageDTO implements Serializable {
	
	private static final long serialVersionUID = 1951305116634110315L;

	private String tipoOrden;
	
	private String campoOrden;
	
	private String idBusqueda;
	
	private Integer numeroPagina;
	
	private Integer numeroTotalPaginas;
	
	private Integer numeroRegistrosPagina;
	
	private Integer numeroTotalResultados;

	public boolean hasNext() {
		boolean result = false;
		if (numeroPagina != null) {
			if (Integer.compare(numeroPagina, NumberUtils.INTEGER_ZERO) == 0) {
				result = true;
			} else if (numeroTotalPaginas != null && Integer.compare(numeroPagina, numeroTotalPaginas) < 0) {
				result = true;
			}
		}
		return result;
	}
	
	public PageDTO next() {
		if (hasNext()) {
			setNumeroPagina(new Integer(numeroPagina.intValue() + 1));
		} else {
			throw new NoSuchElementException();
		}
		return this;
	}
	
}