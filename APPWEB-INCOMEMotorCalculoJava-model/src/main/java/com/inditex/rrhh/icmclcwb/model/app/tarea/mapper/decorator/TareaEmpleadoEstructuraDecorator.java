package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
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
    public List<TareaEmpleadoEstructuraDto> genericEmpleadoResultItemDtoToTareaEmpleadoEstructuraDto(
            List<GenericEmpleadoResultItemDto> src, TareaDto tarea) {
        List<TareaEmpleadoEstructuraDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> 
                result.add(
                        delegate.genericEmpleadoResultItemDtoToTareaEmpleadoEstructuraDto(item, tarea))
            );
        }
        return result;
    }

}
