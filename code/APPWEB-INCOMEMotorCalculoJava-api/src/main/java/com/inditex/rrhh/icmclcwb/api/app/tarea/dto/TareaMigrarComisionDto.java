package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TareaMigrarComisionDto implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private long icmIdPeriodo;

  private long cclIdOrigen;

  private long stdIdLegEnt;

  private long cclIdPerson;

  private long stdOrHrPeriod;

  private int idEstado;

  private LocalDate fechaInicioPeriodo;

  private LocalDate fechaFinPeriodo;

  private LocalDate fecha;

  private long tiendaCalculo;

  private LocalDate fechaInicioEstructura;

  private LocalDate fechaFinEstructura;

  private long cclIdSeccion;

  private long banda;

  private float valor;

  private String icmIdTpComision;

  private String icmIdTpCalculo;

  private String icmGrupoManual;

  private long idTipoOpcionCalculo;

  private long cclIdCodOrigenDestino;

  private long codTipoHora;

  private long minutos;

  private long codTiendaPresenciaEmpleado;

  private long codSeccionPresenciaEmpleado;

  private long minutosTienda;

  private long codTiendaPresencia;

  private long codSeccionPresencia;

  private float importeTotal;

  private float importeTotalSinAjuste;

  private float importeAjusteTotal;

  private float importeFisica;

  private float importeFisicaSinAjuste;

  private float importeAjusteFisica;

  private float importeOnlineIpod;

  private float importeOnlineIpodSinAjuste;

  private float importeAjusteOnlineIpod;

  private float importeOnlineSint;

  private float importeOnlineSintSinAjuste;

  private float importeAjusteOnlineSint;

  private float importeOnlineEntregaTienda;

  private float importeOnlineEntregaTiendaSinAjuste;

  private float importeAjusteOnlineEntregaTienda;

  private float importeOnlineEntregaDomicilio;

  private float importeOnlineEntregaDomicilioSinAjuste;

  private float importeAjusteOnlineEntregaDomicilio;

  private float ventaTotal;

  private float ventaFisica;

  private float ventaOnlineIpod;

  private float ventaOnlineSint;

  private float ventaOnlineEntregaTienda;

  private float ventaOnlineEntregaDomicilio;

  private float objetivo;

  private int excepcionada;

  private int congelada;

  private float challengeVentaTotal;

  private float challengeVentaCaja;

  private float challengeDevoluciones;

  private float challengeVentaOnlineIpod;

  private float challengeVentaOnlinePicking;

  private float challengeVentaOnlineEntregaTienda;

  private float importeVentaFisicaIndividual;

  private float importeDevolucionFisicaIndividual;

  private float importeVentaOnlineIpod;

  private float importeDevolucionIndividualIpod;

  private float coeficienteReduccionJornada;

  private long icmCkIncIvaEvalPtpo;

  private long codSeccionBanda;

  private String tipoPorcentajePolitica;

  private long codTiendaBanda;
}
