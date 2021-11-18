package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.SistemaDestinoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoAusenciaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoUnidadTiempoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

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

    @Autowired
    private TareaAmbitoService tareaAmbitoService;

    @Autowired
    private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

    @Override
    public List<IdPersonaLocalDto> ids(final TareaDto tarea) {
        return this.tareaCalculoPersonaService.findByTareaAndIdEstadoAndIdTipoPolitica(tarea,
                TipoPoliticaEnum.BAJA_IT.getIdMeta4());
    }

    @Override
    protected Map<String, Object> getMapValues(final AlgoritmoAjusteDto algoritmoAjuste, final TareaDto tarea,
            final IdPersonaLocalDto persona) {
        final Map<String, Object> map = new HashMap<>();
        String cclIdOrigen = null;
        SistemaDestinoResponseDto sistemaDestino = SistemaDestinoResponseDto.builder()
            .idSistemaDestino(
                    SistemaDestinoEnum.NONE.getIdMeta4())
            .build();
        if (tarea != null) {
            map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
            final List<TareaAmbitoDto> byTarea = this.tareaAmbitoService.findByTarea(tarea);
            cclIdOrigen = CollectionUtils.isNotEmpty(byTarea) ? byTarea.get(0).getCclIdOrigen() : null;
        }
        if (persona != null) {
            map.put(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
            map.put(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
        }

        if (StringUtils.isNotBlank(cclIdOrigen)) {
            sistemaDestino = this.meta4IcmWsCalcIncomeService
                .getSistemaDestino(SistemaDestinoRequestDto.builder().cclIdOrigen(cclIdOrigen).build());
        }

        map.put(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO_AJUSTE, algoritmoAjuste.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA, TipoPoliticaEnum.BAJA_IT.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_AUSENCIA, TipoAusenciaEnum.BAJA_IT.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE,
                Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD.getIdMeta4()));
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO, sistemaDestino.getIdSistemaDestino());
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO_SOLUCION_GLOBAL,
                SistemaDestinoEnum.SOLUCION_GLOBAL.getIdMeta4());
        return map;
    }

}
