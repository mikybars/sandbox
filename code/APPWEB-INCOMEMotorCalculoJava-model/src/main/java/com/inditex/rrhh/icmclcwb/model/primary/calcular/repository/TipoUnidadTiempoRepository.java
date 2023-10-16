package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoUnidadTiempo;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TipoUnidadTiempoRepository extends BaseRepository<TipoUnidadTiempo, Integer> {

  TipoUnidadTiempo findByIcmIdUnidadTiempo(String icmIdUnidadTiempo);

}
