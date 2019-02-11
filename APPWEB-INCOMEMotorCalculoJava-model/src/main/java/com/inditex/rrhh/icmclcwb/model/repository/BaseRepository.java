package com.inditex.rrhh.icmclcwb.model.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

// TODO (JPA Arquetipo) Cambiar JpaRepository por JpaCrudRepository
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

}