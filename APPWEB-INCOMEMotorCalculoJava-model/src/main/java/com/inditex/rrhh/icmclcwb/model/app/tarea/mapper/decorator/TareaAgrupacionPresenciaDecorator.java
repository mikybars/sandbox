package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionPresencia;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class TareaAgrupacionPresenciaDecorator extends TareaAgrupacionPresenciaMapper {

    @Autowired
    private TareaAgrupacionPresenciaMapper delegate;

    @Override
    public List<TareaAgrupacionPresencia> presenciasTotalizadoResponseDtoToTareaAgrupacionPresencia(
        List<PtrPresenciaTotalizadoResultItemDto> src, TareaDto tareaDto, List<TareaAgrupacionCadenasDto> agrupaciones) {
        List<TareaAgrupacionPresencia> result = new ArrayList<>();
        if (src != null) {
            Map<TareaAgrupacion, TareaAgrupacionPresencia> presencias = new HashMap<>();
            Map<Integer, Long> idAgrupaciones = new HashMap<>();
            src.forEach(item -> {
                if (!idAgrupaciones.containsKey(item.getCadena())) {
                    Optional<TareaAgrupacionCadenasDto> optionalAgrupacion = agrupaciones.stream().filter(x -> x.getCadenas().stream().anyMatch(
                        y -> y.equals(item.getCadena().toString()))).findFirst();
                    if (!optionalAgrupacion.isPresent()) {
                        throw new RuntimeException("No hay agrupacion para la cadena " + item.getCadena());
                    }
                    idAgrupaciones.put(item.getCadena(), optionalAgrupacion.get().getId());
                }
                Long idAgrupacion = idAgrupaciones.get(item.getCadena());
                TareaAgrupacion agrupacion = TareaAgrupacion
                    .builder()
                    .fecha(item.getFecha())
                    .idAgrupacion(idAgrupacion)
                    .idSeccion(item.getSeccion())
                    .idTarea(tareaDto.getId())
                    .build();
                if (!presencias.containsKey(agrupacion)) {
                    TareaAgrupacionPresencia tareaAgrupacionPresencia =
                        delegate.presenciasTotalizadoResponseDtoToTareaAgrupacionPresencia(item, tareaDto);
                    tareaAgrupacionPresencia.setIdAgrupacion(idAgrupacion);
                    tareaAgrupacionPresencia.setMinutos(0L);
                    presencias.put(agrupacion, tareaAgrupacionPresencia);
                }
                TareaAgrupacionPresencia tareaAgrupacionPresencia = presencias.get(agrupacion);
                tareaAgrupacionPresencia.setMinutos(tareaAgrupacionPresencia.getMinutos() + item.getMinutos());
            });
            result.addAll(presencias.values());
        }
        return result;
    }
}
