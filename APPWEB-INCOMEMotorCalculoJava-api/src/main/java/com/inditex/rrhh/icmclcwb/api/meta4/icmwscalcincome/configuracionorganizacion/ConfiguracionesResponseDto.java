package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ConfiguracionesResponseDto implements Serializable {

    private static final long serialVersionUID = 1900274331041555593L;

    private List<ConfiguracionItemDto> items;

}
