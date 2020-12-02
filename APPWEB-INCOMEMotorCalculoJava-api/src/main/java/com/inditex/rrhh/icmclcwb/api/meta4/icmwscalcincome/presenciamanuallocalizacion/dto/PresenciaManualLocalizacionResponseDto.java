package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanuallocalizacion.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PresenciaManualLocalizacionResponseDto extends PageableListDto<PresenciaManualLocalizacionResultItemDto>
        implements PageableList<PresenciaManualLocalizacionResultItemDto>, Serializable {

    private static final long serialVersionUID = -1L;

}
