package com.inditex.rrhh.icmclcwb.model.primary.repository.poc;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.model.primary.entity.poc.PocTienda;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface PocTiendaRepository extends BaseRepository<PocTienda, String> {
	
	List<PocTienda> findByIdPaisOrigenAndIdEmpresa(@NotBlank String idPaisOrigen, @NotBlank String idEmpresa);
	
	List<PocTienda> findByIdPaisOrigenAndIdEmpresaAndIdIn(@NotBlank String idPaisOrigen, @NotBlank String idEmpresa, @NotNull List<String> tiendas);

}