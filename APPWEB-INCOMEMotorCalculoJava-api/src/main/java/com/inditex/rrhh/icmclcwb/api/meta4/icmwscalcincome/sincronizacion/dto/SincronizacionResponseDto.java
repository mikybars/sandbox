package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SincronizacionResponseDto extends PageableListDto<SincronizacionResultItemDto>
    implements PageableList<SincronizacionResultItemDto>, Serializable {

  private static final long serialVersionUID = 1L;

}
