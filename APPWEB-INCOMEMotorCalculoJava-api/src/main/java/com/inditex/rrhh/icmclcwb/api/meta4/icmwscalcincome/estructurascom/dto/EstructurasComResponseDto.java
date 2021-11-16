package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EstructurasComResponseDto extends PageableListDto<EstructurasComResultItemDto>
    implements PageableList<EstructurasComResultItemDto>, Serializable {

  private static final long serialVersionUID = 6689962297446357623L;

}
