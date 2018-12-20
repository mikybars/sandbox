package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstructuraService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoEstructuraRepository;

@Service
@Validated
public class TrabajoEmpleadoEstructuraServiceImpl implements TrabajoEmpleadoEstructuraService {

    @Autowired
    private TrabajoEmpleadoEstructuraRepository trabajoEmpleadoEstructuraRepository;

    @Autowired
    private TrabajoEmpleadoEstructuraMapper trabajoEmpleadoEstructuraMapper;
    
    @Override
    public List<TrabajoEmpleadoEstructuraDto> save(final List<TrabajoEmpleadoEstructuraDto> trabajoEmpleadoEstructura, @Valid TrabajoDto trabajo) {
        return trabajoEmpleadoEstructuraMapper.trabajoEmpleadoEstructuraToTrabajoEmpleadoEstructuraDto(
                trabajoEmpleadoEstructuraRepository.save(trabajoEmpleadoEstructuraMapper
                        .mergeTrabajoEmpleadoEstructuraDtoAndTrabajoDtoToTrabajoEmpleadoEstructura(trabajoEmpleadoEstructura,
                                trabajo)));
    }
    
	@Override
	public Set<Long> findIdsEstructuraByIdTrabajo(@Valid Long idTrabajo) {
		return trabajoEmpleadoEstructuraRepository.findIdsEstructuraByIdTrabajo(idTrabajo);
	}
    
    
    
    
    
    
}
