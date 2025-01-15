package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoAjusteService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.AlgoritmoAjusteMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.OptionalUtils;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.AlgoritmoAjusteRepository;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.AlgoritmoAjusteRepositoryCustom;

import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
  public List<Long> customFindAjustePesosByTarea(@NotNull @Positive final Long id) {
    return this.algoritmoAjusteRepositoryCustom.customFindAjustePesosByTarea(id);
  }

  @Override
  public List<Integer> customFindAjusteIdsByTareaAndPeso(@NotNull @Positive final Long idTarea,
      @NotNull @Positive final Long peso) {
    return this.algoritmoAjusteRepositoryCustom.customFindAjusteIdsByTareaAndPeso(idTarea, peso);
  }

  @Override
  public AlgoritmoAjusteDto findById(@NotNull @Positive final Integer id) {
    return this.algoritmoAjusteMapper
        .algoritmoAjusteToAlgoritmoAjusteDto(OptionalUtils.get(this.algoritmoAjusteRepository.findById(id)));
  }

  @Override
  public List<AlgoritmoAjusteDto> findByPeso(@NotNull @Positive final Long id) {
    return this.algoritmoAjusteMapper
        .algoritmoAjusteToAlgoritmoAjusteDto(
            OptionalUtils.get(this.algoritmoAjusteRepository.findByPeso(id), new ArrayList<>()));
  }

}
