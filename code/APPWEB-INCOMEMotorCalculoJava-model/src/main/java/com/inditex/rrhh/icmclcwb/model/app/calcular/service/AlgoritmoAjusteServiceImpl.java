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
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class AlgoritmoAjusteServiceImpl implements AlgoritmoAjusteService {

  private final AlgoritmoAjusteRepositoryCustom algoritmoAjusteRepositoryCustom;

  private final AlgoritmoAjusteRepository algoritmoAjusteRepository;

  private final AlgoritmoAjusteMapper algoritmoAjusteMapper;

  @Override
  public List<Long> customFindAjustePesosByTarea(@NonNull @Positive final Long id) {
    return this.algoritmoAjusteRepositoryCustom.customFindAjustePesosByTarea(id);
  }

  @Override
  public List<Integer> customFindAjusteIdsByTareaAndPeso(@NonNull @Positive final Long idTarea,
      @NonNull @Positive final Long peso) {
    return this.algoritmoAjusteRepositoryCustom.customFindAjusteIdsByTareaAndPeso(idTarea, peso);
  }

  @Override
  public AlgoritmoAjusteDto findById(@NonNull @Positive final Integer id) {
    return this.algoritmoAjusteMapper
        .algoritmoAjusteToAlgoritmoAjusteDto(OptionalUtils.get(this.algoritmoAjusteRepository.findById(id)));
  }

  @Override
  public List<AlgoritmoAjusteDto> findByPeso(@NonNull @Positive final Long id) {
    return this.algoritmoAjusteMapper
        .algoritmoAjusteToAlgoritmoAjusteDto(
            OptionalUtils.get(this.algoritmoAjusteRepository.findByPeso(id), new ArrayList<>()));
  }

}
