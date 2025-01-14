package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoPresupuestoService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoPresupuestoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoPresupuestoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class TipoPresupuestoServiceImpl implements TipoPresupuestoService {

  private final TipoPresupuestoRepository tipoPresupuestoRepository;

  private final TipoPresupuestoMapper tipoPresupuestoMapper;

  @Override
  @Cacheable(value = "itx.icmlcwb.tipo_presupuesto_by_icm_id_tp_presupuesto", key = "#icmIdTpPresupuesto")
  public TipoPresupuestoDto findByIcmIdTpPresupuesto(String icmIdTpPresupuesto) {
    return tipoPresupuestoMapper.tipoPresupuestoToTipoPreupuestoDto(
        tipoPresupuestoRepository.findByIcmIdTpPresupuesto(icmIdTpPresupuesto));
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.tipo_presupuesto_by_id", key = "#id")
  public TipoPresupuestoDto findById(Integer id) {
    return tipoPresupuestoMapper.tipoPresupuestoToTipoPreupuestoDto(
        tipoPresupuestoRepository.findById(id).get());
  }

}
