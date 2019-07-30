package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Pageable;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;

import java.io.Serializable;

public class TiendaOnlineRequestDto extends PageableDto<GenericFilterDto>
    implements Pageable<GenericFilterDto>, Serializable {

    private static final long serialVersionUID = -8007728726750677351L;

}
