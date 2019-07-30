package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoGrupoDato;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoDatoRepository extends BaseRepository<TipoGrupoDato, Integer> {

    @Query("SELECT tgd.tipoDato FROM TipoGrupoDato tgd WHERE tgd.id = :idTipoGrupoDato")
    List<TipoDato> findTipoDatoByTipoGrupoDato(Integer idTipoGrupoDato);

}
