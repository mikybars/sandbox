package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.TIPO_UNIDAD_TIEMPO_BY_ICM_ID_UNIDAD_TIEMPO;
import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.TIPO_UNIDAD_TIEMPO_BY_ID;

import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoUnidadTiempoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoUnidadTiempoService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoUnidadTiempoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoUnidadTiempo;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoUnidadTiempoRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class TipoUnidadTiempoServiceImpl implements TipoUnidadTiempoService {

  private final TipoUnidadTiempoMapper tipoUnidadTiempoMapper;

  private final TipoUnidadTiempoRepository tipoUnidadTiempoRepository;

  @Override
  @Cacheable(value = TIPO_UNIDAD_TIEMPO_BY_ICM_ID_UNIDAD_TIEMPO, key = "#icmIdUnidadTiempo")
  public TipoUnidadTiempoDto findByIcmIdUnidadTiempo(String icmIdUnidadTiempo) {
    return this.tipoUnidadTiempoMapper.tipoUnidadTiempoToTipoUnidadTiempoDto(
        this.tipoUnidadTiempoRepository.findByIcmIdUnidadTiempo(icmIdUnidadTiempo));
  }

  @Override
  @Cacheable(value = TIPO_UNIDAD_TIEMPO_BY_ID, key = "#id")
  public TipoUnidadTiempoDto findById(Integer id) {
    final Optional<TipoUnidadTiempo> optionalTipoUnidadTiempo = this.tipoUnidadTiempoRepository.findById(id);
    if (optionalTipoUnidadTiempo.isPresent()) {
      return this.tipoUnidadTiempoMapper.tipoUnidadTiempoToTipoUnidadTiempoDto(optionalTipoUnidadTiempo.get());
    } else {
      throw new EntityNotFoundException("TipoUnidadTiempo not found");
    }
  }

}
