package com.inditex.rrhh.icmclcwb.api.service;

import java.util.concurrent.CompletableFuture;

public interface SolrQueueService {

	Long count() throws Exception;

	CompletableFuture<Boolean> test1Async() throws Exception;

	CompletableFuture<Boolean> test2Async() throws Exception;

	CompletableFuture<Boolean> test3Async() throws Exception;

	CompletableFuture<Boolean> test4Async() throws Exception;

	CompletableFuture<Boolean> test5Async() throws Exception;

	void testPtr() throws Exception;

}