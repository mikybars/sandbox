package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

public class PrimaryTemporaryTableVentasMonacoRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionVenta>
    implements PrimaryTemporaryTableVentasMonacoRepositoryCustom {

    @Value("#{primaryQuery['PrimaryTemporaryTableVentasMonacoRepositoryCustomImpl.createTempVentasMonacoPtr']}")
    private String sqlCreateTempVentasMonacoPtr;

    @Value("#{primaryQuery['PrimaryTemporaryTableVentasMonacoRepositoryCustomImpl.deleteTempVentasMonacoPtr']}")
    private String sqlDeleteTempVentasMonacoPtr;

    @Value("#{primaryQuery['PrimaryTemporaryTableVentasMonacoRepositoryCustomImpl.insertTempVentasMonacoPtr']}")
    private String sqlInsertTempVentasMonacoPtr;

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

}
