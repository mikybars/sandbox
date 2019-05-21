package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaEmpleadoEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoEstructura;

public abstract class TareaEmpleadoEstructuraDecorator extends TareaEmpleadoEstructuraMapper {

	@Autowired
	private TareaEmpleadoEstructuraMapper delegate;

	@Override
	public List<TareaEmpleadoEstructura> mergeTareaEmpleadoEstructuraDtoAndTareaDtoToTareaEmpleadoEstructura(
			List<TareaEmpleadoEstructuraDto> srcTareaEmpleadoEstructura, TareaDto srcTarea) {
		List<TareaEmpleadoEstructura> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcTareaEmpleadoEstructura)) {
		    srcTareaEmpleadoEstructura.forEach(item -> 
				result.add(
						delegate.mergeTareaEmpleadoEstructuraDtoAndTareaDtoToTareaEmpleadoEstructura(item, srcTarea))
			);
		}
		return result;
	}
	
	@Override
    public List<TareaEmpleadoEstructuraDto> comisionEmpleadoResultItemDtoToTareaEmpleadoEstructuraDto(
            List<ComisionEmpleadoResultItemDto> src){
        List<TareaEmpleadoEstructuraDto> result = new ArrayList<>();
        
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> {
                if (CollectionUtils.isNotEmpty(item.getIcmListaPorcentajes())) {
                    item.getIcmListaPorcentajes().forEach(porcentaje -> {
                        TareaEmpleadoEstructuraDto estructura = delegate.comisionEmpleadoResultItemDtoToTareaEmpleadoEstructuraDto(item);
                        estructura.setPorcentaje(StringUtils.isNotEmpty(porcentaje.getPorcentaje()) ? Double.valueOf(porcentaje.getPorcentaje()) : null);
                        estructura.setPorcentaje3(StringUtils.isNotEmpty(porcentaje.getPorcentajeT1()) ? Double.valueOf(porcentaje.getPorcentajeT1()) : null);
                        estructura.setPorcentaje3(StringUtils.isNotEmpty(porcentaje.getPorcentajeT2()) ? Double.valueOf(porcentaje.getPorcentajeT2()) : null);
                        estructura.setPorcentaje3(StringUtils.isNotEmpty(porcentaje.getPorcentajeT3()) ? Double.valueOf(porcentaje.getPorcentajeT3()) : null);
                        result.add(estructura);
                    });
                }
            });
        }
        return result;
    }

}
