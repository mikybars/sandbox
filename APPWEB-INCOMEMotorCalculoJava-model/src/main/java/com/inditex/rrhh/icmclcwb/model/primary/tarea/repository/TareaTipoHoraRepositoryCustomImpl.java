package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTipoHora;

@Repository
public class TareaTipoHoraRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaTipoHora>
        implements TareaTipoHoraRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-tipo-hora:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaTipoHoraRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaTipoHora> save(final List<TareaTipoHora> src) {
        return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
    }

}
