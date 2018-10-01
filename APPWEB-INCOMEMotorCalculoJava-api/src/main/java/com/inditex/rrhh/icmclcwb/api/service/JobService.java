package com.inditex.rrhh.icmclcwb.api.service;

import com.inditex.rrhh.icmclcwb.api.dto.JobDTO;

import javax.validation.Valid;
import java.util.List;

public interface JobService {
    
    Integer createJob(@Valid final JobDTO job);
    
    boolean deleteJob(final Integer id);
    
    boolean modifyJob(@Valid final JobDTO job);
    
    JobDTO findJob(final Integer id);
    
    List<JobDTO> findJobs(final List<Integer> ids);
    
    Long countJobs();
    
    Boolean test();
    
}