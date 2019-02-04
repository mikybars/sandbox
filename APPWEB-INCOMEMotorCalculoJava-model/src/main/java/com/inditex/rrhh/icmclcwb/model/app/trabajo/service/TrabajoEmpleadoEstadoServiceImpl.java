package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoEmpleadoEstadoService;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoEstadoRepositoryCustom;

@Service
@Validated
public class TrabajoEmpleadoEstadoServiceImpl implements TrabajoEmpleadoEstadoService {

    @Autowired
    private TrabajoEmpleadoEstadoRepository trabajoEmpleadoEstadoRepository;

    @Autowired
    private TrabajoEmpleadoEstadoRepositoryCustom trabajoEmpleadoEstadoRepositoryCustom;

    @Autowired
    private TrabajoEmpleadoEstadoMapper trabajoEmpleadoEstadoMapper;

    @Override
    public List<TrabajoEmpleadoEstadoDto> save(@Valid final List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado)
            throws Exception {
        return trabajoEmpleadoEstadoMapper.trabajoEmpleadoEstadoToTrabajoEmpleadoEstadoDto(
                trabajoEmpleadoEstadoRepositoryCustom.save(trabajoEmpleadoEstadoMapper
                        .trabajoEmpleadoEstadoDtoToTrabajoEmpleadoEstado(trabajoEmpleadoEstado)));
    }

    @Override
    public List<TrabajoEmpleadoEstadoDto> save(@Valid final List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado,
            @Valid final TrabajoDto trabajo) throws Exception {
        return trabajoEmpleadoEstadoMapper
                .trabajoEmpleadoEstadoToTrabajoEmpleadoEstadoDto(trabajoEmpleadoEstadoRepositoryCustom.save(
                        trabajoEmpleadoEstadoMapper.mergeTrabajoEmpleadoEstadoDtoAndTrabajoDtoToTrabajoEmpleadoEstado(
                                trabajoEmpleadoEstado, trabajo)));
    }

    @Override
    public List<String> findIdsEmpleadoByIdTrabajoAndIdEstado(final Long idTrabajo, final Long idEstado) {
        return trabajoEmpleadoEstadoRepository.findIdsEmpleadoByIdTrabajoAndIdEstado(idTrabajo, idEstado);
    }

}