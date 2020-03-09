package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaCondicionesDestinoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaValoresBaseResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaValoresDestinoResultItemDto;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoOpcionCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaCondicionesBaseResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;

public abstract class TareaPersonaEstructuraMapperDecorator extends TareaPersonaEstructuraMapper {

    @Autowired
    private TareaPersonaEstructuraMapper delegate;

    @Override
    public TareaPersonaEstructura tareaPersonaEstructuraDtoToTareaPersonaEstructura(
        TareaPersonaEstructuraDto src) {
        TareaPersonaEstructura result = delegate.tareaPersonaEstructuraDtoToTareaPersonaEstructura(src);
        result.setTarea(new Tarea());
        result.getTarea().setId(src.getIdTarea());
        return result;
    }

    @Override
    public TareaPersonaEstructuraDto estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndTareaToTareaPersonaEstructuraDto(
        EstructurasComResultItemDto estructurasComResultItem, ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItem, TareaDto tarea) {
        TareaPersonaEstructuraDto estructura =
            delegate.estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndTareaToTareaPersonaEstructuraDto(
                estructurasComResultItem, listaCondicionesBaseResultItem, tarea);
        setActivo(estructura);
        return estructura;
    }

    @Override
    public TareaPersonaEstructuraDto estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaValoresBaseResultItemDtoAndIdSerccionAndTareaToTareaPersonaEstructuraDto(EstructurasComResultItemDto estructurasComResultItem, ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItem, ListaValoresBaseResultItemDto listaValoresBaseResultItem, Integer idSeccion, TareaDto tarea) {
        TareaPersonaEstructuraDto estructura =
            delegate.estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaValoresBaseResultItemDtoAndIdSerccionAndTareaToTareaPersonaEstructuraDto(
                estructurasComResultItem, listaCondicionesBaseResultItem, listaValoresBaseResultItem, idSeccion, tarea);
        setActivo(estructura);
        return estructura;
    }

    @Override
    public TareaPersonaEstructuraDto estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraToTareaPersonaEstructuraDto(
        EstructurasComResultItemDto estructurasComResultItem, ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItem, ListaCondicionesDestinoResultItemDto listaCondicionesDestinoResultItem, TareaDto tarea, Integer ordinalEstructura, Integer idTipoOpcionCalculoEfectiva, Integer idTipoOpcionCalculoEstructura, Boolean horasOrigen, Boolean horasDestino) {
        TareaPersonaEstructuraDto estructura =
            delegate.estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraToTareaPersonaEstructuraDto(
                estructurasComResultItem, listaCondicionesBaseResultItem, listaCondicionesDestinoResultItem, tarea, ordinalEstructura, idTipoOpcionCalculoEfectiva, idTipoOpcionCalculoEstructura, horasOrigen, horasDestino);
        setActivo(estructura);
        return estructura;
    }

    @Override
    public TareaPersonaEstructuraDto estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(EstructurasComResultItemDto estructurasComResultItem, ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItem, ListaCondicionesDestinoResultItemDto listaCondicionesDestinoResultItem, ListaValoresDestinoResultItemDto listaValoresDestinoResultItem, TareaDto tarea, Integer ordinalEstructura, Integer idTipoOpcionCalculoEfectiva, Integer idTipoOpcionCalculoEstructura, Integer idSeccion, Boolean horasOrigen, Boolean horasDestino) {
        TareaPersonaEstructuraDto estructura = delegate.estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
            estructurasComResultItem, listaCondicionesBaseResultItem, listaCondicionesDestinoResultItem, listaValoresDestinoResultItem, tarea, ordinalEstructura, idTipoOpcionCalculoEfectiva, idTipoOpcionCalculoEstructura, idSeccion, horasOrigen, horasDestino);
        setActivo(estructura);
        return estructura;
    }

    private void setActivo(TareaPersonaEstructuraDto estructura) {
        //Por defecto se desactivan todas aquellas estructuras que sean tramadas (las que tengan topes)
        estructura.setActivo(AppConstants.TOPE_DEFAULT.equals(estructura.getTope()));
    }

    @Override
    public List<TareaPersonaEstructura> tareaPersonaEstructuraDtoToTareaPersonaEstructura(
        List<TareaPersonaEstructuraDto> src) {
        List<TareaPersonaEstructura> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(estructura -> result.add(tareaPersonaEstructuraDtoToTareaPersonaEstructura(estructura)));
        }
        return result;
    }
    
    @Override
    public List<TareaPersonaEstructuraDto> estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(
            final List<EstructurasComResultItemDto> estructurasComResultItem, final TareaDto tarea) {
        List<TareaPersonaEstructuraDto> result = new ArrayList<>();
        estructurasComResultItem.forEach(itemPadre -> {
            /*-----------------*/
            /* Estructura base */
            /*-----------------*/
            if (CollectionUtils.isNotEmpty(itemPadre.getIcmListaCondicionesBase())) {
                ListaCondicionesBaseResultItemDto itemBase = itemPadre.getIcmListaCondicionesBase().get(0);
                if(StringUtils.isEmpty(itemBase.getIdTipoCalculo())) {
                    itemBase.setIdTipoCalculo(TipoCalculoEnum.NINGUNO.getId());
                }
                if (CollectionUtils.isEmpty(itemPadre.getIcmListaCondicionesBase().get(0).getIcmListaValoresBase())) {
                    result.add(estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndTareaToTareaPersonaEstructuraDto(itemPadre, itemBase, tarea));
                } else {
                    itemBase.getIcmListaValoresBase().forEach(itemBaseValor -> {
                        Integer itemBaseValorSeccion = Integer.valueOf(itemBaseValor.getIdSeccion());
                        if (AppConstants.SECCION_4.equals(itemBaseValorSeccion)) {
                            for (Integer itemBaseValorSeccionFicticia : AppConstants.SECCIONES) {
                                result.add(estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaValoresBaseResultItemDtoAndIdSerccionAndTareaToTareaPersonaEstructuraDto(itemPadre, itemBase, itemBaseValor, itemBaseValorSeccionFicticia, tarea));
                            }
                        } else {
                            result.add(estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaValoresBaseResultItemDtoAndIdSerccionAndTareaToTareaPersonaEstructuraDto(itemPadre, itemBase, itemBaseValor, itemBaseValorSeccion, tarea));
                        }
                  });
                }
                /*---------------------------*/
                /* Estructura desplazamiento */
                /*---------------------------*/
                if (CollectionUtils.isNotEmpty(itemPadre.getIcmListaCondicionesDestino())) {
                    AtomicInteger counter = new AtomicInteger(0);
                    itemPadre.getIcmListaCondicionesDestino().forEach(itemDesplazamiento -> {
                        TipoOpcionCalculoEnum opcion = TipoOpcionCalculoEnum.fromIdMeta4(itemDesplazamiento.getIdTipoOpCalculo());
                        if(StringUtils.isEmpty(itemDesplazamiento.getIdTipoCalculo())) {
                            itemDesplazamiento.setIdTipoCalculo(TipoCalculoEnum.NINGUNO.getId());
                        }
                        if (CollectionUtils.isEmpty(itemDesplazamiento.getIcmListaValoresDestino())) {
                            if (TipoOpcionCalculoEnum.MEJOR_OPCION.equals(opcion)) {
                                result.add(estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraToTareaPersonaEstructuraDto(itemPadre, itemBase, itemDesplazamiento, tarea, counter.incrementAndGet(), TipoOpcionCalculoEnum.ORIGEN.getId(), opcion.getId(), Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasOrigen()), Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasDestino())));
                                result.add(estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraToTareaPersonaEstructuraDto(itemPadre, itemBase, itemDesplazamiento, tarea, counter.incrementAndGet(), TipoOpcionCalculoEnum.DESTINO.getId(), opcion.getId(), Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasOrigen()), Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasDestino())));
                            } else {
                                result.add(estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraToTareaPersonaEstructuraDto(itemPadre, itemBase, itemDesplazamiento, tarea, counter.incrementAndGet(), opcion.getId(), opcion.getId(), Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasOrigen()), Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasDestino())));
                            }
                        } else {
                            itemDesplazamiento.getIcmListaValoresDestino().forEach(itemDesplazamientoValor -> {
                                Integer itemDesplazamientoValorSeccion = Integer.valueOf(itemDesplazamientoValor.getIdSeccion());
                                if (AppConstants.SECCION_4.equals(itemDesplazamientoValorSeccion)) {
                                    for (Integer itemBaseValorSeccionFicticia : AppConstants.SECCIONES) {
                                        if (TipoOpcionCalculoEnum.MEJOR_OPCION.equals(opcion)) {
                                            result.add(estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(itemPadre, itemBase, itemDesplazamiento, itemDesplazamientoValor, tarea, counter.incrementAndGet(), TipoOpcionCalculoEnum.ORIGEN.getId(), opcion.getId(), itemBaseValorSeccionFicticia, Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasOrigen()), Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasDestino())));
                                            result.add(estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(itemPadre, itemBase, itemDesplazamiento, itemDesplazamientoValor, tarea, counter.incrementAndGet(), TipoOpcionCalculoEnum.DESTINO.getId(), opcion.getId(), itemBaseValorSeccionFicticia, Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasOrigen()), Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasDestino())));
                                        } else {
                                            result.add(estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(itemPadre, itemBase, itemDesplazamiento, itemDesplazamientoValor, tarea, counter.incrementAndGet(), opcion.getId(), opcion.getId(), itemBaseValorSeccionFicticia, Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasOrigen()), Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasDestino())));
                                        }
                                    }
                                } else {
                                    if (TipoOpcionCalculoEnum.MEJOR_OPCION.equals(opcion)) {
                                        result.add(estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(itemPadre, itemBase, itemDesplazamiento, itemDesplazamientoValor, tarea, counter.incrementAndGet(), TipoOpcionCalculoEnum.ORIGEN.getId(), opcion.getId(), itemDesplazamientoValorSeccion, Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasOrigen()), Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasDestino())));
                                        result.add(estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(itemPadre, itemBase, itemDesplazamiento, itemDesplazamientoValor, tarea, counter.incrementAndGet(), TipoOpcionCalculoEnum.DESTINO.getId(), opcion.getId(), itemDesplazamientoValorSeccion, Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasOrigen()), Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasDestino())));
                                    } else {
                                        result.add(estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(itemPadre, itemBase, itemDesplazamiento, itemDesplazamientoValor, tarea, counter.incrementAndGet(), opcion.getId(), opcion.getId(), itemDesplazamientoValorSeccion, Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasOrigen()), Meta4Constants.TRUE.equals(itemDesplazamiento.getHorasDestino())));
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
    
}
