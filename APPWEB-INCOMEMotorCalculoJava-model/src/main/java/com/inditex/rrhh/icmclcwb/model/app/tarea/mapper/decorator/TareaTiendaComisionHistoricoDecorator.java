package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaComisionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaComisionHistorico;

public abstract class TareaTiendaComisionHistoricoDecorator extends TareaTiendaComisionHistoricoMapper {

    @Autowired
    private TareaTiendaComisionHistoricoMapper delegate;

    @Override
    public List<TareaTiendaComisionHistorico> mergeTareaTiendaComisionHistoricoDtoAndTareaDtoToTareaTiendaComisionHistorico(
            List<TareaTiendaComisionHistoricoDto> srcTareaTiendaComisionHistorico, TareaDto srcTarea) {
        List<TareaTiendaComisionHistorico> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(srcTareaTiendaComisionHistorico)) {
            srcTareaTiendaComisionHistorico.forEach(item -> 
                result.add(
                        delegate.mergeTareaTiendaComisionHistoricoDtoAndTareaDtoToTareaTiendaComisionHistorico(item, srcTarea))
            );
        }
        return result;
    }

}
