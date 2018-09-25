package com.inditex.rrhh.icmclcwb.model.primary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "PAIS", schema = "MAESTROS")
@Data
public class Pais {
    
	@Id
	@Column(name = "ID_PAIS")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    
	@Column(name = "DESCRIPCION", nullable = false)
	@NotBlank
    private String descripcion;
	
}