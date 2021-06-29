/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;

/**
 * @author mdelrio
 *
 */
public interface MailService {

    void sendMailMotivos(final RunTareaDto runTarea);

    /**
     * @param tareaFase
     * @param fallidas
     * @param tarea
     */
    void sendMail(TareaFaseDto tareaFase, List<ValidacionDto> fallidas, RunTareaDto runTarea);

}
