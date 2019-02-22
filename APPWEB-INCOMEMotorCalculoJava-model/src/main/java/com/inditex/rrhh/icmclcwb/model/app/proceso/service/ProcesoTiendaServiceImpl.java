package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTiendaService;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoTiendaRepository;

@Service
@Validated
public class ProcesoTiendaServiceImpl implements ProcesoTiendaService {

    @Autowired
    private ProcesoTiendaRepository procesoTiendaRepository;

    @Autowired
    private ProcesoTiendaMapper procesoTiendaMapper;

    @Override
    public List<ProcesoTiendaDto> findByProceso(@Valid @NotNull final ProcesoDto proceso) {
        return procesoTiendaMapper
                .procesoTiendaToProcesoTiendaDto(procesoTiendaRepository.findByProcesoId(proceso.getId()));
    }

    @Override
    public List<ProcesoTiendaDto> createProcesoTienda(@Valid @NotNull ProcesoDto proceso,
            @NotNull List<ProcesoTiendaDto> procesoTienda) {
        return procesoTiendaMapper.procesoTiendaToProcesoTiendaDto(procesoTiendaRepository
                .saveAll(procesoTiendaMapper.mergeProcesoTiendaDtoAndProcesoDtoToProcesoTienda(procesoTienda, proceso)));
    }

}