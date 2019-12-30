package com.inditex.rrhh.icmclcwb.meta4;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4TestConstants;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcoefjornadaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfventaonlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadospresenciaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempresasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetestructurascomOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetestructuraspolOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetfestivosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetflagcalculaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetorigenesOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetperiodosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresenciamanualOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasempleadoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasincomeOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaestructuraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalestructuraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalestructuraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalorigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalorigenRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalperiodoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalperiodoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsociedadBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsociedadRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchtiendasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class Meta4ServiceTest {

    @Autowired
    @Qualifier("meta4ClientPool")
    private Meta4ClientPool meta4ClientPool;
    
    @Test
    public void getOrigenes() {
        IcmParamcalsociedadRecord record = new IcmParamcalsociedadRecord();
        record.setIdsociedad(Meta4TestConstants.ID_SOCIEDAD);
        IcmParamcalsociedadBlock param1 = new IcmParamcalsociedadBlock();
        param1.getIcmParamcalsociedadRecordSet().add(record);
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        GetorigenesOutput getorigenesOutput = meta4ClientPool.getorigenes(param1, param2);
        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getorigenesOutput.getReturn()));
    }
    
    @Test
    public void getEmpresas() {
        IcmParamcalorigenRecord record = new IcmParamcalorigenRecord();
        record.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        IcmParamcalorigenBlock param1 = new IcmParamcalorigenBlock();
        param1.getIcmParamcalorigenRecordSet().add(record);
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        GetempresasOutput getempresasOutput = meta4ClientPool.getempresas(param1, param2);
        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getempresasOutput.getReturn()));
    }
    
    @Test
    public void getConfVentaOnline() {
        IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
        record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
        IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
        param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
        param1.getIcmParametrosentradaRecordSet().add(record);
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        GetconfventaonlineOutput getconfventaonlineoutput = meta4ClientPool.getconfventaonline(param1, param2);
        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getconfventaonlineoutput.getReturn()));
    }
    
    @Test
    public void getCoefJornada() {
        IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
        record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
        IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
        param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
        param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
        param1.getIcmParametrosentradaRecordSet().add(record);
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        GetcoefjornadaOutput getcoefjornadaOutput = meta4ClientPool.getcoefjornada(param1, param2);
        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getcoefjornadaOutput.getReturn()));
    }

    @Test
    public void getFlagCalcula() {
        IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
        record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
        IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
        param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
        param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
        param1.getIcmParametrosentradaRecordSet().add(record);
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        GetflagcalculaOutput getflagcalculaOutput = meta4ClientPool.getflagcalcula(param1, param2);
        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getflagcalculaOutput.getReturn()));
    }

    @Test
    public void getFestivos() {
        IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
        record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
        IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
        param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
        param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
        param1.getIcmParametrosentradaRecordSet().add(record);
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        GetfestivosOutput getfestivosOutput = meta4ClientPool.getfestivos(param1, param2);
        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getfestivosOutput.getReturn()));
    }

    @Test
    public void getPeriodos() {
        IcmParamcalperiodoRecord record = new IcmParamcalperiodoRecord();
        record.setAbierto(Meta4Constants.TRUE);
        record.setActivo(Meta4Constants.TRUE);
        record.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        record.setVigente(Meta4Constants.TRUE);
        record.setIdsociedad(Meta4TestConstants.ID_SOCIEDAD);
        IcmParamcalperiodoBlock param1 = new IcmParamcalperiodoBlock();
        param1.getIcmParamcalperiodoRecordSet().add(record);
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        GetperiodosOutput getperiodosOutput = meta4ClientPool.getperiodos(param1, param2);
        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getperiodosOutput.getReturn()));
    }

    @Test
    public void getPresenciaManual() {
        IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
        record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
        IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
        param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
        param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
        param1.getIcmParametrosentradaRecordSet().add(record);
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        GetpresenciamanualOutput getpresenciamanualOutput = meta4ClientPool.getpresenciamanual(param1, param2);
        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getpresenciamanualOutput.getReturn()));
    }

    @Test
    public void getEmpleadosPresencia() {
        IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
        record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
        IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
        param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
        param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
        param1.getIcmParametrosentradaRecordSet().add(record);
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        GetempleadospresenciaOutput getempleadospresenciaOutput = meta4ClientPool.getempleadospresencia(param1, param2);
        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getempleadospresenciaOutput.getReturn()));
    }

    @Test
    public void getTiendasEmpleado() {
        IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
        record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
        IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
        param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
        param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
        param1.getIcmParametrosentradaRecordSet().add(record);
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
        param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
        param2.setIdbusqueda(StringUtils.EMPTY);
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        GettiendasempleadoOutput gettiendasempleadoOutput = meta4ClientPool.gettiendasempleado(param1, param2);
        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(gettiendasempleadoOutput.getReturn()));
    }

    @Test
    public void searchTiendas() {
        IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
        record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
        IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
        param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
        param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
        param1.getIcmParametrosentradaRecordSet().add(record);
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
        param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
        param2.setIdbusqueda(StringUtils.EMPTY);
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        SearchtiendasOutput searchTiendasOutput = meta4ClientPool.searchtiendas(param1, param2);
        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(searchTiendasOutput.getReturn()));
    }

    @Test
    public void getTiendas() {
        IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
        record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
        IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
        param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
        param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
        param1.getIcmParametrosentradaRecordSet().add(record);
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
        param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
        param2.setIdbusqueda(StringUtils.EMPTY);
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        GettiendasincomeOutput getTiendasIncome = meta4ClientPool.gettiendasincome(param2, param1);
        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getTiendasIncome.getReturn()));
    }

    @Test
    public void searchEmpleados() {
        IcmParamcalempleadoRecord record = new IcmParamcalempleadoRecord();
        record.setIdempleado(Meta4TestConstants.ID_PERSONA);
        IcmParamcalempleadoBlock param1 = new IcmParamcalempleadoBlock();
        param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
        param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
        param1.getIcmParamcalempleadoRecordSet().add(record);
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
        param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
        param2.setIdbusqueda(StringUtils.EMPTY);
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        SearchempleadosOutput searchEmpleadosOutput = meta4ClientPool.searchempleados(param2, param1);
        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(searchEmpleadosOutput.getReturn()));
    }

    @Test
    public void getComisionEmpleado() {
        IcmParamcalestructuraRecord record = new IcmParamcalestructuraRecord();
        record.setIdempleado("AT1010154");
        record.setOrempleado("1");
        IcmParamcalestructuraBlock param1 = new IcmParamcalestructuraBlock();
        param1.setIdorigen("38");
        param1.setFechainicio("2015-01-01");
        param1.setFechafin("2015-08-31");
        param1.getIcmParamcalestructuraRecordSet().add(record);
        GetestructurascomOutput getComisionEmpleadoOutput = meta4ClientPool.getestructurascom(param1);
        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getComisionEmpleadoOutput.getReturn()));
    }

    @Test
//    @Ignore("Sirve para buscar e imprimir en consola estructuras a partir de localizacion / origen")
    public void comprobarEstructurasTiendasOrigen() {

        IcmParamcalestructuraBlock paramEstructura = new IcmParamcalestructuraBlock();
        paramEstructura.setFechainicio("2017-01-01");
        paramEstructura.setFechafin("2018-12-31");

        IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
        param1.setFechainicio("2017-01-01");
        param1.setFechafin("2018-12-31");
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        param2.setNumeroregistrospagina("50");
        param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
        param2.setIdbusqueda(StringUtils.EMPTY);
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        List<String> lista = Arrays.asList("T1413", "T3188", "T3189", "T3273", "T3275", "T3323", "T3355", "T3474",
                "T3511", "T3682", "T3787", "T4330", "T4331", "T4352", "T4481", "T4578", "T8194", "T8195", "T8779",
                "T9092", "T9263", "T9930", "T9974");
        for (String tienda : lista) {
            param1.getIcmParametrosentradaRecordSet().clear();
            IcmParametrosentradaRecord record4 = new IcmParametrosentradaRecord();
            record4.setIdlugartrabajo(tienda);
            param1.getIcmParametrosentradaRecordSet().add(record4);
            GetempleadosOutput getEmpleadosOutput = meta4ClientPool.getempleados(param1, param2);
            List<IcmListaempleadosRecord> emprec = new ArrayList<>();
            emprec.addAll(getEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet());
            param1.setIdorigen("39");
            param1.getIcmParametrosentradaRecordSet().clear();
            List<IcmParamcalestructuraRecord> entradas2 = emprec.stream().map(obj -> {
                final IcmParamcalestructuraRecord obj2 = new IcmParamcalestructuraRecord();
                obj2.setIdempleado(obj.getIdempleado());
                obj2.setOrempleado(obj.getOrempleado());
                return obj2;
            }).collect(Collectors.toList());
            paramEstructura.getIcmParamcalestructuraRecordSet().addAll(entradas2);
            if (emprec.size() > 0) {
                GetestructurascomOutput getComisionEmpleadoOutput = meta4ClientPool.getestructurascom(paramEstructura);
                List<IcmListaestructuraRecord> recordset = getComisionEmpleadoOutput.getIcmListaestructura()
                        .getIcmListaestructuraRecordSet();
                for (IcmListaestructuraRecord record2 : recordset) {
                    System.out.println("tienda:" + tienda + " idempleado: " + record2.getIdempleado()
                            + " idempleadolocal: " + record2.getIdempleadolocal() + " estructura: "
                            + record2.getIdestructura());
                }
            }
        }
    }

    @Test
    public void getEmpleados() {
        IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
        record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
        IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
        param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
        param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
        param1.getIcmParametrosentradaRecordSet().add(record);
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
        param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
        param2.setIdbusqueda(StringUtils.EMPTY);
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        GetempleadosOutput getEmpleadosOutput = meta4ClientPool.getempleados(param1, param2);
        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getEmpleadosOutput.getReturn()));
    }

    @Test
    public void getPoliticas() {
        IcmParamcalestructuraRecord record = new IcmParamcalestructuraRecord();
        record.setIdempleado("AT1010154");
        record.setOrempleado("1");
        IcmParamcalestructuraBlock param1 = new IcmParamcalestructuraBlock();
        param1.setIdorigen("38");
        param1.setFechainicio("2015-01-01");
        param1.setFechafin("2015-08-31");
        param1.getIcmParamcalestructuraRecordSet().add(record);
        GetestructuraspolOutput getestrpoliticas = meta4ClientPool.getestructuraspol(param1);
        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getestrpoliticas.getReturn()));
    }

}