package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoEmpleadoEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoEmpleadoEstructura;

public abstract class ProcesoEmpleadoEstructuraDecorator extends ProcesoEmpleadoEstructuraMapper {

	@Autowired
	private ProcesoEmpleadoEstructuraMapper delegate;

	@Override
	public List<ProcesoEmpleadoEstructura> mergeProcesoEmpleadoEstructuraDtoAndProcesoDtoToProcesoEmpleadoEstructura(
			List<ProcesoEmpleadoEstructuraDto> srcProcesoEmpleadoEstructura, ProcesoDto srcProceso) {
		List<ProcesoEmpleadoEstructura> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcProcesoEmpleadoEstructura)) {
		    srcProcesoEmpleadoEstructura.forEach(item -> 
				result.add(
						delegate.mergeProcesoEmpleadoEstructuraDtoAndProcesoDtoToProcesoEmpleadoEstructura(item, srcProceso))
			);
		}
		return result;
	}


    @Override
    public List<ProcesoEmpleadoEstructuraDto> genericEmpleadoResultItemDtoToProcesoEmpleadoEstructuraDto(
            List<GenericEmpleadoResultItemDto> src, ProcesoDto proceso) {
        List<ProcesoEmpleadoEstructuraDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> 
                result.add(
                        delegate.genericEmpleadoResultItemDtoToProcesoEmpleadoEstructuraDto(item, proceso))
            );
        }
        return result;
    }

}
