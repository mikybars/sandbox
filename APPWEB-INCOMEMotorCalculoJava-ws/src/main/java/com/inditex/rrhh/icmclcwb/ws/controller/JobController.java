package com.inditex.rrhh.icmclcwb.ws.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.dto.JobDTO;
import com.inditex.rrhh.icmclcwb.api.service.JobService;
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

	@GetMapping
    @ApiOperation("Find all jobs")
    public List<JobDTO> findAll() {
        List<JobDTO> jobs = this.jobService.findJobs(Collections.emptyList());
        return jobs;
    }

    @GetMapping(path = "/count/")
    @ApiOperation("Get the number of jobs")
    public Long count() {
        return this.jobService.countJobs();
    }

    @GetMapping(path = "{id}")
    @ApiOperation("Find job by id")
    public JobDTO finById(@PathVariable final Integer id) {
        return this.jobService.findJob(id);
    }

    @GetMapping(path = "/findByIdSecure/{id}")
    @ApiOperation("Find job by id from given rol. The user should have a rol TESTSECURITY")
    @PreAuthorize("hasAuthority('admin')")
    public JobDTO findByIdSecure(@PathVariable final Integer id) {
        return this.jobService.findJob(id);
    }

    @PostMapping
    @ApiOperation("Insert a new job")
    public @Valid JobDTO insert(@Valid @RequestBody final JobDTO job) {
        final Integer id = this.jobService.createJob(job);
        job.setId(id);
        return job;
    }

    @PutMapping(path = "{id}")
    @ApiOperation("Modify an existing job")
    public JobDTO modify(@PathVariable final Integer id, @RequestBody final JobDTO job) {
        job.setId(id);
        if (this.jobService.modifyJob(job)) {
            return finById(job.getId());
        }
        return job;
    }

    @DeleteMapping(path = "{id}")
    @ApiOperation("Remove a job by id")
    public Integer delete(@PathVariable final Integer id) {
        this.jobService.deleteJob(id);
        return id;
    }

}