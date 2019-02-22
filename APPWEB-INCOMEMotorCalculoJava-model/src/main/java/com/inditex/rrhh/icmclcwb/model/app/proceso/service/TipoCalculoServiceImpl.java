package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.service.TipoCalculoService;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.TipoCalculoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.TipoCalculoRepository;

@Service
@Validated
public class TipoCalculoServiceImpl implements TipoCalculoService {

    @Autowired
    private TipoCalculoRepository tipoCalculoRepository;
    
    @Autowired
    private TipoCalculoMapper tipoCalculoMapper;
}
