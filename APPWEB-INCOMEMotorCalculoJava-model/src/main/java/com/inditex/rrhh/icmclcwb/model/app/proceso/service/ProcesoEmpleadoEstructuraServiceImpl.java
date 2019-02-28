package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoEmpleadoEstructuraService;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoEmpleadoEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoEmpleadoEstructuraRepository;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoEmpleadoEstructuraRepositoryCustom;

@Service
@Validated
public class ProcesoEmpleadoEstructuraServiceImpl implements ProcesoEmpleadoEstructuraService {

    @Autowired
    private ProcesoEmpleadoEstructuraRepository procesoEmpleadoEstructuraRepository;
    
    @Autowired
    private ProcesoEmpleadoEstructuraRepositoryCustom procesoEmpleadoEstructuraRepositoryCustom;

    @Autowired
    private ProcesoEmpleadoEstructuraMapper procesoEmpleadoEstructuraMapper;
    
    @Override
    public List<ProcesoEmpleadoEstructuraDto> save(final List<ProcesoEmpleadoEstructuraDto> procesoEmpleadoEstructura, @Valid ProcesoDto proceso) {
        return procesoEmpleadoEstructuraMapper.procesoEmpleadoEstructuraToProcesoEmpleadoEstructuraDto(
                procesoEmpleadoEstructuraRepositoryCustom.save(procesoEmpleadoEstructuraMapper
                        .mergeProcesoEmpleadoEstructuraDtoAndProcesoDtoToProcesoEmpleadoEstructura(procesoEmpleadoEstructura,
                                proceso)));
    }
    
	@Override
	public Set<Long> findIdTipoCalculoByIdProceso(@Valid Long idProceso) {
		return procesoEmpleadoEstructuraRepository.findIdTipoCalculoByIdProceso(idProceso);
	}
    
}
