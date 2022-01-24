package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class VentaManualWlocResponseDto extends PageableListDto<VentaManualWlocResultItemDto>
    implements PageableList<VentaManualWlocResultItemDto>, Serializable {

  private static final long serialVersionUID = -1L;

}
