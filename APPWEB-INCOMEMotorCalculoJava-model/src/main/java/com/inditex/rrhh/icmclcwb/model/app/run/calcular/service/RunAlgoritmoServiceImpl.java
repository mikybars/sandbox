package com.inditex.rrhh.icmclcwb.model.app.run.calcular.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.calcular.dto.RunAlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.calcular.service.RunAlgoritmoService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmoFactory;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.AlgoritmoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.AlgoritmoRepository;

@Service
@Validated
public class RunAlgoritmoServiceImpl implements RunAlgoritmoService {

    @Autowired
    private AlgoritmoRepository algoritmoRepository;

    @Autowired
    private AlgoritmoMapper algoritmoMapper;

    @Autowired
    private RunAlgoritmoFactory runAlgoritmoFactory;

    @Override
    public RunAlgoritmoDto findById(@NotNull @Positive final Integer id) {
        RunAlgoritmoDto result = new RunAlgoritmoDto();
        AlgoritmoDto algoritmo = algoritmoMapper.algoritmoToAlgoritmoDto(algoritmoRepository.findById(id).get());
        String sqlCalcular = runAlgoritmoFactory.getRunAlgoritmo(algoritmo.getNombre()).getSqlCalcular(algoritmo);
        result.setAlgoritmo(algoritmo);
        result.setSqlCalcular(sqlCalcular);
        return result;
    }

    @Override
    public List<RunAlgoritmoDto> findAll() {
        List<RunAlgoritmoDto> result = new ArrayList<>();
        algoritmoMapper.algoritmoToAlgoritmoDto(algoritmoRepository.findAll()).stream().forEach(item -> {
            RunAlgoritmoDto runAlgoritmo = new RunAlgoritmoDto();
            String sqlCalcular = runAlgoritmoFactory.getRunAlgoritmo(item.getNombre()).getSqlCalcular(item);
            runAlgoritmo.setAlgoritmo(item);
            runAlgoritmo.setSqlCalcular(sqlCalcular);
            result.add(runAlgoritmo);
        });
        return result;
    }

}
