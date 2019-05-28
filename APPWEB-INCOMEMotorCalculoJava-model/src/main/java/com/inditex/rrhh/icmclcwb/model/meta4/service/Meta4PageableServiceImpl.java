package com.inditex.rrhh.icmclcwb.model.meta4.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.exception.Meta4Exception;
import com.inditex.rrhh.icmclcwb.api.meta4.service.Meta4PageableService;

@Service
public class Meta4PageableServiceImpl<U extends PageableListDto> implements Meta4PageableService {

    @Override
    public <T extends PageableDto<?>, Z extends Object> List<Z> getResultItem(final T request, Object service,
            String methodName, Integer maxPageSize) {
        List<Z> result = new ArrayList<>();
        try {
            boolean hasNext;
            do {
                hasNext = false;
                Method method;
                method = service.getClass().getMethod(methodName, request.getClass());
                U response = (U) method.invoke(service, request);
                if (response != null) {
                    if (CollectionUtils.isNotEmpty(response.getData())) {
                        result.addAll(response.getData());
                    }
                    if (response.getPage() != null && response.getPage().hasNext() && (result.size() < maxPageSize)) {
                        hasNext = true;
                        request.setPage(response.getPage().next());
                    } else {
                        request.setPage(response.getPage());
                    }
                }
            } while (hasNext);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
                | SecurityException e) {
            throw new Meta4Exception(e.getMessage(), e);
        }
        return result;
    }

}
