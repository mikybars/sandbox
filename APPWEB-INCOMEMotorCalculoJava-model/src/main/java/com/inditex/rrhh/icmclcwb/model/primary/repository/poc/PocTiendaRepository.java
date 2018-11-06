package com.inditex.rrhh.icmclcwb.model.primary.repository.poc;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.model.primary.entity.poc.PocTienda;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface PocTiendaRepository extends BaseRepository<PocTienda, String> {
	
	List<PocTienda> findByIdPaisAndIdCadena(@NotBlank String idPais, @NotBlank String idCadena);
	
	List<PocTienda> findByIdPaisAndIdCadenaAndIdIn(@NotBlank String idPais, @NotBlank String idCadena, @NotNull List<String> tiendas);

}