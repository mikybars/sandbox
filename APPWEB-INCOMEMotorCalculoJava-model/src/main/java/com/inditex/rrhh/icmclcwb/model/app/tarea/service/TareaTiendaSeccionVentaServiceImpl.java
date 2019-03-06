package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaSeccionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaSeccionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaSeccionVentaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaSeccionVentaRepositoryCustom;

@Service
@Validated
public class TareaTiendaSeccionVentaServiceImpl implements TareaTiendaSeccionVentaService {

    @Autowired
    private TareaTiendaSeccionVentaMapper mapper;

    @Autowired
    private TareaTiendaSeccionVentaRepository tareaTiendaSeccionVentaRepository;
    
    @Autowired
    private TareaTiendaSeccionVentaRepositoryCustom tareaTiendaSeccionVentaRepositoryCustom;

    @Override
    public TareaTiendaSeccionVentaDto save(@Valid final TareaTiendaSeccionVentaDto dto) {
        return mapper.tareaTiendaSeccionVentaToTareaTiendaSeccionVentaDto(tareaTiendaSeccionVentaRepository
                .save(mapper.tareaTiendaSeccionVentaDtoToTareaTiendaSeccionVenta(dto)));
    }

    @Override
    public TareaTiendaSeccionVentaDto save(PtrVentaTotalizadoResultItemDto dto, TareaDto tareaDto) {
        return mapper.tareaTiendaSeccionVentaToTareaTiendaSeccionVentaDto(tareaTiendaSeccionVentaRepository
                .save(mapper.getVentaTotalizadoResponseItemDtoToTareaTiendaSeccionVenta(dto, tareaDto)));
    }

    @Override
    public List<TareaTiendaSeccionVentaDto> save(List<PtrVentaTotalizadoResultItemDto> dto, TareaDto tareaDto) {
        return mapper.tareaTiendaSeccionVentasToTareaTiendaSeccionVentasDto(tareaTiendaSeccionVentaRepositoryCustom
                .save(mapper.getVentaTotalizadoReponseItemsDtoToTareaTiendaSeccionVentas(dto, tareaDto)));
    }

}
