package com.inditex.rrhh.icmclcwb.model.app.run.calcular.service;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.calcular.service.RunAlgoritmoService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.dto.RunAlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmoFactory;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.AlgoritmoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.AlgoritmoRepository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
  public RunAlgoritmoDTO findById(@NotNull @Positive final Integer id) {
    final RunAlgoritmoDTO result = new RunAlgoritmoDTO();
    final AlgoritmoDTO algoritmo = this.algoritmoMapper
        .algoritmoToAlgoritmoDTO(this.algoritmoRepository.findById(id).get());
    final String sqlCalcular = this.runAlgoritmoFactory.getRunAlgoritmo(algoritmo.getNombre())
        .getSqlCalcular(algoritmo);
    result.setAlgoritmo(algoritmo);
    result.setSqlCalcular(sqlCalcular);
    return result;
  }

  @Override
  public List<RunAlgoritmoDTO> findAll() {
    final List<RunAlgoritmoDTO> result = new ArrayList<>();
    this.algoritmoMapper
        .algoritmoToAlgoritmoDTO(new ArrayList<>(this.algoritmoRepository.findByActivo(Boolean.TRUE)))
        .stream()
        .forEach(item -> {
          final RunAlgoritmoDTO runAlgoritmo = new RunAlgoritmoDTO();
          final String sqlCalcular = this.runAlgoritmoFactory.getRunAlgoritmo(item.getNombre())
              .getSqlCalcular(item);
          runAlgoritmo.setAlgoritmo(item);
          runAlgoritmo.setSqlCalcular(sqlCalcular);
          result.add(runAlgoritmo);
        });
    return result;
  }

}
