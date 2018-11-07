package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;


public interface PageableList<T> {
	
	List<T> getData();
	
	PageDto getPage();

}