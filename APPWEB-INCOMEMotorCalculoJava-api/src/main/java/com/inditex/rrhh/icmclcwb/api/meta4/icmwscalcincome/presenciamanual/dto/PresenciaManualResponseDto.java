package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PresenciaManualResponseDto extends PageableListDto<PresenciaManualResultItemDto>
        implements PageableList<PresenciaManualResultItemDto>, Serializable {
    
    private static final long serialVersionUID = -2818013550614689223L;

}
