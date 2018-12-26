package com.inditex.rrhh.icmclcwb.api.meta4.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;

public interface Meta4PageableService {

    <T extends PageableDto<?>, Z extends Object> List<Z> getResultItem(final T request, 
            Object service, String methodName, Integer maxPageSize) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;

}