package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoEmpleadoEstructuraService;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoEmpleadoEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoEstructuraRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoEstructuraRepositoryCustom;

@Service
@Validated
public class TrabajoEmpleadoEstructuraServiceImpl implements TrabajoEmpleadoEstructuraService {

    @Autowired
    private TrabajoEmpleadoEstructuraRepository trabajoEmpleadoEstructuraRepository;
    
    @Autowired
    private TrabajoEmpleadoEstructuraRepositoryCustom trabajoEmpleadoEstructuraRepositoryCustom;

    @Autowired
    private TrabajoEmpleadoEstructuraMapper trabajoEmpleadoEstructuraMapper;
    
    @Override
    public List<TrabajoEmpleadoEstructuraDto> save(final List<TrabajoEmpleadoEstructuraDto> trabajoEmpleadoEstructura, @Valid TrabajoDto trabajo) throws Exception {
        return trabajoEmpleadoEstructuraMapper.trabajoEmpleadoEstructuraToTrabajoEmpleadoEstructuraDto(
                trabajoEmpleadoEstructuraRepositoryCustom.save(trabajoEmpleadoEstructuraMapper
                        .mergeTrabajoEmpleadoEstructuraDtoAndTrabajoDtoToTrabajoEmpleadoEstructura(trabajoEmpleadoEstructura,
                                trabajo)));
    }
    
	@Override
	public Set<Long> findIdsEstructuraByIdTrabajo(@Valid Long idTrabajo) {
		return trabajoEmpleadoEstructuraRepository.findIdsEstructuraByIdTrabajo(idTrabajo);
	}
    
    
    
    
    
    
}
