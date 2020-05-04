package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.AlgoritmoAjuste;

@Mapper
public abstract class AlgoritmoAjusteMapper {

    public abstract AlgoritmoAjusteDto algoritmoAjusteToAlgoritmoAjusteDto(AlgoritmoAjuste src);

    @InheritInverseConfiguration
    public abstract AlgoritmoAjuste algoritmoAjusteDtoToAlgoritmo(AlgoritmoAjusteDto src);

    public abstract List<AlgoritmoAjusteDto> algoritmoAjusteToAlgoritmoAjusteDto(List<AlgoritmoAjuste> src);

    @InheritInverseConfiguration
    public abstract List<AlgoritmoAjuste> algoritmoAjusteDtoToAlgoritmo(List<AlgoritmoAjusteDto> src);

}
