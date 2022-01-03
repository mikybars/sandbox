package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoOpcionCalculoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoOpcionCalculoService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoOpcionCalculoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoOpcionCalculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TipoOpcionCalculoServiceImpl implements TipoOpcionCalculoService {

  @Autowired
  private TipoOpcionCalculoMapper tipoOpcionCalculoMapper;

  @Autowired
  private TipoOpcionCalculoRepository tipoOpcionCalculoRepository;

  @Override
  @Cacheable(value = "itx.icmlcwb.tipo_opcion_calculo_by_id_meta4", key = "#idMeta4")
  public TipoOpcionCalculoDto findByIdMeta4(String idMeta4) {
    return tipoOpcionCalculoMapper.tipoOpcionCalculoToTipoOpcionCalculoDto(
        tipoOpcionCalculoRepository.findByIdMeta4(idMeta4));
  }

}
