package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTipoHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTipoHoraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTipoHora;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(TareaTipoHoraDecorator.class)
public abstract class TareaTipoHoraMapper {

    @Mapping(source = "idTarea", target = "tarea.id")
    public abstract TareaTipoHora tareaTipoHoraDtoToTareaTipoHora(TareaTipoHoraDto src);

    public abstract List<TareaTipoHora> tareaTipoHoraDtoListToTareaTareaTipoHoraList(
            List<TareaTipoHoraDto> src);

    public abstract List<TareaTipoHoraDto> tareaTipoHoraListTotareaTipoHoraDtoList(
            List<TareaTipoHora> src);

    @Mapping(source = "tarea.id", target = "idTarea")
    public abstract TareaTipoHoraDto tareaTipoHoraToTareaTipoHoraDto(TareaTipoHora src);

    @Mapping(source = "src.tipoHora", target = "idTipoHora")
    @Mapping(source = "src.excluidoCalculo", target = "excluidoCalculo")
    @Mapping(source = "src.excluidoDenom", target = "excluidoDenominador")
    @Mapping(source = "src.incluidoVenta", target = "incluidoVenta")
    @Mapping(source = "src.incluidoChallenge", target = "incluidoChallenge")
    @Mapping(source = "src.incluidoEcommerce", target = "incluidoEcommerce")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    // TODO [javierev] Cambiar esta expresión por el campo real (o eliminar este mapper)
    @Mapping(target = "excluidoDenominadorYRepartidoProvincia", expression = "java(src.getTipoHora() == 401)")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTipoHora ptrPresenciasMockTiposHorasResponseDtoToTareaTipoHoraDto(
            PtrPresenciaTiposHorasResultItemDto src, TareaDto tareaDto);

    public List<TareaTipoHora> ptrPresenciaTipoHoraResponsesDtoToTareaTipoHoraDto(
            final List<PtrPresenciaTiposHorasResultItemDto> src, final TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(source = "src.idTipoHora", target = "idTipoHora")
    @Mapping(source = "src.excluidoCalculo", target = "excluidoCalculo")
    @Mapping(source = "src.excluidoDenominador", target = "excluidoDenominador")
    @Mapping(source = "src.incluidoVenta", target = "incluidoVenta")
    @Mapping(source = "src.incluidoChallenge", target = "incluidoChallenge")
    @Mapping(source = "src.incluidoCommerce", target = "incluidoEcommerce")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(source = "src.excluidoDenominadorRepartoProvincia", target = "excluidoDenominadorYRepartidoProvincia")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTipoHora tipoHoraResultItemDtoToTareaTipoHora(final TiposHoraResultItemDto src,
            final TareaDto tarea);

    public List<TareaTipoHora> tiposHorasResponseDtoToTareaTipoHora(final TiposHoraResponseDto src,
            final TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}
