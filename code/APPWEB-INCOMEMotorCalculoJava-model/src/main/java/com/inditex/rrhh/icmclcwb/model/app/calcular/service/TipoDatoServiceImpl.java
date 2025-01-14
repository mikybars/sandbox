package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoDatoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class TipoDatoServiceImpl implements TipoDatoService {

  private final TipoDatoRepository tipoDatoRepository;

  @Override
  @Cacheable(value = "itx.icmlcwb.id_tipo_dato_by_id_tipo_grupo_dato", key = "{#idTipoGrupoDato}")
  public List<IdTipoDatoDto> findTipoDatoByTipoGrupoDato(Integer idTipoGrupoDato) {
    List<TipoDato> tiposDato = tipoDatoRepository.findTipoDatoByTipoGrupoDato(idTipoGrupoDato);
    return tiposDato.stream()
        .map(tipoDato -> IdTipoDatoDto.builder().id(tipoDato.getId()).build())
        .collect(Collectors.toList());
  }

}
