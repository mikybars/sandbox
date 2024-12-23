package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.TIPO_VENTA_CONCEPTO_BY_ID;
import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.TIPO_VENTA_CONCEPTO_BY_ID_META4;

import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoVentaConceptoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoVentaConceptoService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoVentaConceptoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConcepto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoVentaConceptoRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TipoVentaConceptoServiceImpl implements TipoVentaConceptoService {

  @Autowired
  private TipoVentaConceptoMapper tipoVentaConceptoMapper;

  @Autowired
  private TipoVentaConceptoRepository tipoVentaConceptoRepository;

  @Override
  @Cacheable(value = TIPO_VENTA_CONCEPTO_BY_ID_META4, key = "#idMeta4")
  public TipoVentaConceptoDto findByIdMeta4(String idMeta4) {
    return this.tipoVentaConceptoMapper.tipoVentaConceptoToTipoVentaConceptoDto(
        this.tipoVentaConceptoRepository.findByIcmIdConceptoVenta(idMeta4));
  }

  @Override
  @Cacheable(value = TIPO_VENTA_CONCEPTO_BY_ID, key = "#id")
  public TipoVentaConceptoDto findById(Long id) {
    final Optional<TipoVentaConcepto> optionalTipoVentaConcepto = this.tipoVentaConceptoRepository.findById(id);
    if (optionalTipoVentaConcepto.isPresent()) {
      return this.tipoVentaConceptoMapper.tipoVentaConceptoToTipoVentaConceptoDto(optionalTipoVentaConcepto.get());
    } else {
      throw new EntityNotFoundException("TipoVentaConcepto not found");
    }
  }

}
