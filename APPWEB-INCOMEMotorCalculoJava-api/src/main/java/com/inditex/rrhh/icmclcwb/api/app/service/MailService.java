/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;

/**
 * @author mdelrio
 *
 */
public interface MailService {

    /**
     * @param tareaFase
     * @param fallidas
     */
    void sendMail(TareaFaseDto tareaFase, List<ValidacionDto> fallidas);

    void sendMailMotivos();

}
