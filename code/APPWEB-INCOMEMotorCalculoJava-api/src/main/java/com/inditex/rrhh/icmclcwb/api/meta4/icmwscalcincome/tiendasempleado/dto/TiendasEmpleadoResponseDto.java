package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasempleado.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TiendasEmpleadoResponseDto extends PageableListDto<GenericTiendaResultItemDto>
    implements PageableList<GenericTiendaResultItemDto>, Serializable {

  private static final long serialVersionUID = 7195358579420460119L;

}
