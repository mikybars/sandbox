package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaHistorico;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TareaPersonaHistoricoRepository extends BaseRepository<TareaPersonaHistorico, Long> {

  @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto(teh.stdIdHr, teh.stdOrHrPeriod) FROM"
      + " TareaPersonaHistorico teh WHERE teh.tarea.id=:idTarea AND teh.cclIdOrigen=:cclIdOrigen GROUP BY teh.stdIdHr, teh.stdOrHrPeriod")
  List<IdPersonaHistoricoDto> findIdPersonaHistoricoByIdTareaAndIdOrigen(
      @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
      @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN) final String cclIdOrigen);

}
