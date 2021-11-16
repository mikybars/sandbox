package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Pageable;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;

public class SearchTiendasRequestDto extends PageableDto<SearchTiendasFilterDto>
    implements Pageable<SearchTiendasFilterDto>, Serializable {

  private static final long serialVersionUID = -6594522575407115739L;

}
