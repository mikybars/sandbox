package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoHistoricoService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoHistoricoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoHistoricoRepositoryCustom;

@Service
@Validated
public class TrabajoEmpleadoHistoricoServiceImpl implements TrabajoEmpleadoHistoricoService {

    @Autowired
    private TrabajoEmpleadoHistoricoRepository trabajoEmpleadoHistoricoRepository;
   
    @Autowired
    private TrabajoEmpleadoHistoricoRepositoryCustom trabajoEmpleadoHistoricoRepositoryCustom;

    @Autowired
    private TrabajoEmpleadoHistoricoMapper trabajoEmpleadoHistoricoMapper;

    //TODO: Eliminar este timeout
    @Override
//    @Transactional(timeout = 60)
    public List<TrabajoEmpleadoHistoricoDto> save(final List<TrabajoEmpleadoHistoricoDto> trabajoEmpleadoHistorico , @Valid TrabajoDto trabajo) throws Exception {
        return trabajoEmpleadoHistoricoMapper.trabajoEmpleadoHistoricoToTrabajoEmpleadoHistoricoDto(
                trabajoEmpleadoHistoricoRepositoryCustom.save(trabajoEmpleadoHistoricoMapper
                        .mergeTrabajoEmpleadoHistoricoDtoAndTrabajoDtoToTrabajoEmpleadoHistorico(trabajoEmpleadoHistorico,
                                trabajo)));
    }
    
    
}
