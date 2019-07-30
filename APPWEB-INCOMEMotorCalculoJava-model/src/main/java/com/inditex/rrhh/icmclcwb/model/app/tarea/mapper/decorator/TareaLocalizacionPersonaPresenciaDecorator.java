package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.PtrSeccionPresenciasGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;

public abstract class TareaLocalizacionPersonaPresenciaDecorator
        extends TareaLocalizacionPersonaPresenciaMapper {

    @Autowired
    private TareaLocalizacionPersonaPresenciaMapper delegate;

    @Override
    public List<TareaLocalizacionPersonaPresencia> genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(
            List<GenericEmpleadoResultItemDto> src, TareaDto tareaDto) {
        List<TareaLocalizacionPersonaPresencia> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> {
                if(AppConstants.SECCIONES_STRING.contains(item.getIdSeccion())) {
                    result.add(
                            delegate.genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(item, tareaDto));
                    }                
                }
            );
        }
        return result;
    }
      
    @Override
    public List<TareaLocalizacionPersonaPresencia> presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(
            List<PtrPresenciaDetalleResultItemDto> src, TareaDto tareaDto) {
        List<TareaLocalizacionPersonaPresencia> result = new ArrayList<>();
        src.forEach(x ->
        result.addAll(presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(x.getListaSeccion(), x, tareaDto)));
        return result;
    }
    
    
    private List<TareaLocalizacionPersonaPresencia> presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(
        List<PtrSeccionPresenciasGenericType> listaSeccion, PtrPresenciaDetalleResultItemDto presenciaTotalizado, TareaDto tareaDto) {
        List<TareaLocalizacionPersonaPresencia> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(listaSeccion)) {
            listaSeccion.forEach(x -> {
                TareaLocalizacionPersonaPresencia presencia = delegate.presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(presenciaTotalizado, tareaDto);
                presencia.setCclIdSeccion(x.getSeccion().toString());
                presencia.setMinutos(x.getMinutos());
                presencia.setTipoDato(new TipoDato());
                presencia.getTipoDato().setId(TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
                result.add(presencia);
            });

        }
        return result;
    }
}
