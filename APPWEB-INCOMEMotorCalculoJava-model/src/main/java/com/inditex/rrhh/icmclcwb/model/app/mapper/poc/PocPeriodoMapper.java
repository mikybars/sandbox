package com.inditex.rrhh.icmclcwb.model.app.mapper.poc;

import java.util.List;

import org.mapstruct.Mapper;
import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocPeriodoDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.poc.PocPeriodo;

@Mapper
public abstract class PocPeriodoMapper {

	public abstract PocPeriodoDto pocPeriodoToPocPeriodoDto(PocPeriodo src);

	public abstract List<PocPeriodoDto> pocPeriodoToPocPeriodoDto(List<PocPeriodo> src);

}