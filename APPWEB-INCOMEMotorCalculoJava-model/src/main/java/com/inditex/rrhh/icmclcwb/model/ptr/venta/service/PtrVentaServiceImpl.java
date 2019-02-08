package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaService;

@Service
@Validated
public abstract class PtrVentaServiceImpl implements PtrVentaService {

    @Autowired
    @Qualifier("ptrVentaClient")
    protected RestClient ptrVentaClient;
    
    @Autowired
    @Qualifier("ptrProps")
    protected Map<String, PtrPropertiesDto> ptrProps;

}