package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.entity.ReglaValidacionExcedido;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ReglaValidacionExcedidoId;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReglaValidacionExcedidoRepository extends BaseRepository<ReglaValidacionExcedido, ReglaValidacionExcedidoId> {

  @Query(nativeQuery = true)
  List<ReglaValidacionExcedido> findByCclIdOrigenAndStdIdLegEnt(@Param("cclIdOrigen") String cclIdOrigen,
      @Param("stdIdLegEnt") String stdIdLegEnt);

}
