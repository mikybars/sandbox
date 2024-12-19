package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.TIPO_PRESUPUESTO_BY_ICM_ID_TP_PRESUPUESTO;
import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.TIPO_PRESUPUESTO_BY_ID;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoPresupuestoService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoPresupuestoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoPresupuestoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TipoPresupuestoServiceImpl implements TipoPresupuestoService {

  @Autowired
  private TipoPresupuestoRepository tipoPresupuestoRepository;

  @Autowired
  private TipoPresupuestoMapper tipoPresupuestoMapper;

  @Override
  @Cacheable(value = TIPO_PRESUPUESTO_BY_ICM_ID_TP_PRESUPUESTO, key = "#icmIdTpPresupuesto")
  public TipoPresupuestoDto findByIcmIdTpPresupuesto(String icmIdTpPresupuesto) {
    return this.tipoPresupuestoMapper.tipoPresupuestoToTipoPreupuestoDto(
        this.tipoPresupuestoRepository.findByIcmIdTpPresupuesto(icmIdTpPresupuesto));
  }

  @Override
  @Cacheable(value = TIPO_PRESUPUESTO_BY_ID, key = "#id")
  public TipoPresupuestoDto findById(Integer id) {
    return this.tipoPresupuestoMapper.tipoPresupuestoToTipoPreupuestoDto(
        this.tipoPresupuestoRepository.findById(id).get());
  }

}
