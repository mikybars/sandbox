package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;

public class PtrPresenciaMockMapperComisionable {

    private PtrPresenciaMockMapperComisionable() {
    }

    public static PtrPresenciaDetalleRequestDto asPresenciaComisionableToDetalle(
            PtrPresenciaDetalleComisionableRequestDto src) {
        return new PtrPresenciaDetalleRequestDto(src.getTienda(), src.getSeccion(), src.getPersona(),
                src.getFechaDesde(), src.getFechaHasta(), src.getTipo(), src.getCadena(), src.getOrigen());
    }
}
