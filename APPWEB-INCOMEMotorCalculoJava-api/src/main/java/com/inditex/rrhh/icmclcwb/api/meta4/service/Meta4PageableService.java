package com.inditex.rrhh.icmclcwb.api.meta4.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;

public interface Meta4PageableService {

    <T extends PageableDto<?>, U extends PageableListDto, Z extends Object> List<Z> getResultItem(final T request, 
            Object service, String methodName, Integer maxPageSize) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;

}