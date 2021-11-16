package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionOnlineHistorico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TareaLocalizacionOnlineHistoricoRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionOnlineHistorico>
    implements TareaLocalizacionOnlineHistoricoRepositoryCustom {

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("${app.envars.repository.batch-size.tarea-localizacion-online-historico:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaLocalizacionOnlineHistoricoRepositoryCustom.save']}")
  private String sqlSave;

  // TODO [COMUN] No se está usando
  @Value("#{primaryQuery['TareaLocalizacionOnlineHistoricoRepositoryCustom.findIdLocalizacionDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito']}")
  private String sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito;

  @Override
  public List<TareaLocalizacionOnlineHistorico> save(final List<TareaLocalizacionOnlineHistorico> tiendas) {
    return this.saveNamedJdbcBatchList(tiendas, this.sqlSave, this.batchSize);
  }

}
