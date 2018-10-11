package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ScheduleJobDto implements Serializable {

	private static final long serialVersionUID = 3665361916795418905L;

	private ScheduleDto schedule;

	private JobDto job;

}