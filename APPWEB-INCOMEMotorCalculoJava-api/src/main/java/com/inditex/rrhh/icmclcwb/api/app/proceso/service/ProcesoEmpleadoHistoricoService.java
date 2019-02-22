package com.inditex.rrhh.icmclcwb.api.app.proceso.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoHistoricoDto;

public interface ProcesoEmpleadoHistoricoService {

    List<ProcesoEmpleadoHistoricoDto> save(List<ProcesoEmpleadoHistoricoDto> procesoEmpleadoHistorico,
            @Valid ProcesoDto proceso);


}
