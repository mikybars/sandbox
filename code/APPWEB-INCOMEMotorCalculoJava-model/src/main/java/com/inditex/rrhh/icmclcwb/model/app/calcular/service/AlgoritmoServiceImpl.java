package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.AlgoritmoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.AlgoritmoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.AlgoritmoRepositoryCustom;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
  public List<Integer> customFindAlgoritmosIdsByTarea(@NotNull @Positive final Long id) {
    return this.algoritmoRepositoryCustom.customFindAlgoritmosIdsByTarea(id);
  }

  @Override
  public AlgoritmoDTO findByTipoCalculoId(@NotNull @Positive final Long id) {
    return this.algoritmoMapper.algoritmoToAlgoritmoDTO(this.algoritmoRepository.findByTipoCalculoId(id));
  }

  @Override
  public AlgoritmoDTO findByTipoCalculoIdAndTipoComisionId(@NotNull @Positive final Long idTipoCalculo,
      @NotNull @Positive final Long idTipoComision) {
    return this.algoritmoMapper.algoritmoToAlgoritmoDTO(
        this.algoritmoRepository.findByTipoCalculoIdAndTipoComisionId(idTipoCalculo, idTipoComision));
  }

  @Override
  public AlgoritmoDTO findById(@NotNull @Positive final Integer id) {
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
