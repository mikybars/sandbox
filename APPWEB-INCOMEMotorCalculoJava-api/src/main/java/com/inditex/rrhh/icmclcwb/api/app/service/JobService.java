package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.JobDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.JobRunDto;

public interface JobService {

	JobDto createJob(@Valid final JobDto job);

	JobRunDto run(final Long id);

}