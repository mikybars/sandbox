package com.inditex.rrhh.icmclcwb.model.service;

import com.inditex.rrhh.icmclcwb.api.dto.JobDTO;
import com.inditex.rrhh.icmclcwb.api.service.JobService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.List;

import javax.validation.Valid;

@Service
@Validated
public class JobServiceImpl implements JobService {
    
    @Autowired
    private Logger LOG;

	@Override
	public Integer createJob(@Valid JobDTO job) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteJob(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyJob(@Valid JobDTO job) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JobDTO findJob(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobDTO> findJobs(List<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countJobs() {
		// TODO Auto-generated method stub
		return null;
	}

}