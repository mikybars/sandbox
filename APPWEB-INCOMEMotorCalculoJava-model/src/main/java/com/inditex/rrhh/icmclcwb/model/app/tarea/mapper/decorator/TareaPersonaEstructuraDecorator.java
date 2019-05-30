package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;

public abstract class TareaPersonaEstructuraDecorator extends TareaPersonaEstructuraMapper {

	@Autowired
	private TareaPersonaEstructuraMapper delegate;

	@Override
	public List<TareaPersonaEstructura> mergeTareaPersonaEstructuraDtoAndTareaDtoToTareaPersonaEstructura(
			List<TareaPersonaEstructuraDto> srcTareaEmpleadoEstructura, TareaDto srcTarea) {
		List<TareaPersonaEstructura> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcTareaEmpleadoEstructura)) {
		    srcTareaEmpleadoEstructura.forEach(item -> 
				result.add(
						delegate.mergeTareaPersonaEstructuraDtoAndTareaDtoToTareaPersonaEstructura(item, srcTarea))
			);
		}
		return result;
	}
	
	@Override
    public List<TareaPersonaEstructuraDto> comisionEmpleadoResultItemDtoToTareaPersonaEstructuraDto(
            List<ComisionEmpleadoResultItemDto> src){
        List<TareaPersonaEstructuraDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> {
                TareaPersonaEstructuraDto estructura = delegate.comisionEmpleadoResultItemDtoToTareaPersonaEstructuraDto(item);
                if (CollectionUtils.isNotEmpty(item.getIcmListaPorcentajes())) {
                    item.getIcmListaPorcentajes().forEach(porcentaje -> {
                        if(StringUtils.isNotEmpty(porcentaje.getPorcentaje())){
                            estructura.setPorcentaje(Double.valueOf(porcentaje.getPorcentaje()));
                        }
                        if(StringUtils.isNotEmpty(porcentaje.getPorcentajeT1())){
                            estructura.setPorcentaje1(Double.valueOf(porcentaje.getPorcentajeT1()));
                        }
                        if(StringUtils.isNotEmpty(porcentaje.getPorcentajeT2())){
                            estructura.setPorcentaje2(Double.valueOf(porcentaje.getPorcentajeT2()));
                        }
                        if(StringUtils.isNotEmpty(porcentaje.getPorcentajeT3())){
                            estructura.setPorcentaje3(Double.valueOf(porcentaje.getPorcentajeT3()));
                        }
                    });
                }
                result.add(estructura);
            });
        }
        return result;
    }

}
