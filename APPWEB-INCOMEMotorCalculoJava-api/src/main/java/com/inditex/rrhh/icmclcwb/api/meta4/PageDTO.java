package com.inditex.rrhh.icmclcwb.api.meta4;


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
			// Primera carga, en las iteraciones cuando no hay registros, llega {numeroPagina: 0, numeroTotalPaginas: 0}
			if (Integer.compare(numeroPagina, NumberUtils.INTEGER_ZERO) == 0 && numeroTotalPaginas == null) {
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