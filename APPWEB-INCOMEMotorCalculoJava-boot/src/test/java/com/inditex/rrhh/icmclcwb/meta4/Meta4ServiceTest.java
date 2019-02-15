package com.inditex.rrhh.icmclcwb.meta4;

import static org.junit.Assert.assertEquals;

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
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4TestConstants;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcomisionempleadoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasempleadoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasincomeOutput;
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
