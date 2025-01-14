package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoVentaConceptoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoVentaConceptoService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoVentaConceptoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoVentaConceptoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class TipoVentaConceptoServiceImpl implements TipoVentaConceptoService {

  private final TipoVentaConceptoMapper tipoVentaConceptoMapper;

  private final TipoVentaConceptoRepository tipoVentaConceptoRepository;

  @Override
  @Cacheable(value = "itx.icmlcwb.tipo_venta_concepto_by_id_meta4", key = "#idMeta4")
  public TipoVentaConceptoDto findByIdMeta4(String idMeta4) {
    return tipoVentaConceptoMapper.tipoVentaConceptoToTipoVentaConceptoDto(
        tipoVentaConceptoRepository.findByIcmIdConceptoVenta(idMeta4));
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.tipo_venta_concepto_by_id", key = "#id")
  public TipoVentaConceptoDto findById(Long id) {
    return tipoVentaConceptoMapper.tipoVentaConceptoToTipoVentaConceptoDto(
        tipoVentaConceptoRepository.findById(id).get());
  }

}
