package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PeriodosResponseDto extends PageableListDto<PeriodosResultItemDto>
    implements PageableList<PeriodosResultItemDto>, Serializable {

  private static final long serialVersionUID = 7339513104665027990L;

}
