package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoCalculoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoComisionDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoDatoDto;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.Algoritmo;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoCalculo;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoComision;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class AlgoritmoMapper {

  public abstract AlgoritmoDTO algoritmoToAlgoritmoDTO(Algoritmo src);

  public abstract List<AlgoritmoDTO> algoritmoToAlgoritmoDTO(List<Algoritmo> src);

  @InheritInverseConfiguration
  // @Mapping(target = "tipoComision.nombre", ignore = true)
  // @Mapping(target = "tipoComision.algoritmo", ignore = true)
  // @Mapping(target = "tipoDato.tipoPresencia", ignore = true)
  // @Mapping(target = "tipoDato.tipoVenta", ignore = true)
  public abstract Algoritmo algoritmoDTOToAlgoritmo(AlgoritmoDTO src);

  @InheritInverseConfiguration
  public abstract List<Algoritmo> algoritmoDTOToAlgoritmo(List<AlgoritmoDTO> src);

  public abstract TipoCalculoDto tipoCalculoToTipoCalculoDto(TipoCalculo src);

  @InheritInverseConfiguration
  @Mapping(target = "id", source = "id")
  @Mapping(target = "nombre", ignore = true)
  @Mapping(target = "algoritmo", ignore = true)
  public abstract TipoCalculo tipoCalculoDtoToTipoCalculo(TipoCalculoDto src);

  public abstract TipoComisionDto tipoComisionToTipoComisionDto(TipoComision src);

  @InheritInverseConfiguration
  @Mapping(target = "id", source = "id")
  @Mapping(target = "nombre", ignore = true)
  @Mapping(target = "algoritmo", ignore = true)
  public abstract TipoComision tipoComisionDtoToTipoComision(TipoComisionDto src);

  public abstract TipoDatoDto tipoDatoToTipoDatoDto(TipoDato src);

  @InheritInverseConfiguration
  @Mapping(target = "tipoPresencia", ignore = true)
  @Mapping(target = "tipoVenta", ignore = true)
  public abstract TipoDato tipoDatoDtoToTipoDato(TipoDatoDto src);

}
