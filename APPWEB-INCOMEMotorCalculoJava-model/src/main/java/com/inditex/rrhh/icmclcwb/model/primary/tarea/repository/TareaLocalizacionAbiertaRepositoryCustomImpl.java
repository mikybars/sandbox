package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TareaLocalizacionAbiertaRepositoryCustomImpl implements TareaLocalizacionAbiertaRepositoryCustom {

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.saveAbierto']}")
  private String sqlSaveAbierto;

  @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.saveAbiertoSeccion']}")
  private String sqlSaveAbiertoSeccion;

  @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.saveCerrado']}")
  private String sqlSaveCerrado;

  @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.saveCerradoSeccion']}")
  private String sqlSaveCerradoSeccion;

  @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.trasladar']}")
  private String sqlTrasladar;

  @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.compensar']}")
  private String sqlCompensar;

  @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.agruparOnlineSeccionDia']}")
  private String sqlAgruparOnlineSeccionDia;

  @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.updateActivoTrasladadasTotalizado']}")
  private String sqlUpdateActivoTrasladadasTotalizado;

  @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.compensarOnlineSeccionCerrada']}")
  private String sqlCompensarOnlineSeccionCerrada;

  @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.updateActivoTrasladadasSeccion']}")
  private String sqlUpdateActivoTrasladadasSeccion;

  @Autowired
  @Qualifier(value = "recolectarProperties")
  private RecolectarPropertiesDto recolectarProperties;

  @Autowired
  private TipoDatoService tipoDatoService;

  @Override
  public void saveAbierto(@NotNull final TareaDto tareaDto, final TrabajoDTO trabajoDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IMPORTE, SqlPrimaryConstants.SQL_VALUE_IMPORTE_CERO);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA_LOCALIZACIONABIERTA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO,
        SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.VENTA_FISICA_LOCALIZACION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    this.namedParameterJdbcTemplate.update(this.sqlSaveAbierto, parameters);
  }

  @Override
  public void saveAbiertoSeccion(@NotNull final TareaDto tareaDto, final TrabajoDTO trabajoDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IMPORTE, SqlPrimaryConstants.SQL_VALUE_IMPORTE_CERO);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA,
        TipoDatoEnum.VENTA_FISICA_LOCALIZACION_SECCION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO,
        SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    this.namedParameterJdbcTemplate.update(this.sqlSaveAbiertoSeccion, parameters);
  }

  @Override
  public void compensarOnlineSeccionCerrada(@NotNull final TareaDto tareaDto, @NotNull final TrabajoDTO trabajoDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO,
        TimeUtils.toDate(trabajoDto.getFechaInicioPeriodo().toLocalDateTime()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN,
        RunUtils.addDays(trabajoDto.getFechaFinPeriodo().toLocalDateTime(),
            this.recolectarProperties.getDaysNumber(),
            "yyyy-MM-dd"));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
        Arrays.asList(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
            TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION_TRASLADADA_DIA.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION,
        Arrays.asList(AppConstants.SECCION_1, AppConstants.SECCION_2, AppConstants.SECCION_3));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);

    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_FISICA_LOCALIZACION_SECCION,
        TipoDatoEnum.VENTA_FISICA_LOCALIZACION_SECCION.getId());

    final List<Integer> tiposDatoVentaIpod = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION_COMPENSAR_SECCION_CERRADA.getId()).stream()
        .map(IdTipoDatoDto::getId).collect(
            Collectors.toList());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_IPOD_LOCALIZACION_SECCION,
        tiposDatoVentaIpod);
    final List<Integer> tiposDatoVentaSint = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION_COMPENSAR_SECCION_CERRADA.getId()).stream()
        .map(IdTipoDatoDto::getId).collect(
            Collectors.toList());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_SINT_LOCALIZACION_SECCION,
        tiposDatoVentaSint);
    final List<Integer> tiposDatoVentaEntregaTienda = this.tipoDatoService.findTipoDatoByTipoGrupoDato(
        TipoGrupoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION_COMPENSAR_SECCION_CERRADA.getId()).stream()
        .map(IdTipoDatoDto::getId).collect(
            Collectors.toList());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_TIENDA_LOCALIZACION_SECCION,
        tiposDatoVentaEntregaTienda);
    final List<Integer> tiposDatoVentaEntregaDomicilio = this.tipoDatoService.findTipoDatoByTipoGrupoDato(
        TipoGrupoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION_COMPENSAR_SECCION_CERRADA.getId()).stream()
        .map(IdTipoDatoDto::getId).collect(
            Collectors.toList());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION_SECCION,
        tiposDatoVentaEntregaDomicilio);
    // valores a establecer
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_IPOD_LOCALIZACION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_TRASLADADA_SECCION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_IPOD_LOCALIZACION_SECCION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION_TRASLADADA_SECCION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_SINT_LOCALIZACION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_TRASLADADA_SECCION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_SINT_LOCALIZACION_SECCION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION_TRASLADADA_SECCION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_TIENDA_LOCALIZACION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_TRASLADADA_SECCION.getId());
    parameters.addValue(
        SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_TIENDA_LOCALIZACION_SECCION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION_TRASLADADA_SECCION.getId());
    parameters.addValue(
        SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_TRASLADADA_SECCION.getId());
    parameters.addValue(
        SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION_SECCION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION_TRASLADADA_SECCION.getId());

    this.namedParameterJdbcTemplate.update(this.sqlCompensarOnlineSeccionCerrada, parameters);
  }

  @Override
  public void trasladar(@NotNull final TareaDto tareaDto, @NotNull final List<Integer> idTipoImporteVenta) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idTipoImporteVenta);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CERRADO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_IPOD_LOCALIZACION,
        TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_IPOD_LOCALIZACION_SECCION,
        TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_SINT_LOCALIZACION,
        TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_SINT_LOCALIZACION_SECCION,
        TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_TIENDA_LOCALIZACION,
        TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_TIENDA_LOCALIZACION_SECCION,
        TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION,
        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION_SECCION,
        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    // valores a establecer
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_IPOD_LOCALIZACION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_TRASLADADA_DIA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_IPOD_LOCALIZACION_SECCION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION_TRASLADADA_DIA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_SINT_LOCALIZACION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_TRASLADADA_DIA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_SINT_LOCALIZACION_SECCION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION_TRASLADADA_DIA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_TIENDA_LOCALIZACION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_TRASLADADA_DIA.getId());
    parameters.addValue(
        SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_TIENDA_LOCALIZACION_SECCION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION_TRASLADADA_DIA.getId());
    parameters.addValue(
        SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_TRASLADADA_DIA.getId());
    parameters.addValue(
        SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION_SECCION_TRASLADADA,
        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION_TRASLADADA_DIA.getId());
    this.namedParameterJdbcTemplate.update(this.sqlTrasladar, parameters);
  }

  @Override
  public void compensar(@NotNull final TareaDto tareaDto, @NotNull final List<Integer> idTipoImporteVenta) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idTipoImporteVenta);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CERRADO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
        TimeUtils.toDate(tareaDto.getFechaInicioPeriodo()));
    this.namedParameterJdbcTemplate.update(this.sqlCompensar, parameters);
  }

  @Override
  public void saveCerrado(@NotNull final TareaDto tareaDto, final TrabajoDTO trabajoDto,
      @NotNull final List<Integer> idTipoImporteVenta) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
        Arrays.asList(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION.getId(),
            TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    this.namedParameterJdbcTemplate.update(this.sqlSaveCerrado, parameters);
  }

  @Override
  public void saveCerradoSeccion(@NotNull final TareaDto tareaDto, final TrabajoDTO trabajoDto,
      @NotNull final List<Integer> idTipoImporteVenta) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
        Arrays.asList(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    this.namedParameterJdbcTemplate.update(this.sqlSaveCerradoSeccion, parameters);
  }

  @Override
  public void updateActivoTrasladadasSeccion(@NotNull final TareaDto tarea, @NotNull final TrabajoDTO trabajoDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO,
        TimeUtils.toDate(trabajoDto.getFechaInicioPeriodo().toLocalDateTime()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN,
        RunUtils.addDays(trabajoDto.getFechaFinPeriodo().toLocalDateTime(),
            this.recolectarProperties.getDaysNumber(),
            "yyyy-MM-dd"));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION,
        Arrays.asList(AppConstants.SECCION_1, AppConstants.SECCION_2, AppConstants.SECCION_3));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
        Arrays.asList(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
            TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
            TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION_TRASLADADA_DIA.getId()));
    this.namedParameterJdbcTemplate.update(this.sqlUpdateActivoTrasladadasSeccion, parameters);
  }

  @Override
  public void agruparOnlineSeccionDia(@NotNull final TareaDto tarea, @NotNull final TrabajoDTO trabajoDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPO_GRUPO_DATO_TRASLADADOS,
        Arrays.asList(TipoGrupoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION_TRASLADADA.getId(),
            TipoGrupoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION_TRASLADADA.getId(),
            TipoGrupoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION_TRASLADADA.getId(),
            TipoGrupoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION_TRASLADADA.getId(),
            TipoGrupoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_TRASLADADA.getId(),
            TipoGrupoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_TRASLADADA.getId(),
            TipoGrupoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_TRASLADADA.getId(),
            TipoGrupoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_TRASLADADA.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPO_GRUPO_DATO_TRASLADADOS_TOTALIZADOS,
        Arrays.asList(TipoGrupoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION_TRASLADADA_TOTALIZADA.getId(),
            TipoGrupoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION_TRASLADADA_TOTALIZADA.getId(),
            TipoGrupoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION_TRASLADADA_TOTALIZADA.getId(),
            TipoGrupoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION_TRASLADADA_TOTALIZADA
                .getId(),
            TipoGrupoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_TRASLADADA_TOTALIZADA.getId(),
            TipoGrupoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_TRASLADADA_TOTALIZADA.getId(),
            TipoGrupoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_TRASLADADA_TOTALIZADA.getId(),
            TipoGrupoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_TRASLADADA_TOTALIZADA.getId()));
    this.namedParameterJdbcTemplate.update(this.sqlAgruparOnlineSeccionDia, parameters);
  }

  @Override
  public void updateActivoTrasladadasTotalizado(@NotNull final TareaDto tarea, @NotNull final TrabajoDTO trabajoDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    this.namedParameterJdbcTemplate.update(this.sqlUpdateActivoTrasladadasTotalizado, parameters);
  }

}
