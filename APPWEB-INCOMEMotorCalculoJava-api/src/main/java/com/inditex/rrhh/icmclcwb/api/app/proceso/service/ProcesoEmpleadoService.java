package com.inditex.rrhh.icmclcwb.api.app.proceso.service;

import java.util.List;

import javax.validation.Valid;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoDto;

public interface ProcesoEmpleadoService {

    List<ProcesoEmpleadoDto> findByProceso(@Valid final ProcesoDto proceso);
    
    List<ProcesoEmpleadoDto> createProcesoEmpleado(@Valid final ProcesoDto proceso, final List<ProcesoEmpleadoDto> procesoEmpleado);

}
