package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AusenciasResponseDto extends PageableListDto<AusenciasResultItemDto>
    implements PageableList<AusenciasResultItemDto>, Serializable {

  private static final long serialVersionUID = 7489897189492697258L;

}
