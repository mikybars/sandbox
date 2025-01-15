package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.TIPO_AUSENCIA_BY_ICM_TP_ABSENCE;
import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.TIPO_AUSENCIA_BY_ID;

import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoAusenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoAusenciaService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoAusenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoAusencia;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoAusenciaRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class TipoAusenciaServiceImpl implements TipoAusenciaService {

  private final TipoAusenciaMapper tipoAusenciaMapper;

  private final TipoAusenciaRepository tipoAusenciaRepository;

  @Override
  @Cacheable(value = TIPO_AUSENCIA_BY_ICM_TP_ABSENCE, key = "#icmTpAbsence")
  public TipoAusenciaDto findByIcmTpAbsence(String icmTpAbsence) {
    return this.tipoAusenciaMapper.tipoAusenciaToTipoAusenciaDto(
        this.tipoAusenciaRepository.findByIcmTpAbsence(icmTpAbsence));
  }

  @Override
  @Cacheable(value = TIPO_AUSENCIA_BY_ID, key = "#id")
  public TipoAusenciaDto findById(Integer id) {
    final Optional<TipoAusencia> optionalTipoAusencia = this.tipoAusenciaRepository.findById(id);
    if (optionalTipoAusencia.isPresent()) {
      return this.tipoAusenciaMapper.tipoAusenciaToTipoAusenciaDto(optionalTipoAusencia.get());
    } else {
      throw new EntityNotFoundException("TipoAusencia not found");
    }
  }

}
