package com.inditex.rrhh.icmclcwb.api.app.proceso.service;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoEstructuraDto;

public interface ProcesoEmpleadoEstructuraService {

    List<ProcesoEmpleadoEstructuraDto> save(final List<ProcesoEmpleadoEstructuraDto> procesoEmpleadoHistorico,
            @Valid ProcesoDto proceso); 
    
    Set<Long> findIdTipoCalculoByIdProceso(@Valid Long idProceso);
    

}
