package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoChallengeEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionConfiguracionChallengeTipoVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConceptoChallenge;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracionChallengeTipoVenta;

public abstract class TareaAgrupacionConfiguracionChallengeTipoVentaDecorator
        extends TareaAgrupacionConfiguracionChallengeTipoVentaMapper {

    @Autowired
    private TareaAgrupacionConfiguracionChallengeTipoVentaMapper delegate;
    
    @Override
    public List<TareaAgrupacionConfiguracionChallengeTipoVenta> confChTpVentaResultItemDtoToTareaAgrupacionConfiguracionChallengeTipoVenta(
            List<ConfChTpVentaResultItemDto> src, TareaDto tarea) {
        List<TareaAgrupacionConfiguracionChallengeTipoVenta> result = new ArrayList<>();
        if (src != null) {
            src.forEach(x -> {
                TareaAgrupacionConfiguracionChallengeTipoVenta config = delegate.confChTpVentaResultItemDtoToTareaAgrupacionConfiguracionChallengeTipoVenta(x, tarea);
                config.setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder().id(TipoVentaConceptoChallengeEnum.fromIdMeta4(x.getIdConceptoVenta()).getId()).build());
                result.add(config);
            });
        }
        return result;
    }

}
