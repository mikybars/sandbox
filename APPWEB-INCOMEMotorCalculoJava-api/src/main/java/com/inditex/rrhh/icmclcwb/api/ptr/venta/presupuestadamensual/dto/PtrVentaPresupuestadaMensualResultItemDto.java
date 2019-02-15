package com.inditex.rrhh.icmclcwb.api.ptr.venta.presupuestadamensual.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class PtrVentaPresupuestadaMensualResultItemDto implements Serializable {
	
	private static final long serialVersionUID = -801740758955645983L;

	private Integer idEjercicio;

	private Integer mes;

	private Integer idTipoSeccion;
	
    private String tipoSeccion;

	private Integer unidades;

	private BigDecimal importe;

	private BigDecimal importeSinImpuestos;
	

}
