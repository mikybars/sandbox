package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmpleadosDesplazamientoResponseDto extends PageableListDto<GenericEmpleadoResultItemDto>
    implements PageableList<GenericEmpleadoResultItemDto>, Serializable {

  private static final long serialVersionUID = 1985680124903618472L;

}
