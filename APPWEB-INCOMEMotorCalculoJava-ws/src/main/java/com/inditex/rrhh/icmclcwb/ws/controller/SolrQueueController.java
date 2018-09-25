package com.inditex.rrhh.icmclcwb.ws.controller;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.service.SolrQueueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Validated
@RestController
@RequestMapping(path = "/solrQueue")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class SolrQueueController {

	@Autowired
	private Logger LOG;

	@Autowired
	private SolrQueueService solrQueueService;

	@GetMapping(path = "/count/")
	@ApiOperation("Get the number of solrQueues")
	public Long count() throws Exception {
		return this.solrQueueService.count();
	}

	@GetMapping(path = "/async/")
	@ApiOperation("Test async")
	public void async() throws Exception {
		LOG.info("INICIO - async()");
		CompletableFuture<Boolean> test1Async = solrQueueService.test1Async();
		CompletableFuture<Boolean> test2Async = solrQueueService.test2Async();
		CompletableFuture<Boolean> test3Async = solrQueueService.test3Async();
		CompletableFuture<Boolean> test4Async = solrQueueService.test4Async();
		CompletableFuture<Boolean> test5Async = solrQueueService.test5Async();
		CompletableFuture.allOf(test1Async, test2Async, test3Async, test4Async, test5Async).get();
		LOG.info("FIN - async()");
	}

	@GetMapping(path = "/reactor/")
	@ApiOperation("Test reactor")
	public void reactor() throws Exception {
		LOG.info("INICIO - reactor()");
		Flux.range(1, 10).parallel().runOn(Schedulers.parallel()).map((s) -> {
			return "\n----------------------------------\n--- Hello " + s + ". I'm " + Thread.currentThread().getName()
							+ ". ---\n----------------------------------\n";
		}).subscribe(System.out::println);
		Flux.just(1, 2, 3, 4, 5, 6, 7, 8).parallel(2).runOn(Schedulers.parallel())
						.subscribe(arg -> LOG.info("subscribe: " + arg));
		LOG.info("FIN - reactor()");
	}

}