package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

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
  @Cacheable(value = "itx.icmlcwb.tipo_unidad_tiempo_by_icm_id_unidad_tiempo", key = "#icmIdUnidadTiempo")
  public TipoUnidadTiempoDto findByIcmIdUnidadTiempo(String icmIdUnidadTiempo) {
    return tipoUnidadTiempoMapper.tipoUnidadTiempoToTipoUnidadTiempoDto(
        tipoUnidadTiempoRepository.findByIcmIdUnidadTiempo(icmIdUnidadTiempo));
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.tipo_unidad_tiempo_by_id", key = "#id")
  public TipoUnidadTiempoDto findById(Integer id) {
    return tipoUnidadTiempoMapper.tipoUnidadTiempoToTipoUnidadTiempoDto(
        tipoUnidadTiempoRepository.findById(id).get());
  }

}
