package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoOpcionCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ListaEstructuraDesplazamientosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ListaPorcentajesResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoOpcionCalculo;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamiento;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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
    public List<TareaPersonaEstructuraDto> listaPorcentajesResultItemDtoToTareaPersonaEstructuraDto(
            List<ListaPorcentajesResultItemDto> src, ComisionEmpleadoResultItemDto comisionEmpleado, TareaDto tarea) {
        List<TareaPersonaEstructuraDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            List<TareaPersonaEstructuraDesplazamientoDto> desplazamientos =
                listaEstructuraDesplazamientosResultItemDtoToTareaPersonaEstructuraDesplazamientoDto(comisionEmpleado.getIcmListaEstrDespl());
            if (CollectionUtils.isNotEmpty(desplazamientos) && !Meta4Constants.TRUE.equals(comisionEmpleado.getDesplazamiento())) {
                log.warn("Datos inconsistentes sobre desplazamientos, la estructura base {} indica no tener desplazamientos, pero los tiene", comisionEmpleado.getIdEstructura());
            }
            if (CollectionUtils.isEmpty(desplazamientos) && Meta4Constants.TRUE.equals(comisionEmpleado.getDesplazamiento())) {
                log.warn("Datos inconsistentes sobre desplazamientos, la estructura base {} indica tener desplazamientos, pero no los tiene", comisionEmpleado.getIdEstructura());
            }
            src.forEach(x -> {
                // Se crea una estructura para la base sin desplazamientos y otra con los desplazamientos
                result.addAll(createTareaEmpleadoSeccionEstructuraDtoList(comisionEmpleado, tarea, x));
                if (CollectionUtils.isNotEmpty(desplazamientos)) {
                    result.addAll(createTareaEmpleadoSeccionEstructuraDtoList(comisionEmpleado, tarea, x, desplazamientos));
                    result.forEach(item -> item.setDesplazamientoBase(item.getEstructuraDesplazamiento() == null));
                }
            });
        }
        return result;
    }

    private List<TareaPersonaEstructuraDto> createTareaEmpleadoSeccionEstructuraDtoList(ComisionEmpleadoResultItemDto comisionEmpleado,
        TareaDto tarea, ListaPorcentajesResultItemDto porcentaje) {
        List<TareaPersonaEstructuraDto> result = new ArrayList<>();

        // Si la seccion es la 4 quiere decir que las tres secciones tienen el mismo
        // porcentaje, por lo que se crean las tres secciones por separado (se guarda el
        // original en id_seccion_estructura)
        Integer seccion = Integer.valueOf(porcentaje.getIdSeccion());
        if (AppConstants.SECCION_4.equals(seccion)) {
            for (Integer idSeccionEfectiva : AppConstants.SECCIONES) {
                result.add(createTareaEmpleadoSeccionEstructuraDto(idSeccionEfectiva.toString(),
                    porcentaje.getIdSeccion(), porcentaje.getPorcentaje(), comisionEmpleado, tarea));
            }
        } else {
            result.add(createTareaEmpleadoSeccionEstructuraDto(porcentaje.getIdSeccion(), porcentaje.getIdSeccion(),
                porcentaje.getPorcentaje(), comisionEmpleado, tarea));
        }
        return result;
    }

    private List<TareaPersonaEstructuraDto> createTareaEmpleadoSeccionEstructuraDtoList(ComisionEmpleadoResultItemDto comisionEmpleado,
            TareaDto tarea, ListaPorcentajesResultItemDto porcentaje, List<TareaPersonaEstructuraDesplazamientoDto> desplazamientos) {

        List<TareaPersonaEstructuraDto> result = new ArrayList<>();
        List<TareaPersonaEstructuraDto> secciones = createTareaEmpleadoSeccionEstructuraDtoList(comisionEmpleado, tarea, porcentaje);

        if (CollectionUtils.isNotEmpty(desplazamientos)) {
            // Para cada desplazamiento se genera una base y un desplazamiento
            for (int i = 0; i < desplazamientos.size(); i ++) {
                final int ordinal = i + 1;
                TareaPersonaEstructuraDesplazamientoDto desplazamiento = desplazamientos.get(i);
                    secciones.stream().filter(seccion -> seccion.getCclIdSeccionEfectiva().equals(desplazamiento.getCclIdSeccionEfectiva())).forEach(seccion -> {
                    TareaPersonaEstructuraDto clon = new TareaPersonaEstructuraDto();
                    BeanUtils.copyProperties(seccion, clon);
                    clon.setOrdinalEstructura(ordinal);
                    clon.setEstructuraDesplazamiento(desplazamiento);
                    result.add(clon);
                });
            }
        }

        return result;
    }

    @Override
    public List<TareaPersonaEstructuraDto> comisionEmpleadoResultItemDtoToTareaPersonaEstructuraDto(
            List<ComisionEmpleadoResultItemDto> src, TareaDto tarea) {
        List<TareaPersonaEstructuraDto> result = new ArrayList<>();
        src.forEach(x -> result.addAll(
                listaPorcentajesResultItemDtoToTareaPersonaEstructuraDto(x.getIcmListaPorcentajes(), x, tarea)));
        return result;
    }

    private TareaPersonaEstructuraDto createTareaEmpleadoSeccionEstructuraDto(final String idSeccionEfectiva,
            final String idSeccionEstructura, final String valor, final ComisionEmpleadoResultItemDto comisionEmpleado,
            final TareaDto tarea) {
        TareaPersonaEstructuraDto result = delegate
                .comisionEmpleadoResultItemDtoToTareaPersonaEstructuraDto(comisionEmpleado, tarea);
        result.setCclIdSeccionEfectiva(idSeccionEfectiva);
        result.setCclIdSeccionEstructura(idSeccionEstructura);
        result.setValor(valor);
        result.setDesplazamiento(Meta4Constants.TRUE.equals(comisionEmpleado.getDesplazamiento()));
        result.setDesplazamientoBase(false);
        return result;
    }

    @Override
    public List<TareaPersonaEstructuraDesplazamientoDto> listaEstructuraDesplazamientosResultItemDtoToTareaPersonaEstructuraDesplazamientoDto(
            List<ListaEstructuraDesplazamientosResultItemDto> src) {
        List<TareaPersonaEstructuraDesplazamientoDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(x -> {
                TipoOpcionCalculoEnum opcion = TipoOpcionCalculoEnum.fromIdMeta4(x.getIdTipoOpCalculo());
                if (TipoOpcionCalculoEnum.MEJOR_OPCION.equals(opcion)) {
                    result.addAll(createTareaEmpleadoEstructuraDesplazamientoDto(TipoOpcionCalculoEnum.ORIGEN, opcion, x));
                    result.addAll(createTareaEmpleadoEstructuraDesplazamientoDto(TipoOpcionCalculoEnum.DESTINO, opcion, x));
                } else {
                    result.addAll(createTareaEmpleadoEstructuraDesplazamientoDto(opcion, opcion, x));
                }
            });
        }
        return result;
    }

    private List<TareaPersonaEstructuraDesplazamientoDto> createTareaEmpleadoEstructuraDesplazamientoDto(
            final TipoOpcionCalculoEnum opcionCalculoEfectiva, final TipoOpcionCalculoEnum opcionCalculo,
            final ListaEstructuraDesplazamientosResultItemDto resultItemDto) {
        List<TareaPersonaEstructuraDesplazamientoDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(resultItemDto.getListaPorcentajes())) {
            resultItemDto.getListaPorcentajes().forEach(porcentaje -> {
                // Si la seccion es la 4 quiere decir que las tres secciones tienen el mismo
                // porcentaje, por lo que se crean las tres secciones por separado (se guarda el
                // original en id_seccion_estructura)
                Integer seccion = Integer.valueOf(porcentaje.getIdSeccion());
                if (AppConstants.SECCION_4.equals(seccion)) {
                    for (Integer idSeccionEfectiva : AppConstants.SECCIONES) {
                        result.add(createTareaPersonaEstructuraDesplazamientoDto(opcionCalculoEfectiva, opcionCalculo, resultItemDto,
                            seccion, idSeccionEfectiva, porcentaje.getPorcentaje()));
                    }
                } else {
                    result.add(createTareaPersonaEstructuraDesplazamientoDto(opcionCalculoEfectiva, opcionCalculo, resultItemDto,
                        seccion, seccion, porcentaje.getPorcentaje()));
                }
            });
        }
        return result;
    }

    private TareaPersonaEstructuraDesplazamientoDto createTareaPersonaEstructuraDesplazamientoDto(
            TipoOpcionCalculoEnum opcionCalculoEfectiva, TipoOpcionCalculoEnum opcionCalculo,
            ListaEstructuraDesplazamientosResultItemDto resultItemDto, Integer seccion, Integer seccionEfectiva, String valor) {
        TareaPersonaEstructuraDesplazamientoDto result = delegate
            .listaEstructuraDesplazamientosResultItemDtoToTareaPersonaEstructuraDesplazamientoDto(resultItemDto);
        result.setIdTipoOpcionCalculoEstructura(opcionCalculo.getId());
        result.setIdTipoOpcionCalculoEfectiva(opcionCalculoEfectiva.getId());
        result.setCclIdSeccionEfectiva(seccionEfectiva.toString());
        result.setCclIdSeccionEstructura(seccion.toString());
        result.setValor(valor);
        result.setHorasDestino(Meta4Constants.TRUE.equals(resultItemDto.getHorasDestino()));
        result.setHorasOrigen(Meta4Constants.TRUE.equals(resultItemDto.getHorasOrigen()));
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
