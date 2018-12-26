package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaSeccionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaSeccionVentaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaSeccionVentaRepositoryCustom;

@Service
@Validated
public class TrabajoTiendaSeccionVentaServiceImpl implements TrabajoTiendaSeccionVentaService {

    @Autowired
    private TrabajoTiendaSeccionVentaMapper mapper;

    @Autowired
    private TrabajoTiendaSeccionVentaRepository trabajoTiendaSeccionVentaRepository;
    
    @Autowired
    private TrabajoTiendaSeccionVentaRepositoryCustom trabajoTiendaSeccionVentaRepositoryCustom;

    @Override
    public TrabajoTiendaSeccionVentaDto save(@Valid final TrabajoTiendaSeccionVentaDto dto) {
        return mapper.trabajoTiendaSeccionVentaToTrabajoTiendaSeccionVentaDto(trabajoTiendaSeccionVentaRepository
                .save(mapper.trabajoTiendaSeccionVentaDtoToTrabajoTiendaSeccionVenta(dto)));
    }

    @Override
    public TrabajoTiendaSeccionVentaDto save(PtrVentaTotalizadoResultItemDto dto, TrabajoDto trabajoDto) {
        return mapper.trabajoTiendaSeccionVentaToTrabajoTiendaSeccionVentaDto(trabajoTiendaSeccionVentaRepository
                .save(mapper.getVentaTotalizadoResponseItemDtoToTrabajoTiendaSeccionVenta(dto, trabajoDto)));
    }

    @Override
    public List<TrabajoTiendaSeccionVentaDto> save(List<PtrVentaTotalizadoResultItemDto> dto, TrabajoDto trabajoDto) throws Exception {
        return mapper.trabajoTiendaSeccionVentasToTrabajoTiendaSeccionVentasDto(trabajoTiendaSeccionVentaRepositoryCustom
                .save(mapper.getVentaTotalizadoReponseItemsDtoToTrabajoTiendaSeccionVentas(dto, trabajoDto)));
    }

}
