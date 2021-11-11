package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import lombok.Getter;

@Repository
public class TareaCalculoAjusteBajaItRepositoryCustomImpl
        extends AbstractTareaCalculoAjusteBaseRepositoryCustom
        implements TareaCalculoAjusteBajaItRepositoryCustom {

    @Value("#{primaryQuery['TareaCalculoAjusteRepositoryCustom.insert']} #{primaryQuery['TareaCalculoAjusteRepositoryCustom.bajaIt']} #{primaryQuery['TareaCalculoAjusteRepositoryCustom.where']}")
    @Getter
    private String sqlAjustar;

    @Value("#{primaryQuery['TareaCalculoAjusteRepositoryCustom.bajaIt']} #{primaryQuery['TareaCalculoAjusteRepositoryCustom.where']}")
    @Getter
    private String sqlAjustarBase;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Override
    public List<IdPersonaLocalDto> ids(final TareaDto tarea) {
        return this.tareaCalculoPersonaService.findByTareaAndIdEstadoAndIdTipoPolitica(tarea,
                TipoPoliticaEnum.BAJA_IT.getIdMeta4());
    }

}
