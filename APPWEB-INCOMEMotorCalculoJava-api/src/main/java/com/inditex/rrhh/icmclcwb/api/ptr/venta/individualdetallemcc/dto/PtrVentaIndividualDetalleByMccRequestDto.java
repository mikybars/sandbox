package com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetallemcc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.MccType;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;

import lombok.Data;

@Data
public class PtrVentaIndividualDetalleByMccRequestDto implements Serializable {

    private static final long serialVersionUID = -6922281264661215699L;

    @NotNull
	private String fechaDesde;
	
	@NotNull
	private String fechaHasta;

	@NotNull
	private Integer pais;

	@NotNull
	private Integer cadena;

	private List<Integer> tienda = new ArrayList<>();
	
	private Integer seccion;
	
	private Integer temporada;
	
	private Integer producto;
	
	private List<Integer> vendedores = new ArrayList<>();
	
	private MccType mcc;
	
	private Integer familia;
	
	private Integer subFamilia;
	
	private PtrGroupTypeEnum agrupacion;

}
