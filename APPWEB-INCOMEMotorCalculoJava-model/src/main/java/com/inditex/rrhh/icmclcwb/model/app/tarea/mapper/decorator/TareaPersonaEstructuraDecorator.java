package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoOpcionCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaCondicionesBaseResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaCondicionesDestinoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaValoresBaseResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaValoresDestinoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoOpcionCalculo;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamiento;

public abstract class TareaPersonaEstructuraDecorator extends TareaPersonaEstructuraMapper {

    @Autowired
    private TareaPersonaEstructuraMapper delegate;

    @Autowired
    private Logger log;

    @Override
    public TareaPersonaEstructura tareaPersonaEstructuraDtoToTareaPersonaEstructura(
        TareaPersonaEstructuraDto src) {
        TareaPersonaEstructura result = delegate.tareaPersonaEstructuraDtoToTareaPersonaEstructura(src);
        result.setTarea(new Tarea());
        result.getTarea().setId(src.getIdTarea());
        return result;
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
    public List<TareaPersonaEstructuraDto> listaCondicionesBaseResultItemDtoToTareaPersonaEstructuraDto(
            final EstructurasComResultItemDto estructuraComision,
            TareaDto tarea) {
        List<TareaPersonaEstructuraDto> result = new ArrayList<>();
        ListaCondicionesBaseResultItemDto base = estructuraComision.getIcmListaCondicionesBase().get(0);
        if (CollectionUtils.isNotEmpty(estructuraComision.getIcmListaCondicionesDestino())) {
            List<TareaPersonaEstructuraDesplazamientoDto> desplazamientos =
                    listaCondicionesDestinoResultItemDtoToTareaPersonaEstructuraDesplazamientoDto(estructuraComision);
            desplazamientos.forEach(item -> item.setIcmIdEstrComisionBase(base.getIdEstructuraBase()));
            if (CollectionUtils.isNotEmpty(desplazamientos)) {
                AtomicInteger counter = new AtomicInteger(1);
                desplazamientos.stream().forEach(x -> {
                    x.setOrdinalEstructura(counter.get());
                    
                    List<TareaPersonaEstructuraDto> desplazamientoBase = createTareaEmpleadoSeccionEstructuraDtoList(estructuraComision, tarea, base, null);
                    desplazamientoBase.forEach(item -> item.setDesplazamientoBase(true));
                    desplazamientoBase.forEach(item -> item.setDesplazamiento(true));
                    result.addAll(desplazamientoBase);

                    ListaCondicionesDestinoResultItemDto destino = estructuraComision.getIcmListaCondicionesDestino().stream().filter(y -> y.getIdEstructuraDestino().equals(x.getIcmIdEstrComision())).findAny().orElse(null);
                    List<TareaPersonaEstructuraDto> desplazamientoDestino = createTareaEmpleadoSeccionEstructuraDtoList(estructuraComision, tarea, destino, base, x);
                    desplazamientoDestino.forEach(item -> item.setOrdinalEstructura(counter.get()));
                    result.addAll(desplazamientoDestino);   
                    
                    counter.incrementAndGet();
                });
            }
        }else {
            result.addAll(createTareaEmpleadoSeccionEstructuraDtoList(estructuraComision, tarea, base, null));
        }   
        return result;
    }
    
    private List<TareaPersonaEstructuraDto> createTareaEmpleadoSeccionEstructuraDtoList(EstructurasComResultItemDto comisionEmpleado,
            TareaDto tarea, ListaCondicionesBaseResultItemDto condiciones, ListaCondicionesDestinoResultItemDto destino) {
        List<TareaPersonaEstructuraDto> result = new ArrayList<>();

        condiciones.getIcmListaValoresBase().forEach(x -> {
            Integer seccion = Integer.valueOf(x.getIdSeccion());
            if (AppConstants.SECCION_4.equals(seccion)) {
                for (Integer idSeccionEfectiva : AppConstants.SECCIONES) {
                    result.add(createTareaEmpleadoSeccionEstructuraDto(idSeccionEfectiva.toString(),
                        comisionEmpleado, condiciones, destino, x, tarea));
                }
            } else {
                result.add(createTareaEmpleadoSeccionEstructuraDto(comisionEmpleado, condiciones, destino, x, tarea));
            }
        });
        
        return result;    
    }
    
    private List<TareaPersonaEstructuraDto> createTareaEmpleadoSeccionEstructuraDtoList(EstructurasComResultItemDto comisionEmpleado,
            TareaDto tarea, ListaCondicionesDestinoResultItemDto condiciones, ListaCondicionesBaseResultItemDto base) {
        List<TareaPersonaEstructuraDto> result = new ArrayList<>();

        condiciones.getIcmListaValoresDestino().forEach(x -> {
            Integer seccion = Integer.valueOf(x.getIdSeccion());
            if (AppConstants.SECCION_4.equals(seccion)) {
                for (Integer idSeccionEfectiva : AppConstants.SECCIONES) {
                    result.add(createTareaEmpleadoSeccionEstructuraDto(idSeccionEfectiva.toString(),
                        comisionEmpleado, condiciones, base, x, tarea));
                }
            } else {
                result.add(createTareaEmpleadoSeccionEstructuraDto(comisionEmpleado, condiciones, base, x, tarea));
            }
        });
        
        return result;    
    }


    private List<TareaPersonaEstructuraDto> createTareaEmpleadoSeccionEstructuraDtoList(EstructurasComResultItemDto comisionEmpleado,
            TareaDto tarea, ListaCondicionesDestinoResultItemDto destino, ListaCondicionesBaseResultItemDto base, TareaPersonaEstructuraDesplazamientoDto desplazamiento) {
        List<TareaPersonaEstructuraDto> result = new ArrayList<>();
        List<TareaPersonaEstructuraDto> secciones = createTareaEmpleadoSeccionEstructuraDtoList(comisionEmpleado, tarea, destino, base);
        secciones.stream().forEach(seccion -> {
            TareaPersonaEstructuraDto clon = new TareaPersonaEstructuraDto();
            BeanUtils.copyProperties(seccion, clon);
            clon.setEstructuraDesplazamiento(desplazamiento);
            result.add(clon);
        });
        return result;
    }
    
    @Override
    public List<TareaPersonaEstructuraDto> estructurasComResultItemDtoToTareaPersonaEstructuraDto(
            List<EstructurasComResultItemDto> src, TareaDto tarea) {
        List<TareaPersonaEstructuraDto> result = new ArrayList<>();
        src.forEach(x -> result.addAll(
                listaCondicionesBaseResultItemDtoToTareaPersonaEstructuraDto(x, tarea)));
        return result;
    }
    
    private TareaPersonaEstructuraDto createTareaEmpleadoSeccionEstructuraDto(final String idSeccionEfectiva,
            final EstructurasComResultItemDto estructura,
            final ListaCondicionesBaseResultItemDto condiciones, final ListaCondicionesDestinoResultItemDto destino, ListaValoresBaseResultItemDto valores, final TareaDto tarea) {
        TareaPersonaEstructuraDto result = delegate
                .estructurasComResultItemDtoToTareaPersonaEstructuraDto(estructura, tarea);
        result.setCclIdSeccionEfectiva(idSeccionEfectiva);
        result.setCclIdSeccionEstructura(valores.getIdSeccion());
        result.setValor(valores.getValor());
        result.setTope(valores.getTope());
        result.setIdTipoVenta(valores.getIdTipoVenta());
        result.setDesplazamiento(!estructura.getIcmListaCondicionesDestino().isEmpty());
        result.setDesplazamientoBase(false);
        result.setDiaL(Meta4Constants.TRUE.equals(condiciones.getDiaL()));
        result.setDiaM(Meta4Constants.TRUE.equals(condiciones.getDiaM()));
        result.setDiaX(Meta4Constants.TRUE.equals(condiciones.getDiaX()));
        result.setDiaJ(Meta4Constants.TRUE.equals(condiciones.getDiaJ()));
        result.setDiaV(Meta4Constants.TRUE.equals(condiciones.getDiaV()));
        result.setDiaS(Meta4Constants.TRUE.equals(condiciones.getDiaS()));
        result.setDiaD(Meta4Constants.TRUE.equals(condiciones.getDiaD()));
        result.setIcmIdTpComision(condiciones.getIdTipoComision());
        result.setIcmIdTpCalculo(condiciones.getIdTipoCalculo());
        result.setIcmIdEstrComisionBase(condiciones.getIdEstructuraBase());
        result.setIcmIdEstrComision(destino != null ? destino.getIdEstructuraDestino() : condiciones.getIdEstructuraBase());
        result.setActivo(Boolean.TRUE);

        return result;
    }
    
    private TareaPersonaEstructuraDto createTareaEmpleadoSeccionEstructuraDto(
            final EstructurasComResultItemDto estructura,
            final ListaCondicionesBaseResultItemDto condiciones, final ListaCondicionesDestinoResultItemDto destino, ListaValoresBaseResultItemDto valores, final TareaDto tarea) {
        TareaPersonaEstructuraDto result = delegate
                .estructurasComResultItemDtoToTareaPersonaEstructuraDto(estructura, tarea);
        result.setCclIdSeccionEfectiva(valores.getIdSeccion());
        result.setCclIdSeccionEstructura(valores.getIdSeccion());
        result.setValor(valores.getValor());
        result.setTope(valores.getTope());
        result.setIdTipoVenta(valores.getIdTipoVenta());
        result.setDesplazamiento(!estructura.getIcmListaCondicionesDestino().isEmpty());
        result.setDesplazamientoBase(false);
        result.setDiaL(Meta4Constants.TRUE.equals(condiciones.getDiaL()));
        result.setDiaM(Meta4Constants.TRUE.equals(condiciones.getDiaM()));
        result.setDiaX(Meta4Constants.TRUE.equals(condiciones.getDiaX()));
        result.setDiaJ(Meta4Constants.TRUE.equals(condiciones.getDiaJ()));
        result.setDiaV(Meta4Constants.TRUE.equals(condiciones.getDiaV()));
        result.setDiaS(Meta4Constants.TRUE.equals(condiciones.getDiaS()));
        result.setDiaD(Meta4Constants.TRUE.equals(condiciones.getDiaD()));
        result.setIcmIdTpComision(condiciones.getIdTipoComision());
        result.setIcmIdTpCalculo(condiciones.getIdTipoCalculo());
        result.setIcmIdEstrComisionBase(condiciones.getIdEstructuraBase());
        result.setIcmIdEstrComision(destino != null ? destino.getIdEstructuraDestino() : condiciones.getIdEstructuraBase());
        result.setActivo(Boolean.TRUE);

        return result;
    }
    private TareaPersonaEstructuraDto createTareaEmpleadoSeccionEstructuraDto(final EstructurasComResultItemDto estructura,
            final ListaCondicionesDestinoResultItemDto condiciones, ListaCondicionesBaseResultItemDto base, ListaValoresDestinoResultItemDto valores, final TareaDto tarea) {
        TareaPersonaEstructuraDto result = delegate
                .estructurasComResultItemDtoToTareaPersonaEstructuraDto(estructura, tarea);
        result.setCclIdSeccionEfectiva(valores.getIdSeccion());
        result.setCclIdSeccionEstructura(valores.getIdSeccion());
        result.setValor(valores.getValor());
        result.setTope(valores.getTope());
        result.setIdTipoVenta(valores.getIdTipoVenta());
        result.setDesplazamiento(!estructura.getIcmListaCondicionesDestino().isEmpty());
        result.setDesplazamientoBase(false);
        result.setDiaL(Meta4Constants.TRUE.equals(condiciones.getDiaL()));
        result.setDiaM(Meta4Constants.TRUE.equals(condiciones.getDiaM()));
        result.setDiaX(Meta4Constants.TRUE.equals(condiciones.getDiaX()));
        result.setDiaJ(Meta4Constants.TRUE.equals(condiciones.getDiaJ()));
        result.setDiaV(Meta4Constants.TRUE.equals(condiciones.getDiaV()));
        result.setDiaS(Meta4Constants.TRUE.equals(condiciones.getDiaS()));
        result.setDiaD(Meta4Constants.TRUE.equals(condiciones.getDiaD()));
        result.setIcmIdTpComision(condiciones.getIdTipoComision());
        result.setIcmIdTpCalculo(condiciones.getIdTipoCalculo());
        result.setIcmIdEstrComisionBase(estructura.getIcmListaCondicionesBase().get(0).getIdEstructuraBase());
        result.setIcmIdEstrComision(condiciones != null ? condiciones.getIdEstructuraDestino() : base.getIdEstructuraBase());
        result.setActivo(Boolean.TRUE);
        return result;
    }
    
    private TareaPersonaEstructuraDto createTareaEmpleadoSeccionEstructuraDto(String idSeccionEfectiva, final EstructurasComResultItemDto estructura,
            final ListaCondicionesDestinoResultItemDto condiciones, ListaCondicionesBaseResultItemDto base, ListaValoresDestinoResultItemDto valores, final TareaDto tarea) {
        TareaPersonaEstructuraDto result = delegate
                .estructurasComResultItemDtoToTareaPersonaEstructuraDto(estructura, tarea);
        result.setCclIdSeccionEfectiva(idSeccionEfectiva);
        result.setCclIdSeccionEstructura(valores.getIdSeccion());
        result.setValor(valores.getValor());
        result.setTope(valores.getTope());
        result.setIdTipoVenta(valores.getIdTipoVenta());
        result.setDesplazamiento(!estructura.getIcmListaCondicionesDestino().isEmpty());
        result.setDesplazamientoBase(false);
        result.setDiaL(Meta4Constants.TRUE.equals(condiciones.getDiaL()));
        result.setDiaM(Meta4Constants.TRUE.equals(condiciones.getDiaM()));
        result.setDiaX(Meta4Constants.TRUE.equals(condiciones.getDiaX()));
        result.setDiaJ(Meta4Constants.TRUE.equals(condiciones.getDiaJ()));
        result.setDiaV(Meta4Constants.TRUE.equals(condiciones.getDiaV()));
        result.setDiaS(Meta4Constants.TRUE.equals(condiciones.getDiaS()));
        result.setDiaD(Meta4Constants.TRUE.equals(condiciones.getDiaD()));
        result.setIcmIdTpComision(condiciones.getIdTipoComision());
        result.setIcmIdTpCalculo(condiciones.getIdTipoCalculo());
        result.setIcmIdEstrComisionBase(estructura.getIcmListaCondicionesBase().get(0).getIdEstructuraBase());
        result.setIcmIdEstrComision(condiciones != null ? condiciones.getIdEstructuraDestino() : base.getIdEstructuraBase());
        result.setActivo(Boolean.TRUE);
        return result;
    }


    @Override
    public List<TareaPersonaEstructuraDesplazamientoDto> listaCondicionesDestinoResultItemDtoToTareaPersonaEstructuraDesplazamientoDto(EstructurasComResultItemDto src) {
        List<TareaPersonaEstructuraDesplazamientoDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src.getIcmListaCondicionesDestino())) {
            src.getIcmListaCondicionesDestino().forEach(x -> {
                TipoOpcionCalculoEnum opcion = TipoOpcionCalculoEnum.fromIdMeta4(x.getIdTipoOpCalculo());
                if (TipoOpcionCalculoEnum.MEJOR_OPCION.equals(opcion)) {
                    result.addAll(createTareaEmpleadoEstructuraDesplazamientoDto(TipoOpcionCalculoEnum.ORIGEN, opcion, x, src));
                    result.addAll(createTareaEmpleadoEstructuraDesplazamientoDto(TipoOpcionCalculoEnum.DESTINO, opcion, x, src));
                } else {
                    result.addAll(createTareaEmpleadoEstructuraDesplazamientoDto(opcion, opcion, x, src));
                }
            });
        }
        return result;
    }
    
    private List<TareaPersonaEstructuraDesplazamientoDto> createTareaEmpleadoEstructuraDesplazamientoDto(
            final TipoOpcionCalculoEnum opcionCalculoEfectiva, final TipoOpcionCalculoEnum opcionCalculo,
            final ListaCondicionesDestinoResultItemDto resultItemDto, final EstructurasComResultItemDto estructura) {
        List<TareaPersonaEstructuraDesplazamientoDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(resultItemDto.getIcmListaValoresDestino())) {
            resultItemDto.getIcmListaValoresDestino().forEach(valores -> {
                Integer seccion = Integer.valueOf(valores.getIdSeccion());
                if (AppConstants.SECCION_4.equals(seccion)) {
                    for (Integer idSeccionEfectiva : AppConstants.SECCIONES) {
                        result.add(createTareaPersonaEstructuraDesplazamientoDto(opcionCalculoEfectiva, opcionCalculo, resultItemDto,
                            idSeccionEfectiva, estructura));
                    }
                } else {
                    result.add(createTareaPersonaEstructuraDesplazamientoDto(opcionCalculoEfectiva, opcionCalculo, resultItemDto,
                        seccion, estructura));
                }
            });
        }
        return result;
    }

    private TareaPersonaEstructuraDesplazamientoDto createTareaPersonaEstructuraDesplazamientoDto(
            TipoOpcionCalculoEnum opcionCalculoEfectiva, TipoOpcionCalculoEnum opcionCalculo,
            ListaCondicionesDestinoResultItemDto resultItemDto, Integer seccion, EstructurasComResultItemDto estructura) {
        TareaPersonaEstructuraDesplazamientoDto result = delegate
            .listaCondicionesDestinoResultItemDtoToTareaPersonaEstructuraDesplazamientoDto(resultItemDto);
        result.setIdTipoOpcionCalculoEstructura(opcionCalculo.getId());
        result.setIdTipoOpcionCalculoEfectiva(opcionCalculoEfectiva.getId());
        result.setCclIdSeccionDestino(seccion.toString());
        result.setHorasDestino(Meta4Constants.TRUE.equals(resultItemDto.getHorasDestino()));
        result.setHorasOrigen(Meta4Constants.TRUE.equals(resultItemDto.getHorasOrigen()));
        result.setStdIdHr(estructura.getIdEmpleado());
        result.setStdOrHrPeriod(estructura.getOrEmpleado());
        result.setCclIdPerson(estructura.getIdEmpleadoLocal());
        result.setFechaFin(estructura.getFechaFin());
        result.setFechaInicio(estructura.getFechaInicio());
        result.setIcmIdEstrComisionPadre(estructura.getIdEstructura());
        return result;
    }

    @Override
    public TareaPersonaEstructuraDesplazamiento tareaPersonaEstructuraDtoToTareapersonaDesplazamiento(TareaPersonaEstructuraDto src) {
        TareaPersonaEstructuraDesplazamiento result = null;
        if (src.getEstructuraDesplazamiento() != null) {
            result = delegate.tareaPersonaEstructuraDtoToTareapersonaDesplazamiento(src);
            result.setTarea(new Tarea());
            result.getTarea().setId(src.getIdTarea());
            result.setTipoOpcionCalculoEstructura(new TipoOpcionCalculo());
            result.getTipoOpcionCalculoEstructura().setId(src.getEstructuraDesplazamiento().getIdTipoOpcionCalculoEstructura());
            result.setTipoOpcionCalculoEfectiva(new TipoOpcionCalculo());
            result.getTipoOpcionCalculoEfectiva().setId(src.getEstructuraDesplazamiento().getIdTipoOpcionCalculoEfectiva());
            result.setIcmIdEstrComision(src.getEstructuraDesplazamiento().getIcmIdEstrComision());
            result.setIcmIdEstructuraAmbito(src.getEstructuraDesplazamiento().getIcmIdEstructuraAmbito());
        }
        return result;
    }

    @Override
    public List<TareaPersonaEstructuraDesplazamiento> tareaPersonaEstructuraDtoToTareapersonaDesplazamiento(List<TareaPersonaEstructuraDto> src) {
        List<TareaPersonaEstructuraDesplazamiento> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(estructura -> {
                TareaPersonaEstructuraDesplazamiento desplazamiento = tareaPersonaEstructuraDtoToTareapersonaDesplazamiento(estructura);
                if (desplazamiento != null) {
                    result.add(desplazamiento);
                }
            });
        }
        return result;
    }
}
