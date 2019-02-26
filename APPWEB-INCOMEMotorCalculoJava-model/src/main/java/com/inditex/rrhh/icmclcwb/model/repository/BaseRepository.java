package com.inditex.rrhh.icmclcwb.model.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;

import com.inditex.aqsw.framework.data.jpa.repositories.JpaCrudRepository;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaCrudRepository<T, ID> {

}