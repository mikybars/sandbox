package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.PageDTO;

public interface PageableList<T> {
	
	List<T> getData();
	
	PageDTO getPage();

}