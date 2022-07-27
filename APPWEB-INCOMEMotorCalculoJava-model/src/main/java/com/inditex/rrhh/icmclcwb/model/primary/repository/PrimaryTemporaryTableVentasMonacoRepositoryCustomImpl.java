package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class PrimaryTemporaryTableVentasMonacoRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionVenta>
    implements PrimaryTemporaryTableVentasMonacoRepositoryCustom {

    @Value("#{primaryQuery['PrimaryTemporaryTableVentasMonacoRepositoryCustomImpl.createTempVentasMonacoPtr']}")
    private String sqlCreateTempVentasMonacoPtr;

    @Value("#{primaryQuery['PrimaryTemporaryTableVentasMonacoRepositoryCustomImpl.deleteTempVentasMonacoPtr']}")
    private String sqlDeleteTempVentasMonacoPtr;

    @Value("#{primaryQuery['PrimaryTemporaryTableVentasMonacoRepositoryCustomImpl.insertTempVentasMonacoPtr']}")
    private String sqlInsertTempVentasMonacoPtr;

    @Value("#{primaryQuery['PrimaryTemporaryTableVentasMonacoRepositoryCustomImpl.updateActivo']}")
    private String sqlUpdateActivo;

    @Value("${app.envars.repository.batch-size.tarea-localizacion-venta:0}")
    private int batchSize;

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public int deleteTempMonacoPtr() {
        return this.jdbcTemplate.update(this.sqlDeleteTempVentasMonacoPtr);
    }

    @Override
    public int createTempMonacoPtr() {
        return this.jdbcTemplate.update(this.sqlCreateTempVentasMonacoPtr);
    }

    @Override
    public List<TareaLocalizacionVenta> insertTempMonacoPtr(final List<TareaLocalizacionVenta> src) {
        return this.saveNamedJdbcBatchList(src, this.sqlInsertTempVentasMonacoPtr, this.batchSize);
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
    public void mergeIntoTareaLocalizacionVenta() {
        //TODO metodo para mergear la tabla temporal con la tabla destino
    }

}
