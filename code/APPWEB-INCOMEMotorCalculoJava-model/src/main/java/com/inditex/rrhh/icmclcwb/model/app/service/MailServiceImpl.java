package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.MailService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.AccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.MailAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioResponseDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class MailServiceImpl implements MailService {

  private static final String MAIL_1 = "iagoml@inditex.com";

  private static final String MAIL_2 = "marcosop@inditex.com";

  private static final String LINE_BREAK = " \n";

  private static final String DOUBLE_LINE_BREAK = " \n\n";

  private static final String SEPARATOR = " - ";

  private static final String OPEN_PARENTHESIS = "(";

  private static final String CLOSE_PARENTHESIS = ")";

  private static final String APP = "INCOME";

  private static final String CALCULATION_RESULTS = "Calculation results ";

  private static final String SUBJECT = "Validation task ";

  private static final String SUBJECT_MOTIVOS = "Error validating displacement reasons ";

  private static final String PERIOD = "Some errors occurred while running the ";

  private static final String PERIOD_END = " commission calculation for the period: ";

  private static final String TITLE = "Dear INCOME user: ";

  private static final String KIND_REGARDS = "Kind regards ";

  private static final String ERROR_LIST = "List of errors: ";

  private static final String AFFECTED_EMPLOYEES_LIST = "List of affected employees: ";

  private static final String TITLE_MOTIVOS = "There are unsynchronized displacement reasons";

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

  @Autowired
  private MailSender mailSender;

  @Autowired
  private AccionService accionService;

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Autowired
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Autowired
  private MailAmbitoService mailAmbitoService;

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

    final List<String> mails = new ArrayList<>();
    runTarea.getTarea().getAmbito().stream()
        .map(x -> this.mailAmbitoService.getMailByCclIdOrigenAndStdIdLegEnt(x.getCclIdOrigen(), runTarea.getTarea().getStdIdLegEnt()))
        .forEachOrdered(mails::addAll);

    message.setCc(mails.stream().toArray(String[]::new));

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

    final List<String> mails = new ArrayList<>();
    runTarea.getTarea().getAmbito().stream()
        .map(x -> this.mailAmbitoService.getMailByCclIdOrigenAndStdIdLegEnt(x.getCclIdOrigen(), runTarea.getTarea().getStdIdLegEnt()))
        .forEachOrdered(mails::addAll);

    message.setCc(mails.stream().toArray(String[]::new));

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

}
