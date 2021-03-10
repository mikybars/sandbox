/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.service.MailService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;

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

    @Autowired
    private MailSender mailSender;

    @Autowired
    private AccionService accionService;

    @Autowired
    private TareaFaseAccionService tareaFaseAccionService;

    private static final String LINE_BREAK = "\n";

    private static final String DOUBLE_LINE_BREAK = " \n\n";

    private static final String SEPARATOR = " - ";

    private static final String SUBJECT = "[INCOME][CALC] - Error validating task: ";

    private static final String SUBJECT_MOTIVOS = "[INCOME][CALC] - Error validating displacement reasons ";

    private static final String TITLE = "List of errors:";

    private static final String TITLE_MOTIVOS = "There are unsynchronized displacement reasons";


    @Override
    public void sendMail(final TareaFaseDto tareaFase, final List<ValidacionDto> fallidas) {
        final StringBuilder result = new StringBuilder();
        result.append(TITLE);
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

        final SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(this.sender);
        message.setTo(this.receiver);
        message.setSubject(new StringBuilder(SUBJECT)
            .append(tareaFase.getIdTarea())
            .toString());
        message.setText(result.toString());

        this.mailSender.send(message);
    }

    @Override
    public void sendMailMotivos() {
        final StringBuilder result = new StringBuilder();
        result.append(TITLE_MOTIVOS);
        result.append(LINE_BREAK);

        final SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(this.sender);
        message.setTo(this.receiver);
        message.setSubject(new StringBuilder(SUBJECT_MOTIVOS)
            .toString());
        message.setText(result.toString());

        this.mailSender.send(message);
    }

}
