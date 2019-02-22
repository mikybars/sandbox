package com.inditex.rrhh.icmclcwb.api.app.proceso.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.EstadoProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

public interface ProcesoService {

    ProcesoDto findProceso(@NotNull @Positive final Long id);
    
    List<ProcesoDto> findAllProceso();
    
	ProcesoDto createProceso(@Valid final ProcesoDto proceso);

	ProcesoDto modifyProceso(@Valid final ProcesoDto proceso);

	ProcesoDto modifyEstadoProceso(@Valid final ProcesoDto proceso, @Valid final EstadoProcesoDto estado);
	
	ProcesoDto modifyEstadoProcesoInicial(@Valid final ProcesoDto proceso, @Valid final EstadoProcesoDto estado);
	
	ProcesoDto modifyEstadoProcesoFinal(@Valid final ProcesoDto proceso, @Valid final EstadoProcesoDto estado);

}