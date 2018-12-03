package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;

public class PtrPresenciaMockMapperComisionable {

    public static PtrPresenciaDetalleRequestDto asPresenciaComisionableToDetalle(
            PtrPresenciaDetalleComisionableRequestDto src) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < src.getCadena().size(); i++) {
            list.add(src.getCadena().get(i));
        }
        return new PtrPresenciaDetalleRequestDto(src.getTienda(), src.getSeccion(), src.getPersonas(),
                src.getFechaDesde(), src.getFechaHasta(), src.getTipo(), list, src.getOrigen());
    }
}
