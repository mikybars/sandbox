package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

@Repository
public class TareaCalculoRepositoryCustomImpl implements TareaCalculoRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['TareaCalculoRepositoryCustom.regularizarMejorOpcion']}")
    private String sqlRegularizarMejorOpcion;

    @Value("#{primaryQuery['TareaCalculoRepositoryCustom.regularizarChallenge']}")
    private String sqlRegularizarChallenge;

    @Override
    public void regularizarMejorOpcion(@NotNull TareaDto tareaDto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        namedParameterJdbcTemplate.update(sqlRegularizarMejorOpcion, params);
    }

    @Override
    public void regularizarChallenge(@NotNull TareaDto tareaDto,
            @NotNull final IdPersonaLocalChallengeDto idPersonaLocalChallengeDto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, idPersonaLocalChallengeDto.getCclIdPerson());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD, idPersonaLocalChallengeDto.getStdOrHrPeriod());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO,
                idPersonaLocalChallengeDto.getIcmIdTpCalculo());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION,
                idPersonaLocalChallengeDto.getIcmIdTpComision());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO,
                idPersonaLocalChallengeDto.getEsDesplazamiento());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE,
                idPersonaLocalChallengeDto.getEsDesplazamientoBase());
        namedParameterJdbcTemplate.update(sqlRegularizarChallenge, params);
    }

}
