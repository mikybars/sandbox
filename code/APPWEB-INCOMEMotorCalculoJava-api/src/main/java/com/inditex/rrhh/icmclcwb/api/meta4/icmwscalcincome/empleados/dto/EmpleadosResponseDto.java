package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

public class EmpleadosResponseDto extends PageableListDto<GenericEmpleadoResultItemDto>
    implements PageableList<GenericEmpleadoResultItemDto>, Serializable {

  private static final long serialVersionUID = 7095948368921075557L;

}
