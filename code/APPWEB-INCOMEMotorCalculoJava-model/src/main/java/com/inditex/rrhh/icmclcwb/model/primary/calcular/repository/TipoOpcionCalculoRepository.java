package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoOpcionCalculo;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TipoOpcionCalculoRepository extends BaseRepository<TipoOpcionCalculo, Long> {

  TipoOpcionCalculo findByIdMeta4(String idMeta4);

}
