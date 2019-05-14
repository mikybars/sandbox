package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.EstadoTarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TareaRepository extends BaseRepository<Tarea, Long> {

    @Modifying
    @Query("UPDATE Tarea t set t.estado = :estado WHERE t.id = :id")
    int setEstado(@NotNull @Param("id") final Long id, @NotNull @Valid @Param("estado") final EstadoTarea estado);
    
    @Modifying
    @Query("UPDATE Tarea t set t.fechaInicioTarea = :fechaInicioTarea WHERE t.id = :id")
    int setFechaInicioTarea(@NotNull @Param("id") final Long id, @NotNull @Param("fechaInicioTarea") final Date fechaInicioTarea);

    @Modifying
    @Query("UPDATE Tarea t set t.fechaFinTarea = :fechaFinTarea WHERE t.id = :id")
    int setFechaFinTarea(@NotNull @Param("id") final Long id, @NotNull @Param("fechaFinTarea") final Date fechaFinTarea);
    
    List<Tarea> findByTrabajoId(@NotNull final Long id);

}
