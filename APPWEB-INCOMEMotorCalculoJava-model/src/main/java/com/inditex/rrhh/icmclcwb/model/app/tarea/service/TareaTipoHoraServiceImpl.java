package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTipoHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTipoHoraService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTipoHoraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTipoHoraRepositoryCustom;

@Service
@Validated
public class TareaTipoHoraServiceImpl implements TareaTipoHoraService {

    @Autowired
    private TareaTipoHoraMapper mapper;

    @Autowired
    private TareaTipoHoraRepositoryCustom tareaTipoHoraRepositoryCustom;

    @Override
    public List<TareaTipoHoraDto> save(@Valid @NotNull @NotEmpty final List<PtrPresenciaTiposHorasResultItemDto> dto,
            @Valid @NotNull final TareaDto tareaDto) {
        return this.mapper.tareaTareaTipoHoraListTotareaTipoHoraDtoList(this.tareaTipoHoraRepositoryCustom
            .save(this.mapper.ptrPresenciaTipoHoraResponsesDtoToTareaTipoHoraDto(dto, tareaDto)));
    }

    @Override
    public List<TareaTipoHoraDto> save(
            @Valid @NotNull final TiposHoraResponseDto dto,
            @Valid @NotNull final TareaDto tarea) {
        return this.mapper.tareaTareaTipoHoraListTotareaTipoHoraDtoList(this.tareaTipoHoraRepositoryCustom.save(
                this.mapper.tiposHorasResponseDtoToTareaTipoHora(dto, tarea)));
    }

}
