package com.inditex.rrhh.icmclcwb.model.secondary.repository.ptr;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.Presencia;

@Repository
public class PTRPresenciasRepositoryImplMock implements PTRPresenciasRepositoryMock{

	@Override
	public Presencia findPresencias(final Integer id) {
		return new Presencia();
	}

}
