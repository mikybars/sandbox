package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoEmpleadoService;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoEmpleadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoEmpleadoRepository;

@Service
@Validated
public class ProcesoEmpleadoServiceImpl implements ProcesoEmpleadoService {

    @Autowired
    private ProcesoEmpleadoRepository procesoEmpleadoRepository;

    @Autowired
    private ProcesoEmpleadoMapper procesoEmpleadoMapper;

    @Override
    public List<ProcesoEmpleadoDto> findByProceso(@Valid ProcesoDto proceso) {
        return procesoEmpleadoMapper
                .procesoEmpleadoToProcesoEmpleadoDto(procesoEmpleadoRepository.findByProcesoId(proceso.getId()));
    }

    @Override
    public List<ProcesoEmpleadoDto> createProcesoEmpleado(@Valid ProcesoDto proceso,
            List<ProcesoEmpleadoDto> procesoEmpleado) {
        return procesoEmpleadoMapper.procesoEmpleadoToProcesoEmpleadoDto(procesoEmpleadoRepository.saveAll(
                procesoEmpleadoMapper.mergeProcesoEmpleadoDtoAndProcesoDtoToProcesoEmpleado(procesoEmpleado, proceso)));
    }

}