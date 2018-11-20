package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.dto;

import java.io.Serializable;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;

public interface PageableList<T extends Serializable> {

    public List<T> getData();

    public PageDto getPage();

}