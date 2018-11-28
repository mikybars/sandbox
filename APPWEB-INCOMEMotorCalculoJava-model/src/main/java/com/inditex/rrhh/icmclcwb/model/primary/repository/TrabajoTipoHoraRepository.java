package com.inditex.rrhh.icmclcwb.model.primary.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTipoHoraDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionVenta;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTipoHora;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoTipoHoraRepository extends BaseRepository<TrabajoTipoHora, Long>{
}
