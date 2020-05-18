package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracion;

@Repository
public class TareaAgrupacionConfiguracionRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaAgrupacionConfiguracion>
        implements TareaAgrupacionConfiguracionRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-configuracion-venta-online:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaAgrupacionConfiguracionRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaAgrupacionConfiguracion> save(final List<TareaAgrupacionConfiguracion> src) {
        return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
    }

}
