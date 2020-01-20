package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionOperacionPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionOperacionPersona;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class TareaLocalizacionOperacionPersonaDecorator extends TareaLocalizacionOperacionPersonaMapper {

    @Autowired
    private Logger log;

    @Autowired
    private TareaLocalizacionOperacionPersonaMapper delegate;

    @Override
    public TareaLocalizacionOperacionPersona ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionOperacionPersona(PtrVentaIndividualDetalleResultItemDto src, TareaDto tarea) {
        TareaLocalizacionOperacionPersona result =
            delegate.ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionOperacionPersona(src, tarea);
        result.setTipoDato(new TipoDato());
        if (PtrConstants.OPERACION_VENTA.equals(src.getOperacion())) {
            result.getTipoDato().setId(TipoDatoEnum.OPERACION_VENTA_FISICA_LOCALIZACION_SECCION.getId());
        } else if (PtrConstants.OPERACION_DEVOLUCION.equals(src.getOperacion())) {
            result.getTipoDato().setId(TipoDatoEnum.OPERACION_DEVOLUCION_FISICA_LOCALIZACION_SECCION.getId());
        } else {
            log.warn(ErrorConstants.OPERATION_NOT_VALID, src.getOperacion());
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionOperacionPersona> ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionOperacionPersona(List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tarea) {
        return super.ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionOperacionPersona(src, tarea);
    }
}
