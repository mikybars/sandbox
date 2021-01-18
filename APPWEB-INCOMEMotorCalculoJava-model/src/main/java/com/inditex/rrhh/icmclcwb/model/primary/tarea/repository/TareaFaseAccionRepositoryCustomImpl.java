/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccion;

/**
 * @author mdelrio
 *
 */
@Repository
public class TareaFaseAccionRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaFaseAccion>
        implements TareaFaseAccionRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-fase-accion:0}")
    private int batchSize;

    @Value("#{primaryQuery['TareaFaseAccionRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaFaseAccion> save(final List<TareaFaseAccion> src) {
        return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
    }

}
