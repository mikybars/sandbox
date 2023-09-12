package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Pageable;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;

public class ConfiguracionProductoVentaRequestDto extends PageableDto<GenericFilterDto>
    implements Pageable<GenericFilterDto>, Serializable {

  private static final long serialVersionUID = -2594365007603536547L;

}
