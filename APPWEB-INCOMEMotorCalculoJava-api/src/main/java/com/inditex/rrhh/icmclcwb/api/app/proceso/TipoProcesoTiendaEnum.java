package com.inditex.rrhh.icmclcwb.api.app.proceso;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.TipoProcesoTiendaDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoProcesoTiendaEnum {

    INICIAL(1L, new TipoProcesoTiendaDto(1L)), PARAMETRO(2L, new TipoProcesoTiendaDto(2L)),
    HISTORICO(3L, new TipoProcesoTiendaDto(3L)), PRESENCIA(4L, new TipoProcesoTiendaDto(4L));

    private final Long id;

    private final TipoProcesoTiendaDto dto;

    public static final List<TipoProcesoTiendaDto> TIPO_PRESENCIA = Arrays.asList(PRESENCIA.getDto());

    public static final List<TipoProcesoTiendaDto> TIPO_INICIAL_PARAM_HISTORICO = Arrays.asList(INICIAL.getDto(),
            PARAMETRO.getDto(), HISTORICO.getDto());

}
