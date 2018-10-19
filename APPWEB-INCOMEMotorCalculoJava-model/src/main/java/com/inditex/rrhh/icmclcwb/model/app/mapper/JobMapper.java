package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.JobDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.JobStatusDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ScheduleDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.decorator.JobMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Job;
import com.inditex.rrhh.icmclcwb.model.primary.entity.JobStatus;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
@DecoratedWith(JobMapperDecorator.class)
public interface JobMapper {

	JobDto jobToJobDto(Job src);

	Job jobDtoToJob(JobDto src);

	List<JobDto> jobsToJobDtos(List<Job> src);

	@Mappings({ @Mapping(source = "idPais", target = "idPais"),
		@Mapping(source = "idCadena", target = "idCadena"),
		@Mapping(source = "idTienda", target = "idTienda"),
		@Mapping(source = "idEmpleado", target = "idEmpleado"),
		@Mapping(source = "idUsuario", target = "idUsuario")})
	JobDto scheduleDtoToJobDto(ScheduleDto src);

	List<JobDto> scheduleDTOsToJobDTOs(List<ScheduleDto> src);

	JobStatusDto JobStatusToJobStatusDto(JobStatus src);

	JobStatus JobStatusDtoToJobStatus(JobStatusDto src);
	
}