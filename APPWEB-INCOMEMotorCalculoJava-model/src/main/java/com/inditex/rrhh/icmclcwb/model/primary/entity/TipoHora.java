package com.inditex.rrhh.icmclcwb.model.primary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "INCOME_TIPO_HORA", schema = "DESARROLLO_RRHH")
@Data
public class TipoHora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIPO_HORA")
	private /* BigInteger */ Long id;

	@Column(name = "COMISIONABLE", nullable = false)
	private Boolean comisionable;

}