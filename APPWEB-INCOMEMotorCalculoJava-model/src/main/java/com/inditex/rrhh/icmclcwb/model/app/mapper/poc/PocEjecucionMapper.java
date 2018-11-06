package com.inditex.rrhh.icmclcwb.model.app.mapper.poc;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocEjecucionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.poc.PocConstants;
import com.inditex.rrhh.icmclcwb.model.primary.entity.poc.PocEjecucion;

@Mapper
public abstract class PocEjecucionMapper {

	@Mappings({ @Mapping(target = "tiendas", ignore = true) })
	public abstract PocEjecucionDto pocEjecucionToPocEjecucionDto(PocEjecucion src);

	@Mappings({ @Mapping(target = "tiendas", ignore = true) })
	public abstract PocEjecucion pocEjecucionDtoToPocEjecucion(PocEjecucionDto src);

	public abstract List<PocEjecucionDto> pocEjecucionToPocEjecucionDto(List<PocEjecucion> src);
	
	@AfterMapping
    protected void pocEjecucionToPocEjecucionDto(PocEjecucion src, @MappingTarget PocEjecucionDto target) {
		if (StringUtils.isNotBlank(src.getTiendas())) {
			target.setTiendas(Arrays.asList(StringUtils.split(src.getTiendas(), PocConstants.SEPARADOR_TIENDA)));
		}
	}
	
	@AfterMapping
    protected void pocEjecucionDtoToPocEjecucion(PocEjecucionDto src, @MappingTarget PocEjecucion target) {
		if (CollectionUtils.isNotEmpty(src.getTiendas())) {
			target.setTiendas(StringUtils.join(src.getTiendas(), PocConstants.SEPARADOR_TIENDA));
		}
	}

}