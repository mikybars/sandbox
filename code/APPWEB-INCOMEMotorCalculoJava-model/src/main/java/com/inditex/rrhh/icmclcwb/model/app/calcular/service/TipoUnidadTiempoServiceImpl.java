package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.TIPO_UNIDAD_TIEMPO_BY_ICM_ID_UNIDAD_TIEMPO;
import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.TIPO_UNIDAD_TIEMPO_BY_ID;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoUnidadTiempoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoUnidadTiempoService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoUnidadTiempoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoUnidadTiempoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TipoUnidadTiempoServiceImpl implements TipoUnidadTiempoService {

  @Autowired
  private TipoUnidadTiempoMapper tipoUnidadTiempoMapper;

  @Autowired
  private TipoUnidadTiempoRepository tipoUnidadTiempoRepository;

  @Override
  @Cacheable(value = TIPO_UNIDAD_TIEMPO_BY_ICM_ID_UNIDAD_TIEMPO, key = "#icmIdUnidadTiempo")
  public TipoUnidadTiempoDto findByIcmIdUnidadTiempo(String icmIdUnidadTiempo) {
    return this.tipoUnidadTiempoMapper.tipoUnidadTiempoToTipoUnidadTiempoDto(
        this.tipoUnidadTiempoRepository.findByIcmIdUnidadTiempo(icmIdUnidadTiempo));
  }

  @Override
  @Cacheable(value = TIPO_UNIDAD_TIEMPO_BY_ID, key = "#id")
  public TipoUnidadTiempoDto findById(Integer id) {
    return this.tipoUnidadTiempoMapper.tipoUnidadTiempoToTipoUnidadTiempoDto(
        this.tipoUnidadTiempoRepository.findById(id).get());
  }

}
