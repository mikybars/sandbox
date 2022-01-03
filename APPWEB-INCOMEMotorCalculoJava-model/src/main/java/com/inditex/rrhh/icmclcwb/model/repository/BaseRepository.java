package com.inditex.rrhh.icmclcwb.model.repository;

import java.io.Serializable;

import com.inditex.aqsw.framework.data.jpa.repositories.AmigaJpaRepository;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends AmigaJpaRepository<T, ID> {

}
