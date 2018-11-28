package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto.PageableList;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SearchTiendasResponseDto extends PageableListDto<SearchTiendasResultItemDto>
		implements PageableList<SearchTiendasResultItemDto>, Serializable {
	
	private static final long serialVersionUID = 3575037594971990002L;

}
