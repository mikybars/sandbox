package com.inditex.rrhh.icmclcwb.model.app.service;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDefinitionHelper implements Serializable{
	
	private static final long serialVersionUID = 6425914414078832869L;
	
	private Object service;
	private Class[] objectType;
	private Object[] objectParams;
	private String methodName;

}
