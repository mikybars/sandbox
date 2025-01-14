package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.AlgoritmoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.AlgoritmoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.AlgoritmoRepositoryCustom;

import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class AlgoritmoServiceImpl implements AlgoritmoService {

  private final AlgoritmoRepository algoritmoRepository;

  private final AlgoritmoRepositoryCustom algoritmoRepositoryCustom;

  private final AlgoritmoMapper algoritmoMapper;

  @Override
  public List<Integer> customFindAlgoritmosIdsByTarea(@NonNull @Positive final Long id) {
    return this.algoritmoRepositoryCustom.customFindAlgoritmosIdsByTarea(id);
  }

  @Override
  public AlgoritmoDTO findById(@NonNull @Positive final Integer id) {
    return this.algoritmoMapper.algoritmoToAlgoritmoDTO(this.algoritmoRepository.findById(id).get());
  }

  @Override
  public List<AlgoritmoDTO> findAll() {
    return this.algoritmoMapper.algoritmoToAlgoritmoDTO(this.algoritmoRepository.findAll());
  }

  @Override
  public Boolean checkDuplicatedActives() {
    return this.algoritmoRepositoryCustom.checkDuplicatedActives();
  }

}
