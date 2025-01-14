package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoPoliticaDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoPoliticaService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoPoliticaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoPoliticaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class TipoPoliticaServiceImpl implements TipoPoliticaService {

  private final TipoPoliticaRepository tipoPoliticaRepository;

  private final TipoPoliticaMapper tipoPoliticaMapper;

  @Override
  @Cacheable(value = "itx.icmlcwb.tipo_politica_by_id_meta4", key = "#idMeta4")
  public TipoPoliticaDto findByIdMeta4(String idMeta4) {
    return tipoPoliticaMapper.tipoPoliticaToTipoPoliticaDto(tipoPoliticaRepository.findByIcmIdTpPolitica(idMeta4));
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.tipo_politica_by_id", key = "#id")
  public TipoPoliticaDto findById(Integer id) {
    return tipoPoliticaMapper.tipoPoliticaToTipoPoliticaDto(tipoPoliticaRepository.findById(id).get());
  }

}
