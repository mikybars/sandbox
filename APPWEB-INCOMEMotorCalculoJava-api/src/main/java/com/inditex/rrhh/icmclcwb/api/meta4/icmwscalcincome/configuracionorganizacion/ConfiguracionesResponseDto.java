package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion;


import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class ConfiguracionesResponseDto extends PageableListDto<ConfiguracionItemDto>
        implements PageableList<ConfiguracionItemDto>, Serializable {

    private static final long serialVersionUID = 1900274331041555593L;

}
