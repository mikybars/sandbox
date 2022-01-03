package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Pageable;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;

public class SearchEmpleadosRequestDto extends PageableDto<SearchEmpleadosFilterDto>
    implements Pageable<SearchEmpleadosFilterDto>, Serializable {

  private static final long serialVersionUID = -7913276865987490327L;

}
