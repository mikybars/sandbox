package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.TIPO_OPCION_CALCULO_BY_ID_META4;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoOpcionCalculoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoOpcionCalculoService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoOpcionCalculoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoOpcionCalculoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class TipoOpcionCalculoServiceImpl implements TipoOpcionCalculoService {

  private final TipoOpcionCalculoMapper tipoOpcionCalculoMapper;

  private final TipoOpcionCalculoRepository tipoOpcionCalculoRepository;

  @Override
  @Cacheable(value = TIPO_OPCION_CALCULO_BY_ID_META4, key = "#idMeta4")
  public TipoOpcionCalculoDto findByIdMeta4(String idMeta4) {
    return this.tipoOpcionCalculoMapper.tipoOpcionCalculoToTipoOpcionCalculoDto(
        this.tipoOpcionCalculoRepository.findByIdMeta4(idMeta4));
  }

}
