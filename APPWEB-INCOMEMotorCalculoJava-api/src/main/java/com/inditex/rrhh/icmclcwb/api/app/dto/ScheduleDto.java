package com.inditex.rrhh.icmclcwb.api.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

import java.io.Serializable;

@Data
public class ScheduleDto implements Serializable {

	private static final long serialVersionUID = 3665361916795418905L;

	private Integer id;

	@Size(max = 20)
	@NotEmpty
	@NotNull
	@NotBlank
	private String name;

}