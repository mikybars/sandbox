package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ABIERTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_CERRADO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IMPORTE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ABIERTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_IMPORTE_CERO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.util.RunUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class TareaLocalizacionAbiertaRepositoryCustomImplTest {

  private static final String SQL_SAVE_ABIERTO = "SQL SAVE ABIERTO TEST";

  private static final String SQL_SAVE_CERRADO = "SQL SAVE CERRADO TEST";

  private static final String SQL_TRASLADAR = "SQL TRALADAR TEST";

  private static final String SQL_COMPENSARL = "SQL COMPENSAR TEST";

  private static final String SQL_COMPENSAR_ONLINE_SECCION_CERRADA = "SQL COMPENSAR ONLINE SECCION CERRADA";

  private static final String SQL_UPDATE_ACTIVO_TRASLADADAS_SECCION = "SQL UPDATE ACTIVO TRASLADADAS SECCION";

  @Mock
  private RecolectarPropertiesDto recolectarProperties;

  @Mock
  private TipoDatoService tipoDatoService;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private TareaLocalizacionAbiertaRepositoryCustomImpl tareaLocalizacionAbiertaRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sql;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> params;

  @BeforeEach
  void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaLocalizacionAbiertaRepositoryCustom, "sqlSaveAbierto", SQL_SAVE_ABIERTO, true);
    FieldUtils.writeField(this.tareaLocalizacionAbiertaRepositoryCustom, "sqlSaveCerrado", SQL_SAVE_CERRADO, true);
    FieldUtils.writeField(this.tareaLocalizacionAbiertaRepositoryCustom, "sqlCompensar", SQL_COMPENSARL, true);
    FieldUtils.writeField(this.tareaLocalizacionAbiertaRepositoryCustom, "sqlTrasladar", SQL_TRASLADAR, true);
    FieldUtils.writeField(this.tareaLocalizacionAbiertaRepositoryCustom, "sqlCompensarOnlineSeccionCerrada",
        SQL_COMPENSAR_ONLINE_SECCION_CERRADA, true);
    FieldUtils.writeField(this.tareaLocalizacionAbiertaRepositoryCustom, "sqlUpdateActivoTrasladadasSeccion",
        SQL_UPDATE_ACTIVO_TRASLADADAS_SECCION, true);
  }

  @Test
  void saveAbiertoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(900L);
    final TrabajoDTO trabajo = mock(TrabajoDTO.class);

    this.tareaLocalizacionAbiertaRepositoryCustom.saveAbierto(tarea, trabajo);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sql.capture(), this.params.capture());
    assertEquals(SQL_SAVE_ABIERTO, this.sql.getValue());
    // Parametros de la consulta:
    // idTipoPresencia, idTarea, importe, excluidoCalculo, activo, nuevoAbierto,
    // idSeccion, idTipoGrupoDato
    assertEquals(8, this.params.getValue().getValues().size());
    // idTipoPresencia
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TIPO_MINUTOS));
    assertEquals(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA_LOCALIZACIONABIERTA.getId(),
        this.params.getValue().getValue(SQL_PARAM_ID_TIPO_MINUTOS));
    // nuevoAbierto
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_NUEVO_ABIERTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, this.params.getValue().getValue(SQL_PARAM_NUEVO_ABIERTO));
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), this.params.getValue().getValue(SQL_PARAM_ID_TAREA));
    // importe
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_IMPORTE));
    assertEquals(SQL_VALUE_IMPORTE_CERO, this.params.getValue().getValue(SQL_PARAM_IMPORTE));
    // idSeccion
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_SECCION));
    assertEquals(AppConstants.SECCION_4, this.params.getValue().getValue(SQL_PARAM_ID_SECCION));
    // excluidoCalculo
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_EXCLUIDO_CALCULO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, this.params.getValue().getValue(SQL_PARAM_EXCLUIDO_CALCULO));
    // activo
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, this.params.getValue().getValue(SQL_PARAM_ACTIVO));
    // idTipoGrupoDato
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
    assertEquals(TipoGrupoDatoEnum.VENTA_FISICA_LOCALIZACION.getId(),
        this.params.getValue().getValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
  }

  @Test
  void trasladarTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(900L);
    final List<Integer> idTipoImporteVentas = Arrays.asList(2001, 2002);

    this.tareaLocalizacionAbiertaRepositoryCustom.trasladar(tarea, idTipoImporteVentas);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sql.capture(), this.params.capture());
    assertEquals(SQL_TRASLADAR, this.sql.getValue());
    // parametros de la consulta: tiposDato, idTarea, cerrado, abierto, nuevoActivo, activo
    // idTipoDatoVentaIpodLocalizacion, idTipoDatoVentaIpodLocalizacionTrasladada
    // idTipoDatoVentaIpodLocalizacionSeccion, idTipoDatoVentaIpodLocalizacionSeccionTrasladada
    // idTipoDatoVentaSINTLocalizacion, idTipoDatoVentaSINTLocalizacionTrasladada
    // idTipoDatoVentaSINTLocalizacionSeccion, idTipoDatoVentaSINTLocalizacionSeccionTrasladada
    // idTipoDatoVentaEntregaTiendaLocalizacion, idTipoDatoVentaEntregaTiendaLocalizacionTrasladada
    // idTipoDatoVentaEntregaTiendaLocalizacionSeccion,
    // idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada
    // idTipoDatoVentaEntregaDomicilioLocalizacion,
    // idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada
    // idTipoDatoVentaEntregaDomicilioLocalizacionSeccion,
    // idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada
    assertEquals(23, this.params.getValue().getValues().size());
    // tiposDato
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_IDS_TIPOS_DATO));
    assertEquals(idTipoImporteVentas, this.params.getValue().getValue(SQL_PARAM_IDS_TIPOS_DATO));
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), this.params.getValue().getValue(SQL_PARAM_ID_TAREA));
    // cerrado
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_CERRADO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, this.params.getValue().getValue(SQL_PARAM_CERRADO));
    // abierto
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ABIERTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, this.params.getValue().getValue(SQL_PARAM_ABIERTO));
    // nuevoActivo
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_NUEVO_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, this.params.getValue().getValue(SQL_PARAM_NUEVO_ACTIVO));
    // activo
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, this.params.getValue().getValue(SQL_PARAM_ACTIVO));
    // idTipoDatoVentaIpodLocalizacion
    assertTrue(this.params.getValue().hasValue("idTipoDatoVentaIpodLocalizacion"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION.getId(),
        this.params.getValue().getValue("idTipoDatoVentaIpodLocalizacion"));
    // idTipoDatoVentaIpodLocalizacionSeccion
    assertTrue(this.params.getValue().hasValue("idTipoDatoVentaIpodLocalizacionSeccion"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
        this.params.getValue().getValue("idTipoDatoVentaIpodLocalizacionSeccion"));
    // idTipoDatoVentaSINTLocalizacion
    assertTrue(this.params.getValue().hasValue("idTipoDatoVentaSINTLocalizacion"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION.getId(),
        this.params.getValue().getValue("idTipoDatoVentaSINTLocalizacion"));
    // idTipoDatoVentaSINTLocalizacionSeccion
    assertTrue(this.params.getValue().hasValue("idTipoDatoVentaSINTLocalizacionSeccion"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId(),
        this.params.getValue().getValue("idTipoDatoVentaSINTLocalizacionSeccion"));
    // idTipoDatoVentaEntregaTiendaLocalizacion
    assertTrue(this.params.getValue().hasValue("idTipoDatoVentaEntregaTiendaLocalizacion"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId(),
        this.params.getValue().getValue("idTipoDatoVentaEntregaTiendaLocalizacion"));
    // idTipoDatoVentaEntregaTiendaLocalizacionSeccion
    assertTrue(this.params.getValue().hasValue("idTipoDatoVentaEntregaTiendaLocalizacionSeccion"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId(),
        this.params.getValue().getValue("idTipoDatoVentaEntregaTiendaLocalizacionSeccion"));
    // idTipoDatoVentaEntregaDomicilioLocalizacion
    assertTrue(this.params.getValue().hasValue("idTipoDatoVentaEntregaDomicilioLocalizacion"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId(),
        this.params.getValue().getValue("idTipoDatoVentaEntregaDomicilioLocalizacion"));
    // idTipoDatoVentaEntregaDomicilioLocalizacionSeccion
    assertTrue(this.params.getValue().hasValue("idTipoDatoVentaEntregaDomicilioLocalizacionSeccion"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId(),
        this.params.getValue().getValue("idTipoDatoVentaEntregaDomicilioLocalizacionSeccion"));
    // idTipoDatoVentaIpodLocalizacionTrasladada
    assertTrue(this.params.getValue().hasValue("idTipoDatoVentaIpodLocalizacionTrasladada"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_TRASLADADA_DIA.getId(),
        this.params.getValue().getValue("idTipoDatoVentaIpodLocalizacionTrasladada"));
    // idTipoDatoVentaIpodLocalizacionSeccionTrasladada
    assertTrue(this.params.getValue().hasValue("idTipoDatoVentaIpodLocalizacionSeccionTrasladada"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
        this.params.getValue().getValue("idTipoDatoVentaIpodLocalizacionSeccionTrasladada"));
    // idTipoDatoVentaSINTLocalizacionTrasladada
    assertTrue(this.params.getValue().hasValue("idTipoDatoVentaSINTLocalizacionTrasladada"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_TRASLADADA_DIA.getId(),
        this.params.getValue().getValue("idTipoDatoVentaSINTLocalizacionTrasladada"));
    // idTipoDatoVentaSINTLocalizacionSeccionTrasladada
    assertTrue(this.params.getValue().hasValue("idTipoDatoVentaSINTLocalizacionSeccionTrasladada"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
        this.params.getValue().getValue("idTipoDatoVentaSINTLocalizacionSeccionTrasladada"));
    // idTipoDatoVentaEntregaTiendaLocalizacionTrasladada
    assertTrue(this.params.getValue().hasValue("idTipoDatoVentaEntregaTiendaLocalizacionTrasladada"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_TRASLADADA_DIA.getId(),
        this.params.getValue().getValue("idTipoDatoVentaEntregaTiendaLocalizacionTrasladada"));
    // idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada
    assertTrue(this.params.getValue().hasValue("idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
        this.params.getValue().getValue("idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada"));
    // idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada
    assertTrue(this.params.getValue().hasValue("idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_TRASLADADA_DIA.getId(),
        this.params.getValue().getValue("idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada"));
    // idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada
    assertTrue(this.params.getValue().hasValue("idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
        this.params.getValue().getValue("idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada"));
  }

  @Test
  void compensarTest() {

    final LocalDate inicioPeriodo = LocalDate.of(2020, 1, 1);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(900L);
    when(tarea.getFechaInicioPeriodo()).thenReturn(inicioPeriodo);
    final List<Integer> idTipoImporteVentas = Arrays.asList(2001, 2002);

    this.tareaLocalizacionAbiertaRepositoryCustom.compensar(tarea, idTipoImporteVentas);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sql.capture(), this.params.capture());
    assertEquals(SQL_COMPENSARL, this.sql.getValue());
    // parametros de la consulta: tiposDato, idTarea, cerrado, nuevoActivo
    assertEquals(5, this.params.getValue().getValues().size());
    // tiposDato
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_IDS_TIPOS_DATO));
    assertEquals(idTipoImporteVentas, this.params.getValue().getValue(SQL_PARAM_IDS_TIPOS_DATO));
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), this.params.getValue().getValue(SQL_PARAM_ID_TAREA));
    // cerrado
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_CERRADO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, this.params.getValue().getValue(SQL_PARAM_CERRADO));
    // nuevoActivo
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_NUEVO_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, this.params.getValue().getValue(SQL_PARAM_NUEVO_ACTIVO));
    // fecha inicio periodo
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_FECHA_INICIO_PERIODO));
    assertEquals(TimeUtils.toDate(inicioPeriodo), this.params.getValue().getValue(SQL_PARAM_FECHA_INICIO_PERIODO));
  }

  @Test
  void saveCerradoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(6789L);
    final TrabajoDTO trabajo = mock(TrabajoDTO.class);
    final List<Integer> idTipoImporteVenta = Arrays.asList(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION.getId(),
        TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION.getId(),
        TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId(),
        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId());
    this.tareaLocalizacionAbiertaRepositoryCustom.saveCerrado(tarea, trabajo, idTipoImporteVenta);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sql.capture(), this.params.capture());
    assertEquals(SQL_SAVE_CERRADO, this.sql.getValue());
    // parametros de la consulta: tiposDato, idTarea, nuevoAbierto, idSeccion, activo, abierto
    assertEquals(6, this.params.getValue().getValues().size());
    // tiposDato
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_IDS_TIPOS_DATO));
    assertEquals(idTipoImporteVenta, this.params.getValue().getValue(SQL_PARAM_IDS_TIPOS_DATO));
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), this.params.getValue().getValue(SQL_PARAM_ID_TAREA));
    // nuevoAbierto
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_NUEVO_ABIERTO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, this.params.getValue().getValue(SQL_PARAM_NUEVO_ABIERTO));
    // idSeccion
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_SECCION));
    assertEquals(AppConstants.SECCION_4, this.params.getValue().getValue(SQL_PARAM_ID_SECCION));
    // activo
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, this.params.getValue().getValue(SQL_PARAM_ACTIVO));
    // abierto
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ABIERTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, this.params.getValue().getValue(SQL_PARAM_ABIERTO));
  }

  @Test
  void compensarOnlineSeccionCerradaTest(@Random final TareaDto tarea, @Random final TrabajoDTO trabajo,
      @Random(size = 2, type = IdTipoDatoDto.class) final List<IdTipoDatoDto> tiposDatoIpod,
      @Random(size = 2, type = IdTipoDatoDto.class) final List<IdTipoDatoDto> tiposDatoSint,
      @Random(size = 2, type = IdTipoDatoDto.class) final List<IdTipoDatoDto> tiposDatoEntregaTienda,
      @Random(size = 2, type = IdTipoDatoDto.class) final List<IdTipoDatoDto> tiposDatoEntregaDomicilio) {

    when(this.recolectarProperties.getDaysNumber()).thenReturn(3);
    when(this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION_COMPENSAR_SECCION_CERRADA.getId()))
            .thenReturn(tiposDatoIpod);
    when(this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION_COMPENSAR_SECCION_CERRADA.getId()))
            .thenReturn(tiposDatoSint);
    when(this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION_COMPENSAR_SECCION_CERRADA.getId()))
            .thenReturn(tiposDatoEntregaTienda);
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(
        TipoGrupoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION_COMPENSAR_SECCION_CERRADA.getId()))
            .thenReturn(tiposDatoEntregaDomicilio);

    this.tareaLocalizacionAbiertaRepositoryCustom.compensarOnlineSeccionCerrada(tarea, trabajo);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_COMPENSAR_ONLINE_SECCION_CERRADA), this.params.capture());

    final Map<String, Object> p = this.params.getValue().getValues();

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO, TimeUtils.toDate(trabajo.getFechaInicioPeriodo().toLocalDateTime()));
    expected.put(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN, RunUtils.addDays(trabajo.getFechaFinPeriodo().toLocalDateTime(),
        this.recolectarProperties.getDaysNumber(),
        "yyyy-MM-dd"));
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
        Arrays.asList(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
            TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION_TRASLADADA_DIA.getId()));
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_SECCION,
        Arrays.asList(AppConstants.SECCION_1, AppConstants.SECCION_2, AppConstants.SECCION_3));
    expected.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_FISICA_LOCALIZACION_SECCION,
        TipoDatoEnum.VENTA_FISICA_LOCALIZACION_SECCION.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_IPOD_LOCALIZACION_SECCION,
        tiposDatoIpod.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_SINT_LOCALIZACION_SECCION,
        tiposDatoSint.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_TIENDA_LOCALIZACION_SECCION,
        tiposDatoEntregaTienda.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION_SECCION,
        tiposDatoEntregaDomicilio.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_IPOD_LOCALIZACION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_TRASLADADA_SECCION.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_IPOD_LOCALIZACION_SECCION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION_TRASLADADA_SECCION.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_SINT_LOCALIZACION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_TRASLADADA_SECCION.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_SINT_LOCALIZACION_SECCION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION_TRASLADADA_SECCION.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_TIENDA_LOCALIZACION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_TRASLADADA_SECCION.getId());
    expected.put(
        SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_TIENDA_LOCALIZACION_SECCION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION_TRASLADADA_SECCION.getId());
    expected.put(
        SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_TRASLADADA_SECCION.getId());
    expected.put(
        SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION_SECCION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION_TRASLADADA_SECCION.getId());

    assertEquals(expected, p);

  }

  @Test
  void updateActivoTrasladadasSeccionTest(@Random final TareaDto tarea, @Random final TrabajoDTO trabajo) {
    this.tareaLocalizacionAbiertaRepositoryCustom.updateActivoTrasladadasSeccion(tarea, trabajo);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_UPDATE_ACTIVO_TRASLADADAS_SECCION), this.params.capture());

    final Map<String, Object> p = this.params.getValue().getValues();

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO, TimeUtils.toDate(trabajo.getFechaInicioPeriodo().toLocalDateTime()));
    expected.put(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN, RunUtils.addDays(trabajo.getFechaFinPeriodo().toLocalDateTime(),
        this.recolectarProperties.getDaysNumber(),
        "yyyy-MM-dd"));
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_SECCION,
        Arrays.asList(AppConstants.SECCION_1, AppConstants.SECCION_2, AppConstants.SECCION_3));
    expected.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
        Arrays.asList(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
            TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION_TRASLADADA_DIA.getId()));
    assertEquals(expected, p);
  }

}
