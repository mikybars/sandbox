package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CoefJornadaResponseDto extends PageableListDto<GenericEmpleadoResultItemDto>
    implements PageableList<GenericEmpleadoResultItemDto>, Serializable {

  private static final long serialVersionUID = 8334457412213157838L;

}
