package com.inditex.rrhh.icmclcwb.api.ptr.venta.diaria.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PtrVentaDiariaResultItemDto implements Serializable {
	
	private static final long serialVersionUID = -801740758955645983L;

	@NotBlank
	private String fecha;

	private Integer idTipoSeccion;
	
    private String tipoSeccion;

	private Integer unidades;

    @NotNull
    private BigDecimal importe;

    @NotNull
    private BigDecimal importeSinImpuestos;
	
}
