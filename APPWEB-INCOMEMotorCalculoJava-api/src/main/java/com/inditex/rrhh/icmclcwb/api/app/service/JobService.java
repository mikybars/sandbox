package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.JobDto;

public interface JobService {

	JobDto createJob(@Valid final JobDto job);

	JobDto run(final Long id);

}