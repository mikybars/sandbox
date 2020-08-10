package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Pageable;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;

import java.io.Serializable;

public class DesplazamientosMultiempresaRequestDto extends PageableDto<GenericFilterDto>
    implements Serializable, Pageable<GenericFilterDto> {

    private static final long serialVersionUID = 7354508691091884987L;

}
