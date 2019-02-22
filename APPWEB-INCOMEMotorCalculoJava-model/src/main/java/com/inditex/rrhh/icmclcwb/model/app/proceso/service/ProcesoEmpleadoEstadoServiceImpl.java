package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoEmpleadoEstadoService;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoEmpleadoEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoEmpleadoEstadoRepositoryCustom;

@Service
@Validated
public class ProcesoEmpleadoEstadoServiceImpl implements ProcesoEmpleadoEstadoService {

    @Autowired
    private ProcesoEmpleadoEstadoRepository procesoEmpleadoEstadoRepository;

    @Autowired
    private ProcesoEmpleadoEstadoRepositoryCustom procesoEmpleadoEstadoRepositoryCustom;

    @Autowired
    private ProcesoEmpleadoEstadoMapper procesoEmpleadoEstadoMapper;

    @Override
    public List<ProcesoEmpleadoEstadoDto> save(@Valid final List<ProcesoEmpleadoEstadoDto> procesoEmpleadoEstado) {
        return procesoEmpleadoEstadoMapper.procesoEmpleadoEstadoToProcesoEmpleadoEstadoDto(
                procesoEmpleadoEstadoRepositoryCustom.save(procesoEmpleadoEstadoMapper
                        .procesoEmpleadoEstadoDtoToProcesoEmpleadoEstado(procesoEmpleadoEstado)));
    }

    @Override
    public List<ProcesoEmpleadoEstadoDto> save(@Valid final List<ProcesoEmpleadoEstadoDto> procesoEmpleadoEstado,
            @Valid final ProcesoDto proceso) {
        return procesoEmpleadoEstadoMapper
                .procesoEmpleadoEstadoToProcesoEmpleadoEstadoDto(procesoEmpleadoEstadoRepositoryCustom.save(
                        procesoEmpleadoEstadoMapper.mergeProcesoEmpleadoEstadoDtoAndProcesoDtoToProcesoEmpleadoEstado(
                                procesoEmpleadoEstado, proceso)));
    }

    @Override
    public List<String> findIdsEmpleadoByIdProcesoAndIdEstado(final Long idProceso, final Long idEstado) {
        return procesoEmpleadoEstadoRepository.findIdsEmpleadoByIdProcesoAndIdEstado(idProceso, idEstado);
    }

}