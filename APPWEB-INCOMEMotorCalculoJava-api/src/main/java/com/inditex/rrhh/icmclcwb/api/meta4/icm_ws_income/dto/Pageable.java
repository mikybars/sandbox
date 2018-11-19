package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;

public interface Pageable<T extends Serializable> {
	
	T getData();
	
	PageDto getPage();

}