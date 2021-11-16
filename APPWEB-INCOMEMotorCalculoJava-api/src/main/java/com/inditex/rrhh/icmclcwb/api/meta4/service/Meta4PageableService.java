package com.inditex.rrhh.icmclcwb.api.meta4.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;

public interface Meta4PageableService {

  <T extends PageableDto<?>, Z extends Object, U extends PageableListDto<?>> List<Z> getResultItem(final T request,
      String methodName, final Class<U> class1, final Class<Z> classZ);

}
