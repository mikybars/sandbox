package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTiendaSeccionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTiendaSeccionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoTiendaSeccionVentaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoTiendaSeccionVentaRepositoryCustom;

@Service
@Validated
public class ProcesoTiendaSeccionVentaServiceImpl implements ProcesoTiendaSeccionVentaService {

    @Autowired
    private ProcesoTiendaSeccionVentaMapper mapper;

    @Autowired
    private ProcesoTiendaSeccionVentaRepository procesoTiendaSeccionVentaRepository;
    
    @Autowired
    private ProcesoTiendaSeccionVentaRepositoryCustom procesoTiendaSeccionVentaRepositoryCustom;

    @Override
    public ProcesoTiendaSeccionVentaDto save(@Valid final ProcesoTiendaSeccionVentaDto dto) {
        return mapper.procesoTiendaSeccionVentaToProcesoTiendaSeccionVentaDto(procesoTiendaSeccionVentaRepository
                .save(mapper.procesoTiendaSeccionVentaDtoToProcesoTiendaSeccionVenta(dto)));
    }

    @Override
    public ProcesoTiendaSeccionVentaDto save(PtrVentaTotalizadoResultItemDto dto, ProcesoDto procesoDto) {
        return mapper.procesoTiendaSeccionVentaToProcesoTiendaSeccionVentaDto(procesoTiendaSeccionVentaRepository
                .save(mapper.getVentaTotalizadoResponseItemDtoToProcesoTiendaSeccionVenta(dto, procesoDto)));
    }

    @Override
    public List<ProcesoTiendaSeccionVentaDto> save(List<PtrVentaTotalizadoResultItemDto> dto, ProcesoDto procesoDto) {
        return mapper.procesoTiendaSeccionVentasToProcesoTiendaSeccionVentasDto(procesoTiendaSeccionVentaRepositoryCustom
                .save(mapper.getVentaTotalizadoReponseItemsDtoToProcesoTiendaSeccionVentas(dto, procesoDto)));
    }

}
