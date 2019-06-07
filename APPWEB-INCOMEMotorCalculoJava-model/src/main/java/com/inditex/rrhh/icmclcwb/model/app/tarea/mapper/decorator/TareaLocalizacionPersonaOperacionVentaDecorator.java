package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.util.concurrent.AtomicDouble;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaOperacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaOperacionVenta;

public abstract class TareaLocalizacionPersonaOperacionVentaDecorator
        extends TareaLocalizacionPersonaOperacionVentaMapper {
    
    @Autowired
    private TareaLocalizacionPersonaOperacionVentaMapper delegate;
    
    @Override
    public List<TareaLocalizacionPersonaOperacionVenta> getVentaIndividualDetalleResponseItemsDtoToTareaLocalizacionPersonaOperacionVentas(
            List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tareaDto) {
        List<TareaLocalizacionPersonaOperacionVenta> dtoList = new ArrayList<>();
        src.forEach(x -> dtoList.addAll(getVentaIndividualDetalleResponseItemsDtoToTareaOperacionLocalizacionVentas(x.getListaSeccion(), x, tareaDto)));
        return dtoList;
    }
    
    
    public List<TareaLocalizacionPersonaOperacionVenta> getVentaIndividualDetalleResponseItemsDtoToTareaOperacionLocalizacionVentas(
        List<PtrSeccionVentaOnlineGenericType> listaSeccion, PtrVentaIndividualDetalleResultItemDto presenciaTotalizado, TareaDto tareaDto) {
        List<TareaLocalizacionPersonaOperacionVenta> result = new ArrayList<>();
        AtomicDouble importeSinIva = new AtomicDouble(0);
        AtomicDouble importeConIva = new AtomicDouble(0);
        if (CollectionUtils.isNotEmpty(listaSeccion)) {
            listaSeccion.forEach(x -> {
                TareaLocalizacionPersonaOperacionVenta presencia = delegate.getVentaIndividualDetalleResponseItemsDtoToTareaLocalizacionPersonaOperacionVentas(presenciaTotalizado, tareaDto);
                presencia.setIdSeccion(x.getSeccion().toString());
                presencia.setImporte(x.getImporteSinIVA().doubleValue());
                presencia.setImporteConImpuestos(x.getImporteConIVA().doubleValue());
                presencia.setTipoDato(new TipoDato());
                presencia.getTipoDato().setId(TipoDatoEnum.IMPORTE_VENTA_FISICA_INDIVIDUAL_OPERACION_PERSONA_LOCALIZACION_SECCION.getId());
                result.add(presencia);
                importeSinIva.getAndAdd(x.getImporteSinIVA().doubleValue());
                importeConIva.getAndAdd(x.getImporteConIVA().doubleValue());

            });
            TareaLocalizacionPersonaOperacionVenta presencia = delegate.getVentaIndividualDetalleResponseItemsDtoToTareaLocalizacionPersonaOperacionVentas(presenciaTotalizado, tareaDto);
            presencia.setIdSeccion(AppConstants.SECCION_4.toString());
            presencia.setImporte(importeSinIva.get());
            presencia.setImporteConImpuestos(importeConIva.get());
            presencia.setTipoDato(new TipoDato());
            presencia.getTipoDato().setId(TipoDatoEnum.IMPORTE_VENTA_FISICA_INDIVIDUAL_OPERACION_PERSONA_LOCALIZACION.getId());
            result.add(presencia);

        }
        return result;
    }

}
