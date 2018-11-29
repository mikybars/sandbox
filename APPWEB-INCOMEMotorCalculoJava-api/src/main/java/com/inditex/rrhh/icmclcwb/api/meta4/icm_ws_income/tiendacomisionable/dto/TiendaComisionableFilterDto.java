package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendacomisionable.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TiendaComisionableFilterDto implements Serializable {
	
	private static final long serialVersionUID = 8479041142452942349L;
	
    private LocalDateTime fechaFin;
    protected String idEstado;
    private LocalDateTime fechaInicio;
    protected String idEstadoMtu;
    protected String idLugarTrabajo;
}
