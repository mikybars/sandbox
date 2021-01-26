/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ComisService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.comis.repository.ClientDatabase;
import com.inditex.rrhh.icmclcwb.model.comis.repository.ClientDatabaseContextHolder;
import com.inditex.rrhh.icmclcwb.model.comis.repository.ComisRepositoryCustom;

@Service
@Validated
public class ComisServiceImpl implements ComisService {

    @Autowired
    private ComisRepositoryCustom comisRepositoryCustom;

    @Override
    public PresenciaOrigenDto findPresenciasOrigenAndFecha(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        PresenciaOrigenDto presencia = null;
        try {
            ClientDatabaseContextHolder
                .set(ClientDatabase.getClient(tareaAmbito.getCclIdOrigen()));
            presencia = this.comisRepositoryCustom
                .findPresenciasOrigenAndFecha(runTareaDto.getTarea());
        } finally {
            ClientDatabaseContextHolder.clear();
        }

        return presencia;
    }

    @Override
    public List<IdMotivoDesplazamientoDto> findMotivoDesplazamiento(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<IdMotivoDesplazamientoDto> motivos = null;
        try {
            ClientDatabaseContextHolder
                .set(ClientDatabase.getClient(tareaAmbito.getCclIdOrigen()));
            motivos = this.comisRepositoryCustom
                .findMotivoDesplazamiento(runTareaDto.getTarea());
        } finally {
            ClientDatabaseContextHolder.clear();
        }

        return motivos;
    }

    @Override
    public List<IdPersonaLocalFechaIncidenciaDto> findFechasIncidencias(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<IdPersonaLocalFechaIncidenciaDto> incidencias = null;
        try {
            ClientDatabaseContextHolder
                .set(ClientDatabase.getClient(tareaAmbito.getCclIdOrigen()));
            incidencias = this.comisRepositoryCustom
                .findFechasIncidencias(runTareaDto.getTarea());
        } finally {
            ClientDatabaseContextHolder.clear();
        }

        return incidencias;
    }

    @Override
    public List<IdPersonaLocalFechaIncidenciaDto> findFechasDesplazamientos(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<IdPersonaLocalFechaIncidenciaDto> desplazamientos = null;
        try {
            ClientDatabaseContextHolder
                .set(ClientDatabase.getClient(tareaAmbito.getCclIdOrigen()));
            desplazamientos = this.comisRepositoryCustom
                .findFechasDesplazamientos(runTareaDto.getTarea());
        } finally {
            ClientDatabaseContextHolder.clear();
        }

        return desplazamientos;
    }

    @Override
    public List<IdPersonaLocalCondicionesDto> findCondicionesHistorico(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<IdPersonaLocalCondicionesDto> historico = null;
        try {
            ClientDatabaseContextHolder
                .set(ClientDatabase.getClient(tareaAmbito.getCclIdOrigen()));
            historico = this.comisRepositoryCustom
                .findCondicionesHistorico(runTareaDto.getTarea());
        } finally {
            ClientDatabaseContextHolder.clear();
        }

        return historico;
    }

    @Override
    public List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamiento(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<IdPersonaLocalCondicionesDto> desplazamiento = null;
        try {
            ClientDatabaseContextHolder
                .set(ClientDatabase.getClient(tareaAmbito.getCclIdOrigen()));
            desplazamiento = this.comisRepositoryCustom
                .findCondicionesHistorico(runTareaDto.getTarea());
        } finally {
            ClientDatabaseContextHolder.clear();
        }

        return desplazamiento;
    }

    @Override
    public List<IdPersonaLocalCondicionesDto> findCondicionesResalta(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<IdPersonaLocalCondicionesDto> resalta = null;
        try {
            ClientDatabaseContextHolder
                .set(ClientDatabase.getClient(tareaAmbito.getCclIdOrigen()));
            resalta = this.comisRepositoryCustom
                .findCondicionesResalta(runTareaDto.getTarea());
        } finally {
            ClientDatabaseContextHolder.clear();
        }

        return resalta;
    }

    @Override
    public List<IdPersonaLocalCondicionesDto> findBajasIt(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<IdPersonaLocalCondicionesDto> bajasIt = null;
        try {
            ClientDatabaseContextHolder
                .set(ClientDatabase.getClient(tareaAmbito.getCclIdOrigen()));
            bajasIt = this.comisRepositoryCustom
                .findBajasIt(runTareaDto.getTarea());
        } finally {
            ClientDatabaseContextHolder.clear();
        }

        return bajasIt;
    }

    @Override
    public List<IdPersonaLocalCarenciaDto> findCarencia(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<IdPersonaLocalCarenciaDto> carencia = null;
        try {
            ClientDatabaseContextHolder
                .set(ClientDatabase.getClient(tareaAmbito.getCclIdOrigen()));
            carencia = this.comisRepositoryCustom
                .findCarencia(runTareaDto.getTarea());
        } finally {
            ClientDatabaseContextHolder.clear();
        }

        return carencia;
    }

}
