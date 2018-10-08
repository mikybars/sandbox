package com.inditex.rrhh.icmclcwb.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

import java.io.Serializable;

@Data
public class JobDTO implements Serializable {

	private static final long serialVersionUID = -5607507260079003307L;

	private Integer id;

	@Size(max = 20)
	@NotEmpty
	private String name;

}