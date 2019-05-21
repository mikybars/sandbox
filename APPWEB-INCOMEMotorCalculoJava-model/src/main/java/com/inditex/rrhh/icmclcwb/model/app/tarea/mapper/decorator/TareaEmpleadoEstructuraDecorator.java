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
                TareaEmpleadoEstructuraDto estructura = delegate.comisionEmpleadoResultItemDtoToTareaEmpleadoEstructuraDto(item);
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
