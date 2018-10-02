package com.inditex.rrhh.icmclcwb.model.secondary.repository.ptr;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.Presencia;


public interface PTRPresenciasRepositoryMock {

	Presencia findPresencias( final Integer id);
}
