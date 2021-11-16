package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EstructurasPolResponseDto extends PageableListDto<EstructurasPolResultItemDto>
    implements PageableList<EstructurasPolResultItemDto>, Serializable {

  private static final long serialVersionUID = -787638725250650715L;

}
