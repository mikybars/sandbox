package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTipoHora;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TareaTipoHoraRepository extends BaseRepository<TareaTipoHora, Long> {

    @Query("from TareaTipoHora tth where tth.tarea.id = :idTarea and tth.excluidoDenominadorYRepartidoProvincia = :excluidoDenominadorYRepartidoProvincia")
    public List<TareaTipoHora> findByIdTareaAndExcluidoDenominadorYRepartidoProvincia(Long idTarea,
            Boolean excluidoDenominadorYRepartidoProvincia);

}
