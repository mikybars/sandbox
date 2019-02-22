package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoEmpleadoHistoricoService;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoEmpleadoHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoEmpleadoHistoricoRepositoryCustom;

@Service
@Validated
public class ProcesoEmpleadoHistoricoServiceImpl implements ProcesoEmpleadoHistoricoService {

    @Autowired
    private ProcesoEmpleadoHistoricoRepositoryCustom procesoEmpleadoHistoricoRepositoryCustom;

    @Autowired
    private ProcesoEmpleadoHistoricoMapper procesoEmpleadoHistoricoMapper;

    @Override
    public List<ProcesoEmpleadoHistoricoDto> save(final List<ProcesoEmpleadoHistoricoDto> procesoEmpleadoHistorico , @Valid ProcesoDto proceso) {
        return procesoEmpleadoHistoricoMapper.procesoEmpleadoHistoricoToProcesoEmpleadoHistoricoDto(
                procesoEmpleadoHistoricoRepositoryCustom.save(procesoEmpleadoHistoricoMapper
                        .mergeProcesoEmpleadoHistoricoDtoAndProcesoDtoToProcesoEmpleadoHistorico(procesoEmpleadoHistorico,
                                proceso)));
    }
    
    
}
