package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.service.TipoComisionService;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.TipoComisionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.TipoComisionRepository;

@Service
@Validated
public class TipoComisionServiceImpl implements TipoComisionService {

    @Autowired
    private TipoComisionRepository tipoComisionRepository;
    
    @Autowired
    private TipoComisionMapper tipoComisionMapper;
    
}
