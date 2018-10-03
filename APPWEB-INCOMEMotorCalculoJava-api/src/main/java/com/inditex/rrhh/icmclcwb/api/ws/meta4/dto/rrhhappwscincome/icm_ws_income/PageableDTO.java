package com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.ws.meta4.rrhhappwscincome.icm_ws_income.Pageable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PageableDTO<T> implements Pageable<T>, Serializable {

	private static final long serialVersionUID = -1674424926992562719L;

	T data;

	PageDTO page;

}