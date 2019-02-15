package com.inditex.rrhh.icmclcwb.api.ptr.venta.presupuestadamensual.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PtrVentaPresupuestadaMensualRequestDto implements Serializable {

    private static final long serialVersionUID = -1280673227981544335L;

    @NotNull
	private Integer idTienda;
	
	@NotNull
	private Integer idEjercicio;

	@NotNull
	private List<Integer> idTipoSeccion = new ArrayList<>();

}
