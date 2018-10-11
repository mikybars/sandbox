package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.JobDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ScheduleDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Job;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface JobMapper {

	JobDto jobToJobDto(Job src);

	Job jobDtoToJob(JobDto src);

	List<JobDto> jobsToJobDtos(List<Job> src);

	JobDto scheduleDtoToJobDto(ScheduleDto src);

	List<JobDto> scheduleDTOsToJobDTOs(List<ScheduleDto> src);

}