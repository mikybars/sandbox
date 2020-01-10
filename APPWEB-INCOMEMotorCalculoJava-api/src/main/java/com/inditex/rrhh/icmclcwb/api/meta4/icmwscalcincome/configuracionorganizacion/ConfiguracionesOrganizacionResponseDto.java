package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion;


import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class ConfiguracionesOrganizacionResponseDto extends PageableListDto<ConfiguracionesOrganizacionItemDto>
        implements PageableList<ConfiguracionesOrganizacionItemDto>, Serializable {

    private static final long serialVersionUID = 1900274331041555593L;

}
