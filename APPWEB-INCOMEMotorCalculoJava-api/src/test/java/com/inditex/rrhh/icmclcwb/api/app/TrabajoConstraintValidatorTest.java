package com.inditex.rrhh.icmclcwb.api.app;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import javax.validation.ConstraintValidatorContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.annotation.TrabajoConstraintValidator;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

@RunWith(MockitoJUnitRunner.class)
public class TrabajoConstraintValidatorTest {

    private static final String CCL_ID_PERSON = "4724";
    private static final String STD_ID_WORK_LOCAT = "T3113";
    private static final String STD_ID_LEG_ENT = "95";
    private static final String ID_ORGANIZATION = "AT";
    private static final String CCL_ID_ORIGEN = "38";

    @Mock
    private Logger log;
    
    private ConstraintValidatorContext constraintValidatorContext;
    private ConstraintValidatorContext.ConstraintViolationBuilder constraintViolationBuilder = mock(ConstraintValidatorContext.ConstraintViolationBuilder.class);
    private TrabajoConstraintValidator trabajoValidator;
    
    @Before
    public void setUp() {
        constraintValidatorContext = mock(ConstraintValidatorContext.class);
        trabajoValidator = new TrabajoConstraintValidator();
        constraintViolationBuilder = mock(ConstraintValidatorContext.ConstraintViolationBuilder.class);
        when(constraintValidatorContext.buildConstraintViolationWithTemplate(Mockito.anyString())).thenReturn(constraintViolationBuilder);
    }

    @Test
    public void testTrabajoSociedad() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.SOCIEDAD.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(true));
    }
    
    @Test
    public void testTrabajoSociedadOrigenNotEmpty() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.SOCIEDAD.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(false));
    }
    
    @Test
    public void testTrabajoSociedadEmpresaNotEmpty() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.SOCIEDAD.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(false));
    }
    
    @Test
    public void testRunTrabajoSociedad() {
        RunTrabajoDto runTrabajo = new RunTrabajoDto();
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.SOCIEDAD.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        runTrabajo.setTrabajo(trabajo);
        assertThat(trabajoValidator.isValid(runTrabajo, constraintValidatorContext), is(true));
    }
    
    @Test
    public void testTrabajoOrigen() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.ORIGEN.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(true));
    }
    
    @Test
    public void testTrabajoOrigenOrigenEmpty() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.ORIGEN.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList());
        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(false));
    }
    
    @Test
    public void testTrabajoOrigenEmpresaNotEmpty() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.ORIGEN.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(false));
    }
    
    @Test
    public void testRunTrabajoOrigen() {
        RunTrabajoDto runTrabajo = new RunTrabajoDto();
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.ORIGEN.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        runTrabajo.setTrabajo(trabajo);
        assertThat(trabajoValidator.isValid(runTrabajo, constraintValidatorContext), is(true));
    }
    
    @Test
    public void testTrabajoEmpresa() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.EMPRESA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(true));
    }
    
    @Test
    public void testTrabajoEmpresaOrigenEmpty() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.EMPRESA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList());
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(false));
    }
    
    @Test
    public void testTrabajoEmpresaOrigenEmpresaEmpty() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.EMPRESA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList());
        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(false));
    }
    
    @Test
    public void testTrabajoEmpresaLocalizacionNotEmpty() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.EMPRESA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setLocalizacion(Arrays.asList(TrabajoAmbitoLocalizacionDto.builder().stdIdWorkLocat(STD_ID_WORK_LOCAT).build()));
        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(false));
    }
    
    @Test
    public void testTrabajoEmpresaPersonaNotEmpty() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.EMPRESA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setPersona(Arrays.asList(TrabajoAmbitoPersonaDto.builder().cclIdPerson(CCL_ID_PERSON).build()));
        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(false));
    }
    
    
    
    @Test
    public void testTrabajoLocalizacion() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.LOCALIZACION.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setLocalizacion(Arrays.asList(TrabajoAmbitoLocalizacionDto.builder().stdIdWorkLocat(STD_ID_WORK_LOCAT).build()));

        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(true));
    }
    
    @Test
    public void testTrabajoLocalizacionOrigenEmpty() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.LOCALIZACION.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList());
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setLocalizacion(Arrays.asList(TrabajoAmbitoLocalizacionDto.builder().stdIdWorkLocat(STD_ID_WORK_LOCAT).build()));

        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(false));
    }
    
    @Test
    public void testTrabajoLocalizacionEmpresaEmpty() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.LOCALIZACION.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList());
        trabajo.setLocalizacion(Arrays.asList(TrabajoAmbitoLocalizacionDto.builder().stdIdWorkLocat(STD_ID_WORK_LOCAT).build()));

        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(false));
    }
    
    @Test
    public void testTrabajoLocalizacionLocalizacionEmpty() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.LOCALIZACION.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setLocalizacion(Arrays.asList());

        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(false));
    }
    
    @Test
    public void testTrabajoLocalizacionExistsPersona() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.LOCALIZACION.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setLocalizacion(Arrays.asList(TrabajoAmbitoLocalizacionDto.builder().stdIdWorkLocat(STD_ID_WORK_LOCAT).build()));
        trabajo.setPersona(Arrays.asList(TrabajoAmbitoPersonaDto.builder().cclIdPerson(CCL_ID_PERSON).build()));

        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(false));
    }
    
    @Test
    public void testTrabajoPersona() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.PERSONA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setPersona(Arrays.asList(TrabajoAmbitoPersonaDto.builder().cclIdPerson(CCL_ID_PERSON).build()));

        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(true));
    }
    
    @Test
    public void testTrabajoPersonaOrigenEmpty() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.PERSONA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList());
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setPersona(Arrays.asList(TrabajoAmbitoPersonaDto.builder().cclIdPerson(CCL_ID_PERSON).build()));

        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(false));
    }
    
    @Test
    public void testTrabajoPersonaEmpresaEmpty() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.PERSONA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList());
        trabajo.setPersona(Arrays.asList(TrabajoAmbitoPersonaDto.builder().cclIdPerson(CCL_ID_PERSON).build()));

        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(false));
    }
    
    @Test
    public void testTrabajoPersonaPersonaEmpty() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.PERSONA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setPersona(Arrays.asList());

        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(false));
    }
    
    @Test
    public void testTrabajoPersonaContainsLocalizacion() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.PERSONA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setPersona(Arrays.asList(TrabajoAmbitoPersonaDto.builder().cclIdPerson(CCL_ID_PERSON).build()));
        trabajo.setLocalizacion(Arrays.asList(TrabajoAmbitoLocalizacionDto.builder().stdIdWorkLocat(STD_ID_WORK_LOCAT).build()));

        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(false));
    }
}
