package com.inditex.rrhh.icmclcwb.model.app.mapper.decorator;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.ProgramacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.ProgramacionTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Programacion;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionTienda;

public abstract class ProgramacionMapperDecorator implements ProgramacionMapper {

	@Autowired
    @Qualifier("delegate")
    private ProgramacionMapper delegate;
	
	@Autowired
	private ProgramacionTiendaMapper programacionTiendaMapper;

	@Override
	public ProgramacionDto programacionToProgracionDto(Programacion src) {
		ProgramacionDto result = delegate.programacionToProgracionDto(src);
		List<ProgramacionTienda> tiendas = src.getTiendas();
		if (CollectionUtils.isNotEmpty(tiendas)) {
			tiendas.stream().forEach(item -> {
				item.setProgramacion(delegate.programacionToProgracionId(item.getProgramacion()));
			});
			result.setTiendas(programacionTiendaMapper.programacionTiendaToprogramacionTiendaDto(tiendas));
		}
		return result;
	}

	@Override
	public ProgramacionDto programacionDtoToProgracionDtoId(ProgramacionDto src) {
		ProgramacionDto result = new ProgramacionDto();
		result.setId(src.getId());
		return result;
	}
	
	@Override
	public Programacion programacionToProgracionId(Programacion src) {
		Programacion result = new Programacion();
		result.setId(src.getId());
		return result;
	}

}