/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.MailService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

/**
 * @author mdelrio
 *
 */
@Service
@Validated
public class MailServiceImpl implements MailService {

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

    private static final String LINE_BREAK = " \n";

    private static final String DOUBLE_LINE_BREAK = " \n\n";

    private static final String SEPARATOR = " - ";

    private static final String APP = "[INCOME][CALC]";

    private static final String SUBJECT = "Error validating task: ";

    private static final String SUBJECT_MOTIVOS = "Error validating displacement reasons ";

    private static final String SCOPE = "Task scope: ";

    private static final String STD_ID_LEG_ENT = "Company: ";

    private static final String PERIOD = "Period: ";

    private static final String ORIGIN = "Origin: ";

    private static final String TITLE = "Dear INCOME administrator: ";

    private static final String KIND_REGARDS = "Kind regards ";

    private static final String ERROR_LIST = "List of errors: ";

    private static final String TITLE_MOTIVOS = "There are unsynchronized displacement reasons";


    @Override
    public void sendMail(final TareaFaseDto tareaFase, final List<ValidacionDto> fallidas, final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        final TrabajoDto trabajo = runTarea.getTrabajo();

        final StringBuilder result = new StringBuilder();
        result.append(TITLE);
        result.append(DOUBLE_LINE_BREAK);
        result.append(SCOPE);
        result.append(tarea.getIdOrganization());
        result.append(LINE_BREAK);
        result.append(ORIGIN);
        result.append(
                trabajo.getOrigen().stream().map(TrabajoAmbitoOrigenDto::getCclIdOrigen).collect(Collectors.toList()));
        result.append(LINE_BREAK);
        result.append(STD_ID_LEG_ENT);
        result.append(tarea.getStdIdLegEnt());
        result.append(LINE_BREAK);
        result.append(PERIOD);
        result.append(trabajo.getIcmIdPeriodo());
        result.append(DOUBLE_LINE_BREAK);
        result.append(ERROR_LIST);
        result.append(DOUBLE_LINE_BREAK);
        fallidas.stream().forEach(e -> {
            final TareaFaseAccionDto tareaFaseAccion = this.tareaFaseAccionService
                .findById(e.getIdTareaFaseAccion());
            final AccionDto accion = this.accionService
                .findAccionDtoById(tareaFaseAccion.getIdAccion());
            result.append(accion.getDescripcion());
            if ((e.getIdPersonaLocal() != null) && !e.getIdPersonaLocal().isEmpty()) {
                result.append(SEPARATOR);
                result.append(e.getIdPersonaLocal());
            }
            result.append(DOUBLE_LINE_BREAK);
        });
        result.append(KIND_REGARDS);

        final SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(this.sender);
        message.setTo(this.receiver);

        message.setSubject(new StringBuilder(APP)
            .append(SEPARATOR)
            .append(this.environment.toUpperCase())
            .append(SEPARATOR)
            .append(tarea.getIdOrganization())
            .append(SEPARATOR)
            .append(SUBJECT)
            .append(SEPARATOR)
            .append(tareaFase.getIdTarea())
            .toString());
        message.setText(result.toString());

        this.mailSender.send(message);
    }

    @Override
    public void sendMailMotivos(final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        final StringBuilder result = new StringBuilder();
        result.append(TITLE_MOTIVOS);
        result.append(LINE_BREAK);

        final SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(this.sender);
        message.setTo(this.receiver);
        message.setSubject(new StringBuilder(APP)
            .append(SEPARATOR)
            .append(this.environment.toUpperCase())
            .append(SEPARATOR)
            .append(SUBJECT_MOTIVOS)
            .append(SEPARATOR)
            .append(tarea.getIdOrganization())
            .toString());
        message.setText(result.toString());

        this.mailSender.send(message);
    }

}
