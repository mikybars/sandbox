package com.inditex.rrhh.icmclcwb.model.service;

import java.io.Serializable;

import org.springframework.data.repository.Repository;

public interface BaseService<T, ID extends Serializable> extends Repository<T, ID> {

}