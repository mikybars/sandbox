package com.inditex.rrhh.icmclcwb.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

import java.io.Serializable;

@Data
public class SolrQueueDTO implements Serializable {

	private static final long serialVersionUID = -8476952044051615476L;

	private Integer id;

	@Size(max = 20)
	@NotEmpty
	private String name;

}