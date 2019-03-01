package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.service.AlgoritmoService;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.AlgoritmoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.AlgoritmoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.AlgoritmoRepositoryCustom;

@Service
@Validated
public class AlgoritmoServiceImpl implements AlgoritmoService {

    @Autowired
    private AlgoritmoRepository algoritmoRepository;
    
    @Autowired
    private AlgoritmoRepositoryCustom algoritmoRepositoryCustom;
    
    @Autowired
    private AlgoritmoMapper algoritmoMapper;

    @Override
    public List<Long> customFindAlgoritmosIdsByProceso(@NotNull @Positive final Long id){
        return algoritmoRepositoryCustom.customFindAlgoritmosIdsByProceso(id);
    }
    
    @Override
    public AlgoritmoDto findByTipoCalculoId(@NotNull @Positive final Long id) {
        return algoritmoMapper.algoritmoToAlgoritmoDto(algoritmoRepository.findByTipoCalculoId(id));
    }
    
    @Override
    public AlgoritmoDto findByTipoCalculoIdAndTipoComisionId(@NotNull @Positive final Long idTipoCalculo, @NotNull @Positive final Long idTipoComision) {
        return algoritmoMapper.algoritmoToAlgoritmoDto(algoritmoRepository.findByTipoCalculoIdAndTipoComisionId(idTipoCalculo, idTipoComision));
    }

    @Override
    public AlgoritmoDto findById(@NotNull @Positive final Long id) {
        return algoritmoMapper.algoritmoToAlgoritmoDto(algoritmoRepository.findById(id).orElse(null));
    }
    
    @Override
    public List<AlgoritmoDto> findAll(){
        return algoritmoMapper.algoritmoToAlgoritmoDto(algoritmoRepository.findAll());
    }
    
    @Override
    public Boolean checkDuplicatedActives(){
        return algoritmoRepositoryCustom.checkDuplicatedActives();
    }
}
