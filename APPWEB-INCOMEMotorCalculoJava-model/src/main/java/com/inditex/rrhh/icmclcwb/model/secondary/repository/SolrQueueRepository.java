package com.inditex.rrhh.icmclcwb.model.secondary.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.SolrQueue;

public interface SolrQueueRepository extends BaseRepository<SolrQueue, Long> {

	@Query(value = "SELECT TOP 10 * FROM M4HSW_SOLR_QUEUE", nativeQuery = true)
	Collection<SolrQueue> findAllQuery();

}