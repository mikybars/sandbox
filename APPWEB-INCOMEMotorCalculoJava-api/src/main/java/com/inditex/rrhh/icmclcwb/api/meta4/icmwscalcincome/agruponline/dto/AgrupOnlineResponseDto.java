package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AgrupOnlineResponseDto extends PageableListDto<AgrupOnlineResultItemDto>
    implements PageableList<AgrupOnlineResultItemDto>, Serializable {

  private static final long serialVersionUID = -4067213686631519481L;

}
