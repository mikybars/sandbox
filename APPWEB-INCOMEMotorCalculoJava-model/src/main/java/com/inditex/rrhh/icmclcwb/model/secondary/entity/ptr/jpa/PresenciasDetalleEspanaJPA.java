package com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.jpa;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "PRESENCIAS_HORARIOS")
@Data
public class PresenciasDetalleEspanaJPA {
		@Id
		@Column(name = "ID")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(name = "TIPO", nullable = false)
		private Integer tipo;

		@Column(name = "TIENDA", nullable = false)
		private Integer tienda;

		@Column(name = "FECHA", nullable = false)
		private Date fecha;

		@Column(name = "SECCION", nullable = true)
		private Integer seccion;
		
		@Column(name = "PERSONA", nullable = true)
		private Integer persona;
		
		@Column(name = "HORAS", nullable = true)
		private Integer horas;//DUDA
		
		@Column(name = "CCL_ID_ORIGEN", nullable = true)
		private Integer ccl_id_origen;
}
