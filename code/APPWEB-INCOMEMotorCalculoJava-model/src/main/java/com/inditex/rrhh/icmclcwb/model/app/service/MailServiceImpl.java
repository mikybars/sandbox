package com.inditex.rrhh.icmclcwb.model.app.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.ReglaValidacionExcedidoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.MailService;
import com.inditex.rrhh.icmclcwb.api.app.service.ReglaValidacionExcedidoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.AccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.MailAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.MailEntornoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioResponseDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

  private static final String MAIL_1 = "iagoml@inditex.com";

  private static final String MAIL_2 = "marcosop@inditex.com";

  private static final String LINE_BREAK = " \n";

  private static final String DOUBLE_LINE_BREAK = " \n\n";

  private static final String SEPARATOR = " - ";

  private static final String OPEN_PARENTHESIS = "(";

  private static final String CLOSE_PARENTHESIS = ")";

  private static final String DOT = ".";

  private static final String APP = "INCOME";

  private static final String CALCULATION_RESULTS = "Calculation results ";

  private static final String CALCULATION_ALERTS = "Calculation alerts ";

  private static final String SUBJECT = "Validation task ";

  private static final String SUBJECT_MOTIVOS = "Error validating displacement reasons ";

  private static final String PERIOD = "Some errors occurred while running the ";

  private static final String PERIOD_END = " commission calculation for the period: ";

  private static final String PERIOD_ALERTS = "The following alerts were generated while running the ";

  private static final String TITLE = "Dear INCOME user: ";

  private static final String KIND_REGARDS = "Kind regards ";

  private static final String ERROR_LIST = "List of errors: ";

  private static final String ALERTS_LIST = "List of alerts: ";

  private static final String AFFECTED_EMPLOYEES_LIST = "List of affected employees: ";

  private static final String TOTAL_AFFECTED_EMPLOYEES = "Total affected employees: ";

  private static final String TITLE_MOTIVOS = "There are unsynchronized displacement reasons";

  private static final String BODY_ALERT_PENDING = "Validation: Employees with a \"Pending\" calculation type.";

  private static final String BODY_ALERT_EXCEEDED_LIMIT = "Validation: Daily commission limit exceeded for GT/GS types ";

  private static final String BODY_ALERT_PERCENTAGE_ZERO = "Validation: Employees with 0% percentage table in all sections.";

  private static final String TIPO_CALCULO_GT = "001";

  private static final String TIPO_CALCULO_GS = "002";

  private static final String LABEL_GT = "GT: €";

  private static final String LABEL_GS = "GS: €";

  private static final String COMMA_SEPARATOR = ", ";

  private static final String CONTACT = "Please, contact the support team with this email at income@inditex.com.";

  private static final String OVERLAPPED =
      " Please, check these employees for inverted or overlapped dates in SIL, correct them, and then run the calculation again.";

  private static final String HOURS = " The data is now syncing, please wait a few minutes and then run the calculation again..";

  @Value("${app.envars.mail.sender}")
  private String sender;

  @Value("${app.envars.mail.receiver}")
  private String receiver;

  @Value("${metadata.environment}")
  private String environment;

  private final MailSender mailSender;

  private final AccionService accionService;

  private final TareaFaseAccionService tareaFaseAccionService;

  private final Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  private final MailAmbitoService mailAmbitoService;

  private final MailEntornoService mailEntornoService;

  private final ReglaValidacionExcedidoService reglaValidacionExcedidoService;

  @Override
  public void sendMail(final List<ValidacionDto> fallidas, final RunTareaDto runTarea) {
    final TareaDto tarea = runTarea.getTarea();
    final TrabajoDTO trabajo = runTarea.getTrabajo();

    final StringBuilder result = new StringBuilder();
    result.append(TITLE);
    result.append(DOUBLE_LINE_BREAK);
    result.append(PERIOD).append(tarea.getIdOrganization().equalsIgnoreCase("0001") ? "ES" : tarea.getIdOrganization())
        .append(PERIOD_END);
    result.append(trabajo.getFechaInicioPeriodo().toLocalDate()).append(SEPARATOR).append(trabajo.getFechaFinPeriodo().toLocalDate());
    result.append(DOUBLE_LINE_BREAK);
    result.append(ERROR_LIST);
    result.append(DOUBLE_LINE_BREAK);

    fallidas.stream().forEach(e -> {
      final TareaFaseAccionDto tareaFaseAccion = this.tareaFaseAccionService
          .findById(e.getIdTareaFaseAccion());
      final AccionDto accion = this.accionService
          .findAccionDtoById(tareaFaseAccion.getIdAccion());
      result.append(accion.getDescripcion());
      if (accion.getId().equals(AccionEnum.FECHAS.getId())) {
        result.append(OVERLAPPED);
      } else if (accion.getId().equals(AccionEnum.PRESENCIAS.getId())) {
        result.append(HOURS);
      } else {
        result.append(CONTACT);
      }
      if ((e.getIdPersonaLocal() != null) && !e.getIdPersonaLocal().isEmpty()) {
        result.append(SEPARATOR);
        result.append(AFFECTED_EMPLOYEES_LIST);
        result.append(e.getIdPersonaLocal());
      }
      result.append(DOUBLE_LINE_BREAK);
    });
    result.append(KIND_REGARDS);

    final SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(this.sender);
    message.setTo(this.receiver);
    if (!trabajo.getNombreUsuario().trim().equalsIgnoreCase("srvcicmclcwbax")) {
      final UsuarioResponseDto usuario = this.meta4IcmWsCalcIncomeService
          .getMail(UsuarioRequestDto
              .builder()
              .idUsuario(trabajo.getNombreUsuario())
              .build());
      if (usuario != null && !usuario.getItems().isEmpty() && !usuario.getItems().get(0).getMail().isEmpty()) {
        message.setCc(usuario.getItems().get(0).getMail());
      }

    }

    if (Boolean.TRUE.equals(this.mailEntornoService.findEsActivoByEntorno(this.environment))) {
      final List<String> mails = new ArrayList<>();
      runTarea.getTarea().getAmbito().stream()
          .map(x -> this.mailAmbitoService.getMailByCclIdOrigenAndStdIdLegEnt(x.getCclIdOrigen(), runTarea.getTarea().getStdIdLegEnt()))
          .forEachOrdered(mails::addAll);

      message.setCc(mails.stream().toArray(String[]::new));
    }
    message.setSubject(APP
        + SEPARATOR
        + CALCULATION_RESULTS
        + tarea.getIdOrganization()
        + (this.environment.equalsIgnoreCase("PRO") ? " " : SEPARATOR + this.environment.toUpperCase() + SEPARATOR)
        + SUBJECT
        + OPEN_PARENTHESIS
        + tarea.getId()
        + CLOSE_PARENTHESIS);
    message.setText(result.toString());

    this.mailSender.send(message);
  }

  @Override
  public void sendMailMotivos(final RunTareaDto runTarea, final List<ValidacionDto> fallidas) {
    final TareaDto tarea = runTarea.getTarea();
    final String result = TITLE_MOTIVOS
        + LINE_BREAK
        + fallidas.stream().filter(e -> e.getIdMotivosDesplazamiento() != null && e.getIdMotivosDesplazamiento().size() > 0)
            .map(e -> e.getIdMotivosDesplazamiento()).collect(Collectors.toList());

    final SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(this.sender);
    message.setTo(MAIL_1, MAIL_2);
    if (this.environment.equalsIgnoreCase("PRO")) {
      message.setTo(MAIL_1, MAIL_2);
    } else {
      message.setTo(this.receiver);
    }

    if (Boolean.TRUE.equals(this.mailEntornoService.findEsActivoByEntorno(this.environment))) {
      final List<String> mails = new ArrayList<>();
      runTarea.getTarea().getAmbito().stream()
          .map(x -> this.mailAmbitoService.getMailByCclIdOrigenAndStdIdLegEnt(x.getCclIdOrigen(), runTarea.getTarea().getStdIdLegEnt()))
          .forEachOrdered(mails::addAll);

      message.setCc(mails.stream().toArray(String[]::new));
    }
    message.setSubject(APP
        + SEPARATOR
        + this.environment.toUpperCase()
        + SEPARATOR
        + SUBJECT_MOTIVOS
        + SEPARATOR
        + tarea.getIdOrganization());
    message.setText(result);

    this.mailSender.send(message);
  }

  @Override
  public void sendMailValidacionesAgrupadas(final List<ValidacionDto> validacionesParaNotificar, final RunTareaDto runTarea) {
    final TareaDto tarea = runTarea.getTarea();
    final TrabajoDTO trabajo = runTarea.getTrabajo();

    final String messageBody = this.buildValidacionesAgrupadasBody(validacionesParaNotificar, tarea, trabajo);
    final SimpleMailMessage message = this.createValidacionesAgrupadasMessage(runTarea, messageBody);

    this.mailSender.send(message);
  }

  private String buildValidacionesAgrupadasBody(final List<ValidacionDto> validacionesParaNotificar,
      final TareaDto tarea, final TrabajoDTO trabajo) {
    final StringBuilder result = new StringBuilder();
    result.append(TITLE);
    result.append(DOUBLE_LINE_BREAK);
    result.append(PERIOD_ALERTS).append(tarea.getIdOrganization().equalsIgnoreCase("0001") ? "ES" : tarea.getIdOrganization())
        .append(PERIOD_END);
    result.append(trabajo.getFechaInicioPeriodo().toLocalDate()).append(SEPARATOR).append(trabajo.getFechaFinPeriodo().toLocalDate());
    result.append(DOUBLE_LINE_BREAK);
    result.append(ALERTS_LIST);
    result.append(DOUBLE_LINE_BREAK);

    final Map<Integer, List<ValidacionDto>> validacionesPorAccion = this.agruparValidacionesPorAccion(validacionesParaNotificar);

    this.appendValidacion32(result, validacionesPorAccion.getOrDefault(32, List.of()), tarea);
    this.appendValidacion33(result, validacionesPorAccion.getOrDefault(33, List.of()));
    this.appendValidacion34(result, validacionesPorAccion.getOrDefault(34, List.of()));

    result.append(KIND_REGARDS);
    return result.toString();
  }

  private Map<Integer, List<ValidacionDto>> agruparValidacionesPorAccion(final List<ValidacionDto> validaciones) {
    return validaciones.stream()
        .collect(Collectors.groupingBy(v -> this.tareaFaseAccionService.findById(v.getIdTareaFaseAccion()).getIdAccion()));
  }

  private void appendValidacion32(final StringBuilder result, final List<ValidacionDto> validaciones, final TareaDto tarea) {
    if (validaciones.isEmpty()) {
      return;
    }

    final String limites = this.buildLimitesExcedidos(tarea);
    result.append(BODY_ALERT_EXCEEDED_LIMIT);
    if (!limites.isEmpty()) {
      result.append(OPEN_PARENTHESIS).append(limites).append(CLOSE_PARENTHESIS).append(DOT);
    }
    this.appendValidacionDetails(result, validaciones.get(0));
  }

  private String buildLimitesExcedidos(final TareaDto tarea) {
    final List<ReglaValidacionExcedidoDto> reglas = this.reglaValidacionExcedidoService
        .findByCclIdOrigenAndStdIdLegEnt(tarea.getAmbito().get(0).getCclIdOrigen(), tarea.getStdIdLegEnt());

    final Map<String, BigDecimal> maxImportesPorTipo = reglas.stream()
        .collect(Collectors.groupingBy(
            ReglaValidacionExcedidoDto::getIdTipoCalculo,
            Collectors.mapping(ReglaValidacionExcedidoDto::getImporte,
                Collectors.maxBy(BigDecimal::compareTo))))
        .entrySet().stream()
        .filter(e -> e.getValue().isPresent())
        .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().get()));

    final StringBuilder limites = new StringBuilder();
    if (maxImportesPorTipo.containsKey(TIPO_CALCULO_GT)) {
      limites.append(LABEL_GT).append(maxImportesPorTipo.get(TIPO_CALCULO_GT).intValue());
    }
    if (maxImportesPorTipo.containsKey(TIPO_CALCULO_GS)) {
      if (!limites.isEmpty()) {
        limites.append(COMMA_SEPARATOR);
      }
      limites.append(LABEL_GS).append(maxImportesPorTipo.get(TIPO_CALCULO_GS).intValue());
    }
    return limites.toString();
  }

  private void appendValidacion33(final StringBuilder result, final List<ValidacionDto> validaciones) {
    if (validaciones.isEmpty()) {
      return;
    }
    result.append(BODY_ALERT_PENDING);
    this.appendValidacionDetails(result, validaciones.get(0));
  }

  private void appendValidacion34(final StringBuilder result, final List<ValidacionDto> validaciones) {
    if (validaciones.isEmpty()) {
      return;
    }
    result.append(BODY_ALERT_PERCENTAGE_ZERO);
    this.appendValidacionDetails(result, validaciones.get(0));
  }

  private void appendValidacionDetails(final StringBuilder result, final ValidacionDto validacion) {
    result.append(LINE_BREAK);
    result.append(SEPARATOR);
    result.append(TOTAL_AFFECTED_EMPLOYEES).append(validacion.getIdPersonaLocal().size());
    result.append(LINE_BREAK);
    result.append(SEPARATOR);
    result.append(AFFECTED_EMPLOYEES_LIST);
    result.append(validacion.getIdPersonaLocal());
    result.append(DOUBLE_LINE_BREAK);
  }

  private SimpleMailMessage createValidacionesAgrupadasMessage(final RunTareaDto runTarea, final String messageBody) {
    final TareaDto tarea = runTarea.getTarea();
    final TrabajoDTO trabajo = runTarea.getTrabajo();

    final SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(this.sender);
    message.setTo(this.receiver);

    this.addCcRecipients(message, trabajo, runTarea);

    message.setSubject(APP
        + SEPARATOR
        + CALCULATION_ALERTS
        + tarea.getIdOrganization()
        + (this.environment.equalsIgnoreCase("PRO") ? " " : SEPARATOR + this.environment.toUpperCase() + SEPARATOR)
        + SUBJECT
        + OPEN_PARENTHESIS
        + tarea.getId()
        + CLOSE_PARENTHESIS);
    message.setText(messageBody);

    return message;
  }

  private void addCcRecipients(final SimpleMailMessage message, final TrabajoDTO trabajo, final RunTareaDto runTarea) {
    if (!trabajo.getNombreUsuario().trim().equalsIgnoreCase("srvcicmclcwbax")) {
      final UsuarioResponseDto usuario = this.meta4IcmWsCalcIncomeService
          .getMail(UsuarioRequestDto.builder().idUsuario(trabajo.getNombreUsuario()).build());
      if (usuario != null && !usuario.getItems().isEmpty() && !usuario.getItems().get(0).getMail().isEmpty()) {
        message.setCc(usuario.getItems().get(0).getMail());
      }
    }

    if (Boolean.TRUE.equals(this.mailEntornoService.findEsActivoByEntorno(this.environment))) {
      final List<String> mails = new ArrayList<>();
      runTarea.getTarea().getAmbito().stream()
          .map(x -> this.mailAmbitoService.getMailByCclIdOrigenAndStdIdLegEnt(x.getCclIdOrigen(), runTarea.getTarea().getStdIdLegEnt()))
          .forEachOrdered(mails::addAll);
      message.setCc(mails.toArray(String[]::new));
    }
  }

}
