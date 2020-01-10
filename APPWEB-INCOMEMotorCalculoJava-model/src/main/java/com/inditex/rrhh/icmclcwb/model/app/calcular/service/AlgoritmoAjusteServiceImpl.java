package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoAjusteService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.AlgoritmoAjusteMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.AlgoritmoAjusteRepository;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.AlgoritmoAjusteRepositoryCustom;


@Service
@Validated
public class AlgoritmoAjusteServiceImpl implements AlgoritmoAjusteService {
    
    @Autowired
    private AlgoritmoAjusteRepositoryCustom algoritmoAjusteRepositoryCustom;
    
    @Autowired
    private AlgoritmoAjusteRepository algoritmoAjusteRepository;
    
    @Autowired
    private AlgoritmoAjusteMapper algoritmoAjusteMapper;
    
    @Override
    public List<Integer> customFindAjusteIdsByTarea(@NotNull @Positive final Long id) {
        return algoritmoAjusteRepositoryCustom.customFindAjusteIdsByTarea(id);
    }
    
    @Override
    public AlgoritmoAjusteDto findById(@NotNull @Positive final Integer id) {
        return algoritmoAjusteMapper.algoritmoAjusteToAlgoritmoAjusteDto(algoritmoAjusteRepository.findById(id).get());
    }
}
