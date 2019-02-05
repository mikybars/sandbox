package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListatiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionRecord;

public abstract class IcmWsCalcIncomeMapperDecorator implements IcmWsCalcIncomeMapper {

    @Autowired
    @Qualifier("delegate")
    private IcmWsCalcIncomeMapper delegate;

    @Override
    public IcmParametrosentradaBlock asIcmParametrosentradaBlock(GenericFilterDto src) {
        IcmParametrosentradaBlock result = delegate.asIcmParametrosentradaBlock(src);
        if (CollectionUtils.isEmpty(result.getIcmParametrosentradaRecordSet())) {
            result.getIcmParametrosentradaRecordSet().add(new IcmParametrosentradaRecord());
        }
        return result;
    }

    @Override
    public IcmParametrospaginacionBlock asIcmParametrospaginacionBlock(PageDto src) {
        IcmParametrospaginacionBlock result = delegate.asIcmParametrospaginacionBlock(src);
        if (CollectionUtils.isEmpty(result.getIcmParametrospaginacionRecordSet())) {
            result.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        }
        return result;
    }

    // Llegaban fechas con vacío y se controló manualmente
    @Override
    public GenericTiendaResultItemDto asGenericTiendaResultItemDto(IcmListatiendasRecord src) {
        GenericTiendaResultItemDto mappedEntity = delegate.asGenericTiendaResultItemDto(src);
        mappedEntity.setEsComisionable(src.getEscomisionable().trim().equals("S"));
        if (StringUtils.isNotEmpty(src.getFechainicio())) {
            mappedEntity.setFechaInicio(java.time.LocalDateTime.parse(src.getFechainicio(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        if (StringUtils.isNotEmpty(src.getFechafin())) {
            mappedEntity.setFechaFin(java.time.LocalDateTime.parse(src.getFechafin(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        return mappedEntity;
    }

    // Llegaban fechas con vacío y se controló manualmente
    @Override
    public List<GenericTiendaResultItemDto> asGenericTiendaResultItemDtos(List<IcmListatiendasRecord> src) {
        List<GenericTiendaResultItemDto> list = new ArrayList<>();
        for (IcmListatiendasRecord record : src) {
            GenericTiendaResultItemDto mappedEntity = delegate.asGenericTiendaResultItemDto(record);
            mappedEntity.setEsComisionable(record.getEscomisionable().trim().equals("S"));
            if (StringUtils.isNotEmpty(record.getFechainicio())) {
                mappedEntity.setFechaInicio(java.time.LocalDateTime.parse(record.getFechainicio(),
                        DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
            }
            if (StringUtils.isNotEmpty(record.getFechafin())) {
                mappedEntity.setFechaFin(java.time.LocalDateTime.parse(record.getFechafin(),
                        DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
            }
            list.add(mappedEntity);
        }
        return list;
    }

}
