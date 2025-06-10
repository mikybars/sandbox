package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoOpcionCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoOpcionCalculoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoOpcionCalculoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaCondicionesBaseResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaPersonaEstructuraMapperDecorator extends TareaPersonaEstructuraMapper {

  @Autowired
  private TareaPersonaEstructuraMapper delegate;

  @Autowired
  private TipoOpcionCalculoService tipoOpcionCalculoService;

  @Override
  public TareaPersonaEstructura tareaPersonaEstructuraDtoToTareaPersonaEstructura(
      final TareaPersonaEstructuraDto src) {
    final TareaPersonaEstructura result = this.delegate.tareaPersonaEstructuraDtoToTareaPersonaEstructura(src);
    result.setTarea(new Tarea());
    result.getTarea().setId(src.getIdTarea());
    return result;
  }

  @Override
  public List<TareaPersonaEstructura> tareaPersonaEstructuraDtoToTareaPersonaEstructura(
      final List<TareaPersonaEstructuraDto> src) {
    final List<TareaPersonaEstructura> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(estructura -> result.add(this.tareaPersonaEstructuraDtoToTareaPersonaEstructura(estructura)));
    }
    return result;
  }

  @Override
  public List<TareaPersonaEstructuraDto> estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(
      final List<EstructurasComResultItemDto> estructurasComResultItem, final TareaDto tarea) {
    final List<TareaPersonaEstructuraDto> result = new ArrayList<>();
    estructurasComResultItem.forEach(itemPadre -> {
      /*-----------------*/
      /* Estructura base */
      /*-----------------*/
      if (CollectionUtils.isNotEmpty(itemPadre.getIcmListaCondicionesBase())) {
        final ListaCondicionesBaseResultItemDto itemBase = itemPadre.getIcmListaCondicionesBase().get(0);
        if (StringUtils.isEmpty(itemBase.getIdTipoCalculo())) {
          itemBase.setIdTipoCalculo(TipoCalculoEnum.NINGUNO.getId());
        }
        if (CollectionUtils.isEmpty(itemPadre.getIcmListaCondicionesBase().get(0).getIcmListaValoresBase())) {
          result.add(this.delegate
              .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndTareaToTareaPersonaEstructuraDto(
                  itemPadre, itemBase, tarea));
        } else {
          itemBase.getIcmListaValoresBase().forEach(itemBaseValor -> {
            final Integer itemBaseValorSeccion = Integer.valueOf(itemBaseValor.getIdSeccion());
            if (AppConstants.SECCION_4.equals(itemBaseValorSeccion)
                && !itemBase.getIdTipoCalculo()
                    .equals(TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId())
                && !itemBase.getIdTipoCalculo()
                    .equals(TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId())
                && !itemBase.getIdTipoCalculo()
                    .equals(TipoCalculoEnum.CHALLENGE_JORNADA.getId())) {
              for (final Integer itemBaseValorSeccionFicticia : AppConstants.getSECCIONES()) {
                result.add(this.delegate
                    .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaValoresBaseResultItemDtoAndIdSerccionAndTareaToTareaPersonaEstructuraDto(
                        itemPadre, itemBase, itemBaseValor, itemBaseValorSeccionFicticia, tarea));
              }
            } else {
              result.add(this.delegate
                  .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaValoresBaseResultItemDtoAndIdSerccionAndTareaToTareaPersonaEstructuraDto(
                      itemPadre, itemBase, itemBaseValor, itemBaseValorSeccion, tarea));
            }
          });
        }
        /*---------------------------*/
        /* Estructura desplazamiento */
        /*---------------------------*/
        if (CollectionUtils.isNotEmpty(itemPadre.getIcmListaCondicionesDestino())) {
          final AtomicInteger counter = new AtomicInteger(0);
          itemPadre.getIcmListaCondicionesDestino().forEach(itemDesplazamiento -> {
            final TipoOpcionCalculoDto opcion = this.tipoOpcionCalculoService
                .findByIdMeta4(itemDesplazamiento.getIdTipoOpCalculo());
            if (StringUtils.isEmpty(itemDesplazamiento.getIdTipoCalculo())) {
              itemDesplazamiento.setIdTipoCalculo(TipoCalculoEnum.NINGUNO.getId());
            }
            if (CollectionUtils.isEmpty(itemDesplazamiento.getIcmListaValoresDestino())) {
              if (TipoOpcionCalculoEnum.MEJOR_OPCION.getId().equals(opcion.getId())) {
                result.add(this.delegate
                    .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraToTareaPersonaEstructuraDto(
                        itemPadre, itemBase, itemDesplazamiento, tarea, counter.incrementAndGet(),
                        TipoOpcionCalculoEnum.ORIGEN.getId(), opcion.getId(),
                        Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasOrigen()),
                        Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasDestino()),
                        Meta4Constants.TRUE
                            .equals(itemDesplazamiento.getTotalCondiciones())));
                result.add(this.delegate
                    .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraToTareaPersonaEstructuraDto(
                        itemPadre, itemBase, itemDesplazamiento, tarea, counter.incrementAndGet(),
                        TipoOpcionCalculoEnum.DESTINO.getId(), opcion.getId(),
                        Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasOrigen()),
                        Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasDestino()),
                        Meta4Constants.TRUE
                            .equals(itemDesplazamiento.getTotalCondiciones())));
              } else {
                result.add(this.delegate
                    .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraToTareaPersonaEstructuraDto(
                        itemPadre, itemBase, itemDesplazamiento, tarea, counter.incrementAndGet(),
                        opcion.getId(), opcion.getId(),
                        Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasOrigen()),
                        Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasDestino()),
                        Meta4Constants.TRUE
                            .equals(itemDesplazamiento.getTotalCondiciones())));
              }
            } else {
              itemDesplazamiento.getIcmListaValoresDestino().forEach(itemDesplazamientoValor -> {
                final Integer itemDesplazamientoValorSeccion = Integer
                    .valueOf(itemDesplazamientoValor.getIdSeccion());
                if (AppConstants.SECCION_4.equals(itemDesplazamientoValorSeccion)
                    && !itemDesplazamiento.getIdTipoCalculo()
                        .equals(TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId())
                    && !itemDesplazamiento.getIdTipoCalculo()
                        .equals(TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId())
                    && !itemBase.getIdTipoCalculo()
                        .equals(TipoCalculoEnum.CHALLENGE_JORNADA.getId())) {
                  for (final Integer itemBaseValorSeccionFicticia : AppConstants.getSECCIONES()) {
                    if (TipoOpcionCalculoEnum.MEJOR_OPCION.getId().equals(opcion.getId())) {
                      result.add(this.delegate
                          .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
                              itemPadre, itemBase, itemDesplazamiento,
                              itemDesplazamientoValor, tarea, counter.incrementAndGet(),
                              TipoOpcionCalculoEnum.ORIGEN.getId(), opcion.getId(),
                              itemBaseValorSeccionFicticia,
                              Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasOrigen()),
                              Meta4Constants.TRUE
                                  .equals(itemDesplazamiento.getHorasDestino()),
                              Meta4Constants.TRUE
                                  .equals(itemDesplazamiento.getTotalCondiciones())));
                      result.add(this.delegate
                          .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
                              itemPadre, itemBase, itemDesplazamiento,
                              itemDesplazamientoValor, tarea, counter.incrementAndGet(),
                              TipoOpcionCalculoEnum.DESTINO.getId(), opcion.getId(),
                              itemBaseValorSeccionFicticia,
                              Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasOrigen()),
                              Meta4Constants.TRUE
                                  .equals(itemDesplazamiento.getHorasDestino()),
                              Meta4Constants.TRUE
                                  .equals(itemDesplazamiento.getTotalCondiciones())));
                    } else {
                      result.add(this.delegate
                          .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
                              itemPadre, itemBase, itemDesplazamiento,
                              itemDesplazamientoValor, tarea, counter.incrementAndGet(),
                              opcion.getId(), opcion.getId(), itemBaseValorSeccionFicticia,
                              Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasOrigen()),
                              Meta4Constants.TRUE
                                  .equals(itemDesplazamiento.getHorasDestino()),
                              Meta4Constants.TRUE
                                  .equals(itemDesplazamiento.getTotalCondiciones())));
                    }
                  }
                } else {
                  if (TipoOpcionCalculoEnum.MEJOR_OPCION.getId().equals(opcion.getId())) {
                    result.add(this.delegate
                        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
                            itemPadre, itemBase, itemDesplazamiento, itemDesplazamientoValor,
                            tarea, counter.incrementAndGet(),
                            TipoOpcionCalculoEnum.ORIGEN.getId(), opcion.getId(),
                            itemDesplazamientoValorSeccion,
                            Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasOrigen()),
                            Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasDestino()),
                            Meta4Constants.TRUE
                                .equals(itemDesplazamiento.getTotalCondiciones())));
                    result.add(this.delegate
                        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
                            itemPadre, itemBase, itemDesplazamiento, itemDesplazamientoValor,
                            tarea, counter.incrementAndGet(),
                            TipoOpcionCalculoEnum.DESTINO.getId(), opcion.getId(),
                            itemDesplazamientoValorSeccion,
                            Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasOrigen()),
                            Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasDestino()),
                            Meta4Constants.TRUE
                                .equals(itemDesplazamiento.getTotalCondiciones())));
                  } else {
                    result.add(this.delegate
                        .estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
                            itemPadre, itemBase, itemDesplazamiento, itemDesplazamientoValor,
                            tarea, counter.incrementAndGet(), opcion.getId(), opcion.getId(),
                            itemDesplazamientoValorSeccion,
                            Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasOrigen()),
                            Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasDestino()),
                            Meta4Constants.TRUE
                                .equals(itemDesplazamiento.getTotalCondiciones())));
                  }
                }
              });
            }
          });
        }
      }
    });
    return result;
  }

  @Override
  public List<TareaPersonaEstructura> simulacionTareaPersonaEstructuraDtoToTareaPersonaEstructuraDto(
      final List<TareaPersonaEstructuraDto> tareaPersonaEstructuraDto) {
    final List<TareaPersonaEstructura> result = new ArrayList<>();

    if (CollectionUtils.isNotEmpty(tareaPersonaEstructuraDto)) {
      tareaPersonaEstructuraDto.forEach(itemBaseValor -> {
        final Integer itemBaseValorSeccion = Integer.valueOf(itemBaseValor.getCclIdSeccionEfectiva());
        if (AppConstants.SECCION_4.equals(itemBaseValorSeccion)
            && !itemBaseValor.getIcmIdTpCalculo()
                .equals(TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId())
            && !itemBaseValor.getIcmIdTpCalculo()
                .equals(TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId())) {
          for (final Integer itemBaseValorSeccionFicticia : AppConstants.getSECCIONES()) {
            final TareaPersonaEstructura estructura = this.tareaPersonaEstructuraDtoToTareaPersonaEstructura(itemBaseValor);
            estructura.setCclIdSeccionEfectiva(String.valueOf(itemBaseValorSeccionFicticia));
            result.add(estructura);
          }
        } else {
          result.add(this.tareaPersonaEstructuraDtoToTareaPersonaEstructura(itemBaseValor));
        }

      });
    }

    return result;

  }
}
