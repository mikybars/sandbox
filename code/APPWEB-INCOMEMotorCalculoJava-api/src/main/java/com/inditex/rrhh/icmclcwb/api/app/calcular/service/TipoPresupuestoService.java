package com.inditex.rrhh.icmclcwb.api.app.calcular.service;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoPresupuestoDto;

public interface TipoPresupuestoService {

  TipoPresupuestoDto findByIcmIdTpPresupuesto(String icmIdTpPresupuesto);

  TipoPresupuestoDto findById(Integer id);

}
