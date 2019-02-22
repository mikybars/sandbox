package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.service.AlgoritmoService;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.AlgoritmoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.AlgoritmoRepository;

@Service
@Validated
public class AlgoritmoServiceImpl implements AlgoritmoService {

    @Autowired
    private AlgoritmoRepository algoritmoRepository;
    
    @Autowired
    private AlgoritmoMapper algoritmoMapper;
    
    @Override
    public AlgoritmoDto findByTipoCalculoId(@NotNull @Positive final Long id) {
        return algoritmoMapper.algoritmoToAlgoritmoDto(algoritmoRepository.findByTipoCalculoId(id));
    }
    
    @Override
    public AlgoritmoDto findByTipoCalculoId(@NotNull @Positive final Long idTipoCalculo, @NotNull @Positive final Long idTipoComision) {
        return algoritmoMapper.algoritmoToAlgoritmoDto(algoritmoRepository.findByTipoCalculoIdAndTipoComisionId(idTipoCalculo, idTipoComision));
    }

    @Override
    public AlgoritmoDto findById(Long id) {
        return algoritmoMapper.algoritmoToAlgoritmoDto(algoritmoRepository.findById(id).orElse(null));
    }
}
