package com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto.PageableList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PageableListDTO<T> implements PageableList<T>, Serializable {
	
	private static final long serialVersionUID = -1674424926992562719L;
	
	List<T> data;

	PageDTO page;

}