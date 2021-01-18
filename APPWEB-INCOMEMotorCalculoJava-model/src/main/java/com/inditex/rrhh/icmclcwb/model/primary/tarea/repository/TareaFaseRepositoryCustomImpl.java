/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFase;

/**
 * @author mdelrio
 *
 */
@Repository
public class TareaFaseRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaFase>
        implements TareaFaseRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-fase:0}")
    private int batchSize;

    @Value("#{primaryQuery['TareaFaseRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaFase> save(final List<TareaFase> src) {
        return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
    }

}
