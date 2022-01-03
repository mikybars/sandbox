package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ConfChDiasMinimosResponseDto extends PageableListDto<ConfChDiasMinimosResultItemDto>
    implements PageableList<ConfChDiasMinimosResultItemDto>, Serializable {

  private static final long serialVersionUID = 8035701197756654783L;

}
