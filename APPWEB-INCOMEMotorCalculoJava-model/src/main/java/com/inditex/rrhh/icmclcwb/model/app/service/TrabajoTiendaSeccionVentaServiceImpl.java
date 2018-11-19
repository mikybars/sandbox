package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoResponseItemDTO;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaSeccionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaSeccionVentaRepository;

@Service
@Validated
public class TrabajoTiendaSeccionVentaServiceImpl implements TrabajoTiendaSeccionVentaService {

    @Autowired
    private TrabajoTiendaSeccionVentaMapper mapper;

    @Autowired
    private TrabajoTiendaSeccionVentaRepository trabajoTiendaSeccionVentaRepository;

    @Override
    public TrabajoTiendaSeccionVentaDto save(@Valid final TrabajoTiendaSeccionVentaDto dto) {
        return mapper.trabajoTiendaSeccionVentaToTrabajoTiendaSeccionVentaDto(trabajoTiendaSeccionVentaRepository
                .save(mapper.trabajoTiendaSeccionVentaDtoToTrabajoTiendaSeccionVenta(dto)));
    }

    @Override
    public TrabajoTiendaSeccionVentaDto save(GetVentaTotalizadoResponseItemDTO dto, TrabajoDto trabajoDto) {
        return mapper.trabajoTiendaSeccionVentaToTrabajoTiendaSeccionVentaDto(trabajoTiendaSeccionVentaRepository
                .save(mapper.getVentaTotalizadoResponseItemDTOToTrabajoTiendaSeccionVenta(dto, trabajoDto)));
    }

    @Transactional(timeout = 60) // TODO: Revisar timeouts en transacciones
    @Override
    public List<TrabajoTiendaSeccionVentaDto> save(List<GetVentaTotalizadoResponseItemDTO> dto, TrabajoDto trabajoDto) {
        return mapper.trabajoTiendaSeccionVentasToTrabajoTiendaSeccionVentasDto(trabajoTiendaSeccionVentaRepository
                .save(mapper.getVentaTotalizadoReponseItemsDtoToTrabajoTiendaSeccionVentas(dto, trabajoDto)));
    }

}
