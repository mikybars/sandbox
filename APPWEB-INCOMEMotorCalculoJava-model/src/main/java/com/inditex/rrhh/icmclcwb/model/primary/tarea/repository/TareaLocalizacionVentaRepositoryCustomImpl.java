package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

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
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotNull;

@Repository
public class TareaLocalizacionVentaRepositoryCustomImpl extends
    JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionVenta> implements TareaLocalizacionVentaRepositoryCustom{

    @Value("${app.envars.repository.batch-size.tarea-localizacion-venta:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.updateActivo']}")
    private String sqlUpdateActivo;

    @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.updateActivoTrasladadas']}")
    private String sqlUpdateActivoTrasladadas;

    @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.totalizarOperacionesLocalizacionSeccion']}")
    private String sqlTotalizarOperacionesLocalizacionSeccion;

    @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.totalizarVentaPersonasPorVenta']}")
    private String sqlTotalizarVentaPersonasPorVenta;

    @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.calcularImporteComisionVendedores']}")
    private String sqlCalcularImporteComisionVendedores;

    @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.calcularImporteComisionVentaODevolucion']}")
    private String sqlCalcularImporteComisionVentaODevolucion;
    
    @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.updateActivoNegativoTotalizado']}")
    private String sqlUpdateActivoNegativoTotalizado;

    @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.totalizarVentasVendedor0']}")
    private String sqlTotalizarVentasVendedor0;

    @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.repartoDevolucionVendedor0']}")
    private String sqlRepartoDevolucionVendedor0;

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<TareaLocalizacionVenta> save(List<TareaLocalizacionVenta> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionVenta entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getCclIdCadena());
        pstmt.setString(3, entity.getCclIdCodOrigen());
        pstmt.setString(4, entity.getCclIdSeccion());
        pstmt.setDouble(5, entity.getImporteSinImpuestos());
        pstmt.setDouble(6, entity.getImporteConImpuestos());
        pstmt.setDouble(7, entity.getTipoDato().getId());
        pstmt.setBoolean(8, entity.getActivo());
        pstmt.setLong(9, entity.getTarea().getId());
        pstmt.setObject(10, entity.getPk().getFechaInicioPeriodo());
    }

    @Override
    public void updateActivo(TareaDto tarea, TipoVentaConceptoEnum tipoVentaConceptoEnum, List<Integer> idsTipoDato) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idsTipoDato);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO, tipoVentaConceptoEnum.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION, SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        namedParameterJdbcTemplate.update(sqlUpdateActivo, params);
    }

    @Override
    public void updateActivoTrasladadas(TareaDto tarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
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
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_IPOD_LOCALIZACION_TRASLADADA, TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_TRASLADADA_DIA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_IPOD_LOCALIZACION_SECCION_TRASLADADA, TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION_TRASLADADA_DIA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_SINT_LOCALIZACION_TRASLADADA, TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_TRASLADADA_DIA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_SINT_LOCALIZACION_SECCION_TRASLADADA, TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION_TRASLADADA_DIA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_TIENDA_LOCALIZACION_TRASLADADA, TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_TRASLADADA_DIA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_TIENDA_LOCALIZACION_SECCION_TRASLADADA, TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION_TRASLADADA_DIA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION_TRASLADADA, TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_TRASLADADA_DIA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION_SECCION_TRASLADADA, TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION_TRASLADADA_DIA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());

        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        namedParameterJdbcTemplate.update(sqlUpdateActivoTrasladadas, parameters);
    }

    @Override
    public void totalizarVentasSinDevolucionLocalizacionSeccion(TareaDto tarea) {

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        //parametros
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION_TOTALIZADA.getId());
        //nuevos valores
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

        namedParameterJdbcTemplate.update(sqlTotalizarOperacionesLocalizacionSeccion, parameters);

    }

    @Override
    public void totalizarDevolucionLocalizacionSeccion(TareaDto tarea) {

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        //parametros
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.DEVOLUCION_LOCALIZACION_TOTALIZADA.getId());
        //nuevos valores
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.DEVOLUCION_LOCALIZACION_SECCION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

        namedParameterJdbcTemplate.update(sqlTotalizarOperacionesLocalizacionSeccion, parameters);

    }

    @Override
    public void totalizarVentaPersonasPorVentaSimplificada(TareaDto tarea) {

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        //parametros
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.OPERACIONES_VENTA_INDIVIDUAL_LOCALIZACION_SECCION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA, TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA_SIMPLIFICADA.getId());
        //nuevos valores
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.VENTA_LOCALIZACION_EMPLEADOS_POR_VENTA_SIMPLIFICADO.getId());
        namedParameterJdbcTemplate.update(sqlTotalizarVentaPersonasPorVenta, parameters);

    }

    @Override
    public void totalizarVentaSinDevolucionPersonasPorVenta(TareaDto tarea) {

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        //parametros
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION_TOTALIZADA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA, TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());
        //nuevos valores
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_EMPLEADOS_POR_VENTA.getId());
        namedParameterJdbcTemplate.update(sqlTotalizarVentaPersonasPorVenta, parameters);

    }

    @Override
    public void calcularImporteComisionVendedores(TareaDto tarea) {

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        //parametros
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_COMISION, AppConstants.PORCENTAJE_COMISION);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION, TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.VENTA_FISICA_IPOD_LOCALIZACION_SECCION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_PRESENCIA_LOCALIZACION_PERSONAS_POR_VENTA, TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_EMPLEADOS_POR_VENTA.getId());
        //nuevos valores
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.IMPORTE_COMISION_VENDEDORES_POR_VENTA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

        namedParameterJdbcTemplate.update(sqlCalcularImporteComisionVendedores, parameters);
    }

    @Override
    public void calcularImporteComisionVentaODevolucion(TareaDto tarea) {

        MapSqlParameterSource parameters = new MapSqlParameterSource();

        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
            TipoGrupoDatoEnum.VENTA_FISICA_IPOD_LOCALIZACION_SECCION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION,
            TipoDatoEnum.DEVOLUCION_LOCALIZACION_SECCION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_DEVOLUCION,
            TipoDatoEnum.IMPORTE_COMISION_DEVOLUCIONES_LOCALIZACION_POR_VENTA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION,
            TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_VENTA,
            TipoDatoEnum.IMPORTE_COMISION_VENTA_LOCALIZACION_POR_VENTA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
            Arrays.asList(TipoDatoEnum.DEVOLUCION_LOCALIZACION_SECCION.getId(), TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION.getId()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_VENDEDORES,
            TipoDatoEnum.IMPORTE_COMISION_VENDEDORES_POR_VENTA.getId());

        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

        namedParameterJdbcTemplate.update(sqlCalcularImporteComisionVentaODevolucion, parameters);

    }
    
    @Override
    public void updateActivoNegativoTotalizado(@NotNull TareaDto tarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
        
        namedParameterJdbcTemplate.update(sqlUpdateActivoNegativoTotalizado, parameters);
    }

    @Override
    public void totalizarVentasVendedor0(@NotNull TareaDto tarea) {

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_DEVOLUCION, TipoGrupoDatoEnum.DEVOLUCION_LOCALIZACION_TOTALIZADA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA, TipoGrupoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION_TOTALIZADA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO, TipoCalculoEnum.POR_VENTA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA, TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON_VENDEDOR_0, PtrConstants.VENDEDOR_0);

        namedParameterJdbcTemplate.update(sqlTotalizarVentasVendedor0, parameters);

    }

    @Override
    public void repartoDevolucionVendedor0(@NotNull TareaDto tarea) {

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA, TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.REPARTO_DEVOLUCION_VENDEDOR_0_LOCALIZACION_SECCION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA, TipoDatoEnum.DEVOLUCION_VENDEDOR_0_LOCALIZACION_SECCION.getId());

        namedParameterJdbcTemplate.update(sqlRepartoDevolucionVendedor0, parameters);

    }
}
