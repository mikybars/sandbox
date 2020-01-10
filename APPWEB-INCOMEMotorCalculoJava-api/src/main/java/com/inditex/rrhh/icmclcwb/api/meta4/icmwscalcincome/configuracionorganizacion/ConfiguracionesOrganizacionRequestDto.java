package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Pageable;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;

import java.io.Serializable;

public class ConfiguracionesOrganizacionRequestDto extends PageableDto<GenericFilterDto>
        implements Pageable<GenericFilterDto>, Serializable {

    private static final long serialVersionUID = 6004857776815885351L;

}
