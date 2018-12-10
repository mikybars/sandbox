package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaEstado;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoTiendaEstadoRepository extends BaseRepository<TrabajoTiendaEstado, Long> {

	Page<TrabajoTiendaEstado> findByTrabajoIdAndTipoIdIn(Long trabajoId, List<Long> tipoTrabajoTiendaId,
			Pageable pageable);

	@Query(" select tte.idCadena from TrabajoTiendaEstado tte join tte.trabajo t where t.idPaisOrigen = :idPaisOrigen and tte.idEmpresa = :idEmpresa group by tte.idCadena ")
	List<String> findIdCadenaByIdPaisOrigenAndIdEmpresaGroupByIdCadena(
			@NotBlank @Param("idPaisOrigen") String idPaisOrigen, @NotBlank @Param("idEmpresa") String idEmpresa);

}
