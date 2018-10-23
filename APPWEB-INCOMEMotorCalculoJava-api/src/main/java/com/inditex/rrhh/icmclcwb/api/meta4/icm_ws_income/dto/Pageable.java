package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto;

import com.inditex.rrhh.icmclcwb.api.meta4.PageDTO;

public interface Pageable<T> {
	
	T getData();
	
	PageDTO getPage();

}