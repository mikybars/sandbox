package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EstadoWlocResponseDto extends PageableListDto<EstadoWlocResultItemDto>
    implements PageableList<EstadoWlocResultItemDto>, Serializable {

}
