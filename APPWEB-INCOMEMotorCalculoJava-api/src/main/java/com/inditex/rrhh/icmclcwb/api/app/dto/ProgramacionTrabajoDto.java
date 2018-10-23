package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProgramacionTrabajoDto implements Serializable {

	private static final long serialVersionUID = 3665361916795418905L;

	private ProgramacionDto programacion;

	private TrabajoDto trabajo;

}