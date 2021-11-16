package com.inditex.rrhh.icmclcwb.model.meta4.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.exception.Meta4IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.service.Meta4PageableService;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Meta4PageableServiceImpl implements Meta4PageableService {

  @Autowired
  @Qualifier("meta4Properties")
  protected Map<String, Meta4PropertiesDto> meta4Properties;

  @Autowired
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Override
  public <T extends PageableDto<?>, Z extends Object, U extends PageableListDto<?>> List<Z> getResultItem(
      final T request,
      final String methodName, final Class<U> classU, final Class<Z> classZ) {
    final List<Z> result = new ArrayList<>();
    try {
      boolean hasNext;
      do {
        hasNext = false;
        Method method;
        method = this.meta4IcmWsCalcIncomeService.getClass().getMethod(methodName, request.getClass());
        final U response = classU.cast(method.invoke(this.meta4IcmWsCalcIncomeService, request));
        if (response != null) {
          if (CollectionUtils.isNotEmpty(response.getData())) {
            result.addAll(response.getData().stream().map(classZ::cast).collect(Collectors.toList()));
          }
          if ((response.getPage() != null)
              && response.getPage().hasNext()
              && (result.size() < this.meta4Properties.get(methodName).getFilter().getMaxPageSize())) {
            hasNext = true;
            request.setPage(response.getPage().next());
          } else {
            request.setPage(response.getPage());
          }
        }
      } while (hasNext);
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
        | SecurityException e) {
      throw new Meta4IcmclcwbException(e.getMessage(), e);
    }
    return result;
  }

}
