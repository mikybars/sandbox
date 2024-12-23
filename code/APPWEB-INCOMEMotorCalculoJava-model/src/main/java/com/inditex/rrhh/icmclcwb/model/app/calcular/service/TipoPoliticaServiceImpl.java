package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.TIPO_POLITICA_BY_ID;
import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.TIPO_POLITICA_BY_ID_META4;

import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoPoliticaDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoPoliticaService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoPoliticaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPolitica;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoPoliticaRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TipoPoliticaServiceImpl implements TipoPoliticaService {

  @Autowired
  private TipoPoliticaRepository tipoPoliticaRepository;

  @Autowired
  private TipoPoliticaMapper tipoPoliticaMapper;

  @Override
  @Cacheable(value = TIPO_POLITICA_BY_ID_META4, key = "#idMeta4")
  public TipoPoliticaDto findByIdMeta4(String idMeta4) {
    return this.tipoPoliticaMapper.tipoPoliticaToTipoPoliticaDto(this.tipoPoliticaRepository.findByIcmIdTpPolitica(idMeta4));
  }

  @Override
  @Cacheable(value = TIPO_POLITICA_BY_ID, key = "#id")
  public TipoPoliticaDto findById(Integer id) {
    final Optional<TipoPolitica> optionalTipoPolitica = this.tipoPoliticaRepository.findById(id);
    if (optionalTipoPolitica.isPresent()) {
      return this.tipoPoliticaMapper.tipoPoliticaToTipoPoliticaDto(optionalTipoPolitica.get());
    } else {
      throw new EntityNotFoundException("TipoPolitica not found");
    }
  }

}
