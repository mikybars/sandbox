package com.inditex.rrhh.icmclcwb.meta4;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4TestConstants;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcomisionempleadoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasempleadoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasincomeOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadosRecord;
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
    public void getTiendasEmpleado() {
        IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
        IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        
        record.setIdlugartrabajo(Meta4TestConstants.ID_TIENDA);
        param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
        param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
        param1.getIcmParametrosentradaRecordSet().add(record);
        
        param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
        param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
        param2.setIdbusqueda(StringUtils.EMPTY);
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());

        GettiendasempleadoOutput gettiendasempleadoOutput = meta4ClientPool.gettiendasempleado(param1, param2);

        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(gettiendasempleadoOutput.getReturn()));
    }
    
    @Test
    public void searchTiendas() {
        IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
        IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        
        record.setIdlugartrabajo(Meta4TestConstants.ID_TIENDA);
        param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
        param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
        param1.getIcmParametrosentradaRecordSet().add(record);
        
        param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
        param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
        param2.setIdbusqueda(StringUtils.EMPTY);
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        
        SearchtiendasOutput searchTiendasOutput = meta4ClientPool.searchtiendas(param1, param2);

        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(searchTiendasOutput.getReturn()));
    }
    
    @Test
    public void getTiendas() {
        IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
        IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        
        record.setIdlugartrabajo(Meta4TestConstants.ID_TIENDA);
        param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
        param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
        param1.getIcmParametrosentradaRecordSet().add(record);
        
        param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
        param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
        param2.setIdbusqueda(StringUtils.EMPTY);
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        
        GettiendasincomeOutput getTiendasIncome = meta4ClientPool.gettiendasincome(param2, param1);

        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getTiendasIncome.getReturn()));
    }
    
    @Test
    public void searchEmpleados() {
        IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
        IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
        
        record.setIdempleado(Meta4TestConstants.ID_EMPLEADO);
        param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
        param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
        param1.getIcmParametrosentradaRecordSet().add(record);
        
        param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
        param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
        param2.setIdbusqueda(StringUtils.EMPTY);
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());

        SearchempleadosOutput searchEmpleadosOutput = meta4ClientPool.searchempleados(param2, param1);

        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(searchEmpleadosOutput.getReturn()));
    }
    
    @Test
    public void getComisionEmpleado() {
        IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
        IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();

        record.setIdempleado(Meta4TestConstants.ID_EMPLEADO);
        param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
        param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
        param1.getIcmParametrosentradaRecordSet().add(record);
        
        GetcomisionempleadoOutput getComisionEmpleadoOutput = meta4ClientPool.getcomisionempleado(param1);

        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getComisionEmpleadoOutput.getReturn()));
    }
    
    
    @Test
    @Ignore
    public void comprobarEstructurasTiendasOrigen() {
        IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
        IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();

        param1.setFechainicio("2017-01-01");
        param1.setFechafin("2018-12-31");
                
        List<String> lista = Arrays.asList("T1413","T3188","T3189","T3273","T3275","T3323","T3355","T3474","T3511","T3682","T3787","T4330","T4331","T4352","T4481","T4578","T8194","T8195","T8779","T9092","T9263","T9930","T9974");
                
        param2.setNumeroregistrospagina("50");
        param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
        param2.setIdbusqueda(StringUtils.EMPTY);
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());

        for(String tienda : lista) {
            List<IcmListaempleadosRecord> emprec = new ArrayList<>();

            IcmParametrosentradaRecord record4 = new IcmParametrosentradaRecord();
            record4.setIdlugartrabajo(tienda);
            param1.getIcmParametrosentradaRecordSet().clear();
            param1.getIcmParametrosentradaRecordSet().add(record4);
            GetempleadosOutput getEmpleadosOutput = meta4ClientPool.getempleados(param1, param2);
            emprec.addAll(getEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet());
            
            param1.setIdorigen("39");

            param1.getIcmParametrosentradaRecordSet().clear();
            List<IcmParametrosentradaRecord> entradas2 = emprec.stream().map(obj -> { final IcmParametrosentradaRecord obj2 = new IcmParametrosentradaRecord(); obj2.setIdempleado(obj.getIdempleado()); return obj2; })
                    .collect(Collectors.toList());
            param1.getIcmParametrosentradaRecordSet().addAll(entradas2);
            
            if (emprec.size()>0) {
                GetcomisionempleadoOutput getComisionEmpleadoOutput = meta4ClientPool.getcomisionempleado(param1);
                List<IcmListaempleadosRecord> recordset = getComisionEmpleadoOutput.getIcmListaempleados()
                        .getIcmListaempleadosRecordSet();
                for (IcmListaempleadosRecord record2 : recordset) {
                    System.out.println("tienda:" + tienda + " idempleado: " + record2.getIdempleado()
                            + " idempleadolocal: " + record2.getIdempleadolocal() + " estructura: "
                            + record2.getIdestructura() + " tipo comision: " + record2.getIdtipocomision() + " tipo calculo: " 
                            + record2.getIdtipocalculo() + " percentageall: " + record2.getPercentageall() + " percentageboy: "  + record2.getPercentageboy() 
                            + " percentageman: " + record2.getPercentageman() + " percentagewoman: " + record2.getPercentagewoman() );
                } 
            }
        }

    }
    
    @Test
    public void getEmpleados() {
        IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
        IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
        IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();

        record.setIdlugartrabajo(Meta4TestConstants.ID_TIENDA);
        param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
        param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
        param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
        param1.getIcmParametrosentradaRecordSet().add(record);
        
        param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
        param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
        param2.setIdbusqueda(StringUtils.EMPTY);
        param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());

        GetempleadosOutput getEmpleadosOutput = meta4ClientPool.getempleados(param1, param2);

        assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getEmpleadosOutput.getReturn()));
    }

    
}
