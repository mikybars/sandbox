package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaLocalizacionVentaRepositoryCustomImpl extends
    JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionVenta> implements TareaLocalizacionVentaRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-localizacion-venta:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.save']}")
  private String sqlSave;

  @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.updateActivo']}")
  private String sqlUpdateActivo;

  @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.updateActivoTrasladadas']}")
  private String sqlUpdateActivoTrasladadas;

  @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.totalizarOperacionesLocalizacionSeccion']}")
  private String sqlTotalizarOperacionesLocalizacionSeccion;

  @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.totalizarOperacionesLocalizacion']}")
  private String sqlTotalizarOperacionesLocalizacion;

  @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.totalizarVentaPersonasPorVenta']}")
  private String sqlTotalizarVentaPersonasPorVenta;

  @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.calcularImporteComisionVendedores']}")
  private String sqlCalcularImporteComisionVendedores;

  @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.calcularImporteComisionVentaODevolucion']}")
  private String sqlCalcularImporteComisionVentaODevolucion;

  @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.updateActivoNegativoTotalizado']}")
  private String sqlUpdateActivoNegativoTotalizado;

  @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.totalizarDevolucionesVendedor0']}")
  private String sqlTotalizarDevolucionesVendedor0;

  @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.repartoDevolucionVendedor0']}")
  private String sqlRepartoDevolucionVendedor0;

  @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.updateActivoManual']}")
  private String sqlUpdateActivoManual;

  @Override
  public List<TareaLocalizacionVenta> save(final List<TareaLocalizacionVenta> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

  @Override
  public void updateActivo(final TareaDto tarea, final TipoVentaConceptoEnum tipoVentaConceptoEnum,
      final List<Integer> idsTipoDato) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idsTipoDato);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO, tipoVentaConceptoEnum.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION,
        SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    this.update(this.sqlUpdateActivo, params);
  }

  @Override
  public void updateActivoTrasladadas(final TareaDto tarea) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
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
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    this.update(this.sqlUpdateActivoTrasladadas, parameters);
  }

  @Override
  public void totalizarVentasSinDevolucionLocalizacionSeccion(final TareaDto tarea) {

    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    // parametros
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION_TOTALIZADA.getId());
    // nuevos valores
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    this.update(this.sqlTotalizarOperacionesLocalizacionSeccion, parameters);

  }

  @Override
  public void totalizarDevolucionLocalizacionSeccion(final TareaDto tarea) {

    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    // parametros
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.DEVOLUCION_LOCALIZACION_TOTALIZADA.getId());
    // nuevos valores
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.DEVOLUCION_LOCALIZACION_SECCION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    this.update(this.sqlTotalizarOperacionesLocalizacionSeccion, parameters);

  }

  @Override
  public void totalizarDevolucionLocalizacion(final TareaDto tarea) {

    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    // parametros
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.DEVOLUCION_LOCALIZACION_TOTALIZADA.getId());
    // nuevos valores
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.DEVOLUCION_LOCALIZACION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);

    this.update(this.sqlTotalizarOperacionesLocalizacion, parameters);

  }

  @Override
  public void totalizarVentaSinDevolucionPersonasPorVenta(final TareaDto tarea) {

    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    // parametros
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION_TOTALIZADA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA,
        TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());
    // nuevos valores
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_EMPLEADOS_POR_VENTA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);
    this.update(this.sqlTotalizarVentaPersonasPorVenta, parameters);

  }

  @Override
  public void calcularImporteComisionVendedores(final TareaDto tarea) {

    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    // parametros
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_COMISION, AppConstants.PORCENTAJE_COMISION);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.VENTA_FISICA_IPOD_LOCALIZACION_SECCION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_PRESENCIA_LOCALIZACION_PERSONAS_POR_VENTA,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_EMPLEADOS_POR_VENTA.getId());
    // nuevos valores
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.IMPORTE_COMISION_VENDEDORES_POR_VENTA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    this.update(this.sqlCalcularImporteComisionVendedores, parameters);
  }

  @Override
  public void calcularImporteComisionVentaODevolucion(final TareaDto tarea) {

    final MapSqlParameterSource parameters = new MapSqlParameterSource();

    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION,
        TipoDatoEnum.DEVOLUCION_LOCALIZACION_SECCION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION,
        TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
        Arrays.asList(TipoDatoEnum.DEVOLUCION_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_VENDEDORES,
        TipoDatoEnum.IMPORTE_COMISION_VENDEDORES_POR_VENTA.getId());

    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    this.update(this.sqlCalcularImporteComisionVentaODevolucion, parameters);

  }

  @Override
  public void updateActivoNegativoTotalizado(@NonNull final TareaDto tarea) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.VENTA_REAL_LOCALIZACION_SECCION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
        Arrays.asList(TipoDatoEnum.VENTA_MANUAL_LOCALIZACION_SECCION.getId()));

    this.update(this.sqlUpdateActivoNegativoTotalizado, parameters);
  }

  @Override
  public void totalizarDevolucionesVendedor0(@NonNull final TareaDto tarea) {

    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.DEVOLUCION_LOCALIZACION_TOTALIZADA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO, TipoCalculoEnum.POR_VENTA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON_VENDEDOR_0, PtrConstants.VENDEDOR_0);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.DEVOLUCION_VENDEDOR_0_LOCALIZACION_SECCION.getId());

    this.update(this.sqlTotalizarDevolucionesVendedor0, parameters);

  }

  @Override
  public void repartoDevolucionVendedor0(@NonNull final TareaDto tarea) {

    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA,
        TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA,
        TipoDatoEnum.DEVOLUCION_VENDEDOR_0_LOCALIZACION_SECCION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.REPARTO_DEVOLUCION_VENDEDOR_0_LOCALIZACION_SECCION.getId());

    this.update(this.sqlRepartoDevolucionVendedor0, parameters);
  }

  @Override
  public void updateActivoManual(@NonNull final TareaDto tarea) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.VENTA_REAL_LOCALIZACION_SECCION.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_LOCALIZACION_VENTA_MANUAL,
        TipoDatoEnum.VENTA_MANUAL_LOCALIZACION_SECCION.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    this.update(this.sqlUpdateActivoManual, params);
  }

}
