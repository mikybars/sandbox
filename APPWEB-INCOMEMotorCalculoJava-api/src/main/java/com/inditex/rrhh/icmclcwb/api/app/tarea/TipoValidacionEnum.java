package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TipoValidacionDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter

@RequiredArgsConstructor
public enum TipoValidacionEnum {

    PRESENCIAS(1, new TipoValidacionDto(1));

    private final Integer id;

    private final TipoValidacionDto dto;

}
