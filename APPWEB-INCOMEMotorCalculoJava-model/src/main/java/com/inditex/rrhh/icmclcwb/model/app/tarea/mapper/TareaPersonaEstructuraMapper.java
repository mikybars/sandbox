package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaCondicionesBaseResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaCondicionesDestinoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaValoresBaseResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaValoresDestinoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPersonaEstructuraMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = {org.apache.commons.lang3.StringUtils.class,
    com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants.class})
@DecoratedWith(value = TareaPersonaEstructuraMapperDecorator.class)
public abstract class TareaPersonaEstructuraMapper {

  @Mapping(target = "estructuraDesplazamiento", ignore = true)
  @Mapping(target = "id", source = "pk.id")
  @Mapping(target = "idTarea", source = "tarea.id")
  @Mapping(target = "fechaInicioPeriodo", source = "pk.fechaInicioPeriodo")
  @Mapping(target = "grupoManual", source = "icmGrupoManual")
  public abstract TareaPersonaEstructuraDto tareaPersonaEstructuraToTareaPersonaEstructuraDto(
      TareaPersonaEstructura src);

  public abstract List<TareaPersonaEstructuraDto> tareaPersonaEstructuraToTareaPersonaEstructuraDto(
      List<TareaPersonaEstructura> src);

  @InheritInverseConfiguration
  @Mapping(target = "tarea", ignore = true)
  @Mapping(target = "presupuesto", ignore = true)
  public abstract TareaPersonaEstructura tareaPersonaEstructuraDtoToTareaPersonaEstructura(
      TareaPersonaEstructuraDto src);

  public List<TareaPersonaEstructura> tareaPersonaEstructuraDtoToTareaPersonaEstructura(
      final List<TareaPersonaEstructuraDto> src) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  public List<TareaPersonaEstructuraDto> estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(
      final List<EstructurasComResultItemDto> estructurasComResultItem, final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "idTarea", source = "tarea.id")
  @Mapping(target = "activo", constant = "true")
  @Mapping(target = "fechaInicioPeriodo", source = "tarea.fechaInicioPeriodo")
  // Desplazamiento
  @Mapping(target = "desplazamiento",
      expression = "java(estructurasComResultItem.getIcmListaCondicionesDestino().isEmpty() ? false : true)")
  @Mapping(target = "desplazamientoBase",
      expression = "java(estructurasComResultItem.getIcmListaCondicionesDestino().isEmpty() ? false : true)")
  // Datos padre
  @Mapping(target = "cclIdOrigen", source = "estructurasComResultItem.idOrigen")
  @Mapping(target = "stdIdHr", source = "estructurasComResultItem.idEmpleado")
  @Mapping(target = "stdOrHrPeriod", source = "estructurasComResultItem.orEmpleado")
  @Mapping(target = "cclIdPerson", source = "estructurasComResultItem.idEmpleadoLocal")
  @Mapping(target = "fechaInicio", source = "estructurasComResultItem.fechaInicio")
  @Mapping(target = "fechaFin", source = "estructurasComResultItem.fechaFin")
  @Mapping(target = "icmIdTpEstructura", source = "estructurasComResultItem.idTpEstructura")
  @Mapping(target = "icmIdEstrComisionPadre", source = "estructurasComResultItem.idEstructura")
  @Mapping(target = "ordinalEstructura", ignore = true)
  // Valores
  @Mapping(target = "icmIdEstrComisionBase", source = "listaCondicionesBaseResultItem.idEstructuraBase")
  @Mapping(target = "icmIdEstrComision", source = "listaCondicionesBaseResultItem.idEstructuraBase")
  @Mapping(target = "icmIdTpCalculo", source = "listaCondicionesBaseResultItem.idTipoCalculo", defaultValue = "000")
  @Mapping(target = "icmIdTpComision", source = "listaCondicionesBaseResultItem.idTipoComision")
  @Mapping(target = "diaL",
      expression = "java(listaCondicionesBaseResultItem.getDiaL() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesBaseResultItem.getDiaL()) : null)")
  @Mapping(target = "diaM",
      expression = "java(listaCondicionesBaseResultItem.getDiaM() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesBaseResultItem.getDiaM()) : null)")
  @Mapping(target = "diaX",
      expression = "java(listaCondicionesBaseResultItem.getDiaX() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesBaseResultItem.getDiaX()) : null)")
  @Mapping(target = "diaJ",
      expression = "java(listaCondicionesBaseResultItem.getDiaJ() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesBaseResultItem.getDiaJ()) : null)")
  @Mapping(target = "diaV",
      expression = "java(listaCondicionesBaseResultItem.getDiaV() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesBaseResultItem.getDiaV()) : null)")
  @Mapping(target = "diaS",
      expression = "java(listaCondicionesBaseResultItem.getDiaS() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesBaseResultItem.getDiaS()) : null)")
  @Mapping(target = "diaD",
      expression = "java(listaCondicionesBaseResultItem.getDiaD() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesBaseResultItem.getDiaD()) : null)")
  @Mapping(target = "festivo",
      expression = "java(listaCondicionesBaseResultItem.getFestivo() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesBaseResultItem.getFestivo()) : null)")
  // Valores por seccion
  @Mapping(target = "valor", constant = "0")
  @Mapping(target = "grupoManual", constant = "")
  @Mapping(target = "cclIdSeccionEfectiva", constant = "0")
  @Mapping(target = "cclIdSeccionEstructura", constant = "0")
  @Mapping(target = "tope", constant = "0")
  // Datos del desplazamiento
  @Mapping(target = "estructuraDesplazamiento", ignore = true)
  public abstract TareaPersonaEstructuraDto estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndTareaToTareaPersonaEstructuraDto(
      final EstructurasComResultItemDto estructurasComResultItem,
      final ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItem, final TareaDto tarea);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "idTarea", source = "tarea.id")
  @Mapping(target = "activo", constant = "true")
  @Mapping(target = "fechaInicioPeriodo", source = "tarea.fechaInicioPeriodo")
  // Desplazamiento
  @Mapping(target = "desplazamiento",
      expression = "java(estructurasComResultItem.getIcmListaCondicionesDestino().isEmpty() ? false : true)")
  @Mapping(target = "desplazamientoBase",
      expression = "java(estructurasComResultItem.getIcmListaCondicionesDestino().isEmpty() ? false : true)")
  // Datos padre
  @Mapping(target = "cclIdOrigen", source = "estructurasComResultItem.idOrigen")
  @Mapping(target = "stdIdHr", source = "estructurasComResultItem.idEmpleado")
  @Mapping(target = "stdOrHrPeriod", source = "estructurasComResultItem.orEmpleado")
  @Mapping(target = "cclIdPerson", source = "estructurasComResultItem.idEmpleadoLocal")
  @Mapping(target = "fechaInicio", source = "estructurasComResultItem.fechaInicio")
  @Mapping(target = "fechaFin", source = "estructurasComResultItem.fechaFin")
  @Mapping(target = "icmIdTpEstructura", source = "estructurasComResultItem.idTpEstructura")
  @Mapping(target = "icmIdEstrComisionPadre", source = "estructurasComResultItem.idEstructura")
  @Mapping(target = "ordinalEstructura", ignore = true)
  // Valores
  @Mapping(target = "icmIdEstrComisionBase", source = "listaCondicionesBaseResultItem.idEstructuraBase")
  @Mapping(target = "icmIdEstrComision", source = "listaCondicionesBaseResultItem.idEstructuraBase")
  @Mapping(target = "icmIdTpCalculo", source = "listaCondicionesBaseResultItem.idTipoCalculo", defaultValue = "000")
  @Mapping(target = "icmIdTpComision", source = "listaCondicionesBaseResultItem.idTipoComision")
  @Mapping(target = "diaL",
      expression = "java(listaCondicionesBaseResultItem.getDiaL() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesBaseResultItem.getDiaL()) : null)")
  @Mapping(target = "diaM",
      expression = "java(listaCondicionesBaseResultItem.getDiaM() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesBaseResultItem.getDiaM()) : null)")
  @Mapping(target = "diaX",
      expression = "java(listaCondicionesBaseResultItem.getDiaX() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesBaseResultItem.getDiaX()) : null)")
  @Mapping(target = "diaJ",
      expression = "java(listaCondicionesBaseResultItem.getDiaJ() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesBaseResultItem.getDiaJ()) : null)")
  @Mapping(target = "diaV",
      expression = "java(listaCondicionesBaseResultItem.getDiaV() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesBaseResultItem.getDiaV()) : null)")
  @Mapping(target = "diaS",
      expression = "java(listaCondicionesBaseResultItem.getDiaS() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesBaseResultItem.getDiaS()) : null)")
  @Mapping(target = "diaD",
      expression = "java(listaCondicionesBaseResultItem.getDiaD() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesBaseResultItem.getDiaD()) : null)")
  @Mapping(target = "festivo",
      expression = "java(listaCondicionesBaseResultItem.getFestivo() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesBaseResultItem.getFestivo()) : null)")
  // Valores por seccion
  @Mapping(target = "cclIdSeccionEfectiva", source = "idSeccion", defaultValue = "0")
  @Mapping(target = "grupoManual", source = "listaValoresBaseResultItem.grupoManual", defaultValue = "")
  @Mapping(target = "valor", source = "listaValoresBaseResultItem.valor", defaultValue = "0")
  @Mapping(target = "cclIdSeccionEstructura", source = "listaValoresBaseResultItem.idSeccion", defaultValue = "0")
  @Mapping(target = "tope", source = "listaValoresBaseResultItem.tope", defaultValue = "0")
  // Datos del desplazamiento
  @Mapping(target = "estructuraDesplazamiento", ignore = true)
  public abstract TareaPersonaEstructuraDto estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaValoresBaseResultItemDtoAndIdSerccionAndTareaToTareaPersonaEstructuraDto(
      final EstructurasComResultItemDto estructurasComResultItem,
      final ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItem,
      final ListaValoresBaseResultItemDto listaValoresBaseResultItem, final Integer idSeccion,
      final TareaDto tarea);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "idTarea", source = "tarea.id")
  @Mapping(target = "activo", constant = "true")
  @Mapping(target = "fechaInicioPeriodo", source = "tarea.fechaInicioPeriodo")
  // Desplazamiento
  @Mapping(target = "desplazamiento", constant = "true")
  @Mapping(target = "desplazamientoBase", constant = "false")
  // Datos padre
  @Mapping(target = "cclIdOrigen", source = "estructurasComResultItem.idOrigen")
  @Mapping(target = "stdIdHr", source = "estructurasComResultItem.idEmpleado")
  @Mapping(target = "stdOrHrPeriod", source = "estructurasComResultItem.orEmpleado")
  @Mapping(target = "cclIdPerson", source = "estructurasComResultItem.idEmpleadoLocal")
  @Mapping(target = "fechaInicio", source = "estructurasComResultItem.fechaInicio")
  @Mapping(target = "fechaFin", source = "estructurasComResultItem.fechaFin")
  @Mapping(target = "icmIdTpEstructura", source = "estructurasComResultItem.idTpEstructura")
  @Mapping(target = "icmIdEstrComisionPadre", source = "estructurasComResultItem.idEstructura")
  @Mapping(target = "ordinalEstructura", source = "ordinalEstructura")
  // Valores
  @Mapping(target = "icmIdEstrComisionBase", source = "listaCondicionesBaseResultItem.idEstructuraBase")
  @Mapping(target = "icmIdEstrComision", source = "listaCondicionesDestinoResultItem.idEstructuraDestino")
  @Mapping(target = "icmIdTpCalculo", source = "listaCondicionesDestinoResultItem.idTipoCalculo",
      defaultValue = "000")
  @Mapping(target = "icmIdTpComision", source = "listaCondicionesDestinoResultItem.idTipoComision")
  @Mapping(target = "diaL",
      expression = "java(listaCondicionesDestinoResultItem.getDiaL() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesDestinoResultItem.getDiaL()) : null)")
  @Mapping(target = "diaM",
      expression = "java(listaCondicionesDestinoResultItem.getDiaM() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesDestinoResultItem.getDiaM()) : null)")
  @Mapping(target = "diaX",
      expression = "java(listaCondicionesDestinoResultItem.getDiaX() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesDestinoResultItem.getDiaX()) : null)")
  @Mapping(target = "diaJ",
      expression = "java(listaCondicionesDestinoResultItem.getDiaJ() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesDestinoResultItem.getDiaJ()) : null)")
  @Mapping(target = "diaV",
      expression = "java(listaCondicionesDestinoResultItem.getDiaV() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesDestinoResultItem.getDiaV()) : null)")
  @Mapping(target = "diaS",
      expression = "java(listaCondicionesDestinoResultItem.getDiaS() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesDestinoResultItem.getDiaS()) : null)")
  @Mapping(target = "diaD",
      expression = "java(listaCondicionesDestinoResultItem.getDiaD() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesDestinoResultItem.getDiaD()) : null)")
  @Mapping(target = "festivo",
      expression = "java(listaCondicionesDestinoResultItem.getFestivo() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesDestinoResultItem.getFestivo()) : null)")
  // Valores por seccion
  @Mapping(target = "valor", constant = "0")
  @Mapping(target = "grupoManual", constant = "")
  @Mapping(target = "cclIdSeccionEfectiva", constant = "0")
  @Mapping(target = "cclIdSeccionEstructura", constant = "0")
  @Mapping(target = "tope", constant = "0")
  // Datos del desplazamiento
  @Mapping(target = "estructuraDesplazamiento.idTarea", source = "tarea.id")
  @Mapping(target = "estructuraDesplazamiento.activo", constant = "true")
  @Mapping(target = "estructuraDesplazamiento.ordinalEstructura", source = "ordinalEstructura")
  @Mapping(target = "estructuraDesplazamiento.fechaInicio", source = "estructurasComResultItem.fechaInicio")
  @Mapping(target = "estructuraDesplazamiento.fechaFin", source = "estructurasComResultItem.fechaFin")
  @Mapping(target = "estructuraDesplazamiento.cclIdOrigen", source = "estructurasComResultItem.idOrigen")
  @Mapping(target = "estructuraDesplazamiento.stdIdHr", source = "estructurasComResultItem.idEmpleado")
  @Mapping(target = "estructuraDesplazamiento.stdOrHrPeriod", source = "estructurasComResultItem.orEmpleado")
  @Mapping(target = "estructuraDesplazamiento.cclIdPerson", source = "estructurasComResultItem.idEmpleadoLocal")
  @Mapping(target = "estructuraDesplazamiento.icmIdEstrComisionPadre",
      source = "estructurasComResultItem.idEstructura")
  @Mapping(target = "estructuraDesplazamiento.icmIdEstrComisionBase",
      source = "listaCondicionesBaseResultItem.idEstructuraBase")
  @Mapping(target = "estructuraDesplazamiento.idTipoOpcionCalculoEfectiva", source = "idTipoOpcionCalculoEfectiva")
  @Mapping(target = "estructuraDesplazamiento.idTipoOpcionCalculoEstructura",
      source = "idTipoOpcionCalculoEstructura")
  @Mapping(target = "estructuraDesplazamiento.stdIdWorkLocatDestino",
      source = "listaCondicionesDestinoResultItem.idLugarTrabajoDestino")
  @Mapping(target = "estructuraDesplazamiento.cclIdCodOrigenDestino",
      source = "listaCondicionesDestinoResultItem.idLugarTrabajoDestinoMtu")
  @Mapping(target = "estructuraDesplazamiento.idMotivoDesplazamiento",
      source = "listaCondicionesDestinoResultItem.idMotivoDesplazamiento")
  @Mapping(target = "estructuraDesplazamiento.cclIdPuestoDestino",
      source = "listaCondicionesDestinoResultItem.idPuestoDestino")
  @Mapping(target = "estructuraDesplazamiento.cclIdSeccionDestino",
      source = "listaCondicionesDestinoResultItem.idSeccionDestino")
  @Mapping(target = "estructuraDesplazamiento.icmIdTpReqCom",
      source = "listaCondicionesDestinoResultItem.idTipoReqComision")
  @Mapping(target = "estructuraDesplazamiento.icmIdEstrComision",
      source = "listaCondicionesDestinoResultItem.idEstructuraDestino")
  // TODO: reactivar este flag cuando sepamos qué hacer con él
  @Mapping(target = "estructuraDesplazamiento.totalCondiciones", constant = "false")
  @Mapping(target = "estructuraDesplazamiento.horasOrigen", source = "horasOrigen")
  @Mapping(target = "estructuraDesplazamiento.horasDestino", source = "horasDestino")
  @Mapping(target = "estructuraDesplazamiento.icmIdEstructuraAmbito",
      source = "listaCondicionesDestinoResultItem.idEstructuraAmbito")
  @Mapping(target = "estructuraDesplazamiento.fechaInicioPeriodo", source = "tarea.fechaInicioPeriodo")
  public abstract TareaPersonaEstructuraDto estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraToTareaPersonaEstructuraDto(
      final EstructurasComResultItemDto estructurasComResultItem,
      final ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItem,
      final ListaCondicionesDestinoResultItemDto listaCondicionesDestinoResultItem, final TareaDto tarea,
      final Integer ordinalEstructura,
      final Integer idTipoOpcionCalculoEfectiva, final Integer idTipoOpcionCalculoEstructura,
      final Boolean horasOrigen, final Boolean horasDestino, final Boolean totalCondiciones);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "idTarea", source = "tarea.id")
  @Mapping(target = "activo", constant = "true")
  @Mapping(target = "fechaInicioPeriodo", source = "tarea.fechaInicioPeriodo")
  // Desplazamiento
  @Mapping(target = "desplazamiento", constant = "true")
  @Mapping(target = "desplazamientoBase", constant = "false")
  // Datos padre
  @Mapping(target = "cclIdOrigen", source = "estructurasComResultItem.idOrigen")
  @Mapping(target = "stdIdHr", source = "estructurasComResultItem.idEmpleado")
  @Mapping(target = "stdOrHrPeriod", source = "estructurasComResultItem.orEmpleado")
  @Mapping(target = "cclIdPerson", source = "estructurasComResultItem.idEmpleadoLocal")
  @Mapping(target = "fechaInicio", source = "estructurasComResultItem.fechaInicio")
  @Mapping(target = "fechaFin", source = "estructurasComResultItem.fechaFin")
  @Mapping(target = "icmIdTpEstructura", source = "estructurasComResultItem.idTpEstructura")
  @Mapping(target = "icmIdEstrComisionPadre", source = "estructurasComResultItem.idEstructura")
  @Mapping(target = "ordinalEstructura", source = "ordinalEstructura")
  // Valores
  @Mapping(target = "icmIdEstrComisionBase", source = "listaCondicionesBaseResultItem.idEstructuraBase")
  @Mapping(target = "icmIdEstrComision", source = "listaCondicionesDestinoResultItem.idEstructuraDestino")
  @Mapping(target = "icmIdTpCalculo", source = "listaCondicionesDestinoResultItem.idTipoCalculo",
      defaultValue = "000")
  @Mapping(target = "icmIdTpComision", source = "listaCondicionesDestinoResultItem.idTipoComision")
  @Mapping(target = "diaL",
      expression = "java(listaCondicionesDestinoResultItem.getDiaL() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesDestinoResultItem.getDiaL()) : null)")
  @Mapping(target = "diaM",
      expression = "java(listaCondicionesDestinoResultItem.getDiaM() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesDestinoResultItem.getDiaM()) : null)")
  @Mapping(target = "diaX",
      expression = "java(listaCondicionesDestinoResultItem.getDiaX() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesDestinoResultItem.getDiaX()) : null)")
  @Mapping(target = "diaJ",
      expression = "java(listaCondicionesDestinoResultItem.getDiaJ() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesDestinoResultItem.getDiaJ()) : null)")
  @Mapping(target = "diaV",
      expression = "java(listaCondicionesDestinoResultItem.getDiaV() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesDestinoResultItem.getDiaV()) : null)")
  @Mapping(target = "diaS",
      expression = "java(listaCondicionesDestinoResultItem.getDiaS() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesDestinoResultItem.getDiaS()) : null)")
  @Mapping(target = "diaD",
      expression = "java(listaCondicionesDestinoResultItem.getDiaD() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesDestinoResultItem.getDiaD()) : null)")
  @Mapping(target = "festivo",
      expression = "java(listaCondicionesDestinoResultItem.getFestivo() != null ?"
          + " Meta4Constants.TRUE.equals(listaCondicionesDestinoResultItem.getFestivo()) : null)")
  // Valores por seccion
  @Mapping(target = "cclIdSeccionEfectiva", source = "idSeccion", defaultValue = "0")
  @Mapping(target = "valor", source = "listaValoresDestinoResultItem.valor", defaultValue = "0")
  @Mapping(target = "grupoManual", source = "listaValoresDestinoResultItem.grupoManual")
  @Mapping(target = "cclIdSeccionEstructura", source = "listaValoresDestinoResultItem.idSeccion", defaultValue = "0")
  @Mapping(target = "tope", source = "listaValoresDestinoResultItem.tope", defaultValue = "0")
  // Datos del desplazamiento
  @Mapping(target = "estructuraDesplazamiento.idTarea", source = "tarea.id")
  @Mapping(target = "estructuraDesplazamiento.activo", constant = "true")
  @Mapping(target = "estructuraDesplazamiento.ordinalEstructura", source = "ordinalEstructura")
  @Mapping(target = "estructuraDesplazamiento.fechaInicio", source = "estructurasComResultItem.fechaInicio")
  @Mapping(target = "estructuraDesplazamiento.fechaFin", source = "estructurasComResultItem.fechaFin")
  @Mapping(target = "estructuraDesplazamiento.cclIdOrigen", source = "estructurasComResultItem.idOrigen")
  @Mapping(target = "estructuraDesplazamiento.stdIdHr", source = "estructurasComResultItem.idEmpleado")
  @Mapping(target = "estructuraDesplazamiento.stdOrHrPeriod", source = "estructurasComResultItem.orEmpleado")
  @Mapping(target = "estructuraDesplazamiento.cclIdPerson", source = "estructurasComResultItem.idEmpleadoLocal")
  @Mapping(target = "estructuraDesplazamiento.icmIdEstrComisionPadre",
      source = "estructurasComResultItem.idEstructura")
  @Mapping(target = "estructuraDesplazamiento.icmIdEstrComisionBase",
      source = "listaCondicionesBaseResultItem.idEstructuraBase")
  @Mapping(target = "estructuraDesplazamiento.idTipoOpcionCalculoEfectiva", source = "idTipoOpcionCalculoEfectiva")
  @Mapping(target = "estructuraDesplazamiento.idTipoOpcionCalculoEstructura",
      source = "idTipoOpcionCalculoEstructura")
  @Mapping(target = "estructuraDesplazamiento.stdIdWorkLocatDestino",
      source = "listaCondicionesDestinoResultItem.idLugarTrabajoDestino")
  @Mapping(target = "estructuraDesplazamiento.cclIdCodOrigenDestino",
      source = "listaCondicionesDestinoResultItem.idLugarTrabajoDestinoMtu")
  @Mapping(target = "estructuraDesplazamiento.idMotivoDesplazamiento",
      source = "listaCondicionesDestinoResultItem.idMotivoDesplazamiento")
  @Mapping(target = "estructuraDesplazamiento.cclIdPuestoDestino",
      source = "listaCondicionesDestinoResultItem.idPuestoDestino")
  @Mapping(target = "estructuraDesplazamiento.cclIdSeccionDestino",
      source = "listaCondicionesDestinoResultItem.idSeccionDestino")
  @Mapping(target = "estructuraDesplazamiento.icmIdTpReqCom",
      source = "listaCondicionesDestinoResultItem.idTipoReqComision")
  @Mapping(target = "estructuraDesplazamiento.icmIdEstrComision",
      source = "listaCondicionesDestinoResultItem.idEstructuraDestino")
  // TODO: reactivar este flag cuando sepamos qué hacer con él
  @Mapping(target = "estructuraDesplazamiento.totalCondiciones", constant = "false")
  @Mapping(target = "estructuraDesplazamiento.horasOrigen", source = "horasOrigen")
  @Mapping(target = "estructuraDesplazamiento.horasDestino", source = "horasDestino")
  @Mapping(target = "estructuraDesplazamiento.icmIdEstructuraAmbito",
      source = "listaCondicionesDestinoResultItem.idEstructuraAmbito")
  @Mapping(target = "estructuraDesplazamiento.fechaInicioPeriodo", source = "tarea.fechaInicioPeriodo")
  public abstract TareaPersonaEstructuraDto estructurasComResultItemDtoAndListaCondicionesBaseResultItemDtoAndListaCondicionesDestinoResultItemDtoAndListaValoresDestinoResultItemDtoAndTareaAndOrdinalEstructuraAndIdTipoOpcionCalculoEfectivaAndIdTipoOpcionCalculoEstructuraAndIdSeccionToTareaPersonaEstructuraDto(
      final EstructurasComResultItemDto estructurasComResultItem,
      final ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItem,
      final ListaCondicionesDestinoResultItemDto listaCondicionesDestinoResultItem,
      final ListaValoresDestinoResultItemDto listaValoresDestinoResultItem,
      final TareaDto tarea, final Integer ordinalEstructura, final Integer idTipoOpcionCalculoEfectiva,
      final Integer idTipoOpcionCalculoEstructura, final Integer idSeccion, final Boolean horasOrigen,
      final Boolean horasDestino, final Boolean totalCondiciones);

}
