package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPresupuesto;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TipoPresupuestoRepository extends BaseRepository<TipoPresupuesto, Integer> {

  TipoPresupuesto findByIcmIdTpPresupuesto(String icmIdTpPresupuesto);

}
