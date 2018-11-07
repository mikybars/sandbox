package com.inditex.rrhh.icmclcwb.model.primary.repository.poc;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.model.primary.entity.poc.PocTienda;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface PocTiendaRepository extends BaseRepository<PocTienda, String> {
	
	List<PocTienda> findByIdPaisAndIdEmpresa(@NotBlank String idPais, @NotBlank String idEmpresa);
	
	List<PocTienda> findByIdPaisAndIdEmpresaAndIdIn(@NotBlank String idPais, @NotBlank String idEmpresa, @NotNull List<String> tiendas);

}