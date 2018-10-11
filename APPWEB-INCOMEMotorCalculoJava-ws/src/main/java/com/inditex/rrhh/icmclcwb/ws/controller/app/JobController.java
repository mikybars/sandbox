package com.inditex.rrhh.icmclcwb.ws.controller.app;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.dto.JobDto;
import com.inditex.rrhh.icmclcwb.api.app.service.JobService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/job")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class JobController {

	@Autowired
	private JobService jobService;

	@PostMapping
	@ApiOperation("Inserta un nuevo trabajo")
	public @Valid JobDto insert(@Valid @RequestBody final JobDto job) {
		return jobService.createJob(job);
	}

}