package com.inditex.rrhh.icmclcwb.model.app.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionEmpleadoDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.ProgramacionEmpleadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionEmpleado;

public abstract class ProgramacionEmpleadoDecorator extends ProgramacionEmpleadoMapper {

	@Autowired
	private ProgramacionEmpleadoMapper delegate;

	@Override
	public List<ProgramacionEmpleado> mergeProgramacionEmpleadoDtoAndProgramacionDtoToProgramacionEmpleado(
			List<ProgramacionEmpleadoDto> srcProgramacionEmpleadoDto, ProgramacionDto srcProgramacionDto) {
		List<ProgramacionEmpleado> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(srcProgramacionEmpleadoDto)) {
			srcProgramacionEmpleadoDto.forEach(item -> {
				result.add(delegate.mergeProgramacionEmpleadoDtoAndProgramacionDtoToProgramacionEmpleado(item,
						srcProgramacionDto));
			});
		}
		return result;
	}

}