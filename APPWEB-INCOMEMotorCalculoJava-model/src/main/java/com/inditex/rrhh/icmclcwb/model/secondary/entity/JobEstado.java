package com.inditex.rrhh.icmclcwb.model.secondary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

//@Entity
@Table(name = "TEST_INCOME_JOB_ESTADO")
@Data
public class JobEstado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private /* BigInteger */ Long id;

	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

}