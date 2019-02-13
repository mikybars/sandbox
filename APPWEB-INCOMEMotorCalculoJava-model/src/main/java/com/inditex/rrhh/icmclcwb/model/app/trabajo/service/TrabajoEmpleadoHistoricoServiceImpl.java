package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoEmpleadoHistoricoService;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoEmpleadoHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoEmpleadoHistoricoRepositoryCustom;

@Service
@Validated
public class TrabajoEmpleadoHistoricoServiceImpl implements TrabajoEmpleadoHistoricoService {

    @Autowired
    private TrabajoEmpleadoHistoricoRepositoryCustom trabajoEmpleadoHistoricoRepositoryCustom;

    @Autowired
    private TrabajoEmpleadoHistoricoMapper trabajoEmpleadoHistoricoMapper;

    @Override
    public List<TrabajoEmpleadoHistoricoDto> save(final List<TrabajoEmpleadoHistoricoDto> trabajoEmpleadoHistorico , @Valid TrabajoDto trabajo) {
        return trabajoEmpleadoHistoricoMapper.trabajoEmpleadoHistoricoToTrabajoEmpleadoHistoricoDto(
                trabajoEmpleadoHistoricoRepositoryCustom.save(trabajoEmpleadoHistoricoMapper
                        .mergeTrabajoEmpleadoHistoricoDtoAndTrabajoDtoToTrabajoEmpleadoHistorico(trabajoEmpleadoHistorico,
                                trabajo)));
    }
    
    
}
