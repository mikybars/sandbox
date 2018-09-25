package com.inditex.rrhh.icmclcwb.model.secondary.service;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.service.SolrQueueService;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas.GETCALENDARIOTIENDA;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas.GetcalendariotiendaOutput;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas.IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login.schemas.Login;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login.schemas.LoginService;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login.schemas.M4LoginOutput;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login.schemas.ObjectFactory;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PaisRepository;
import com.inditex.rrhh.icmclcwb.model.secondary.repository.SolrQueueRepository;

import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class SolrQueueServiceImpl implements SolrQueueService {
    
    @Autowired
    private Logger LOG;

    @Autowired
    private SolrQueueRepository solrQueueRepository;
    
    @Autowired
    private PaisRepository paisRepository;
    
	@Autowired
	//@Qualifier("meta4ClientLogin")
	private LoginService meta4ClientLogin;
	
	@Autowired
	//@Qualifier("meta4ClientIncome")
	private IcmWsIncomeService meta4ClientIncome;
	
	@Autowired
	@Qualifier("ptrClientVentaEmpleado")
    private RestClient ptrClientVentaEmpleado;
    
    @Override
    public Long count() throws Exception {
    	// INICIO - META4
    	// Generación de objetos de LOGIN
		ObjectFactory ofLogin = new ObjectFactory();
		// Llamada a servicio de LOGIN
		Login login = ofLogin.createLogin();
		login.setIn0("HSW_USER_PRUEBA_4" /*user*/);
		login.setIn1("Inditex" /*pass*/);
		login.setIn2("2" /*lang*/);
		//TODO Validar objeto de entrada
		final M4LoginOutput loginOutput001 = meta4ClientLogin.login(login.getIn0() /*user*/, login.getIn1() /*pass*/, login.getIn2() /*lang*/);
		LOG.info("SessionID001: " + loginOutput001.getSessionID());
		// Recuperar la sesion 001
		meta4ClientIncome.retrieveM4Session(loginOutput001.getSessionID());
		
		// Generación de objetos de INCOME
		com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas.ObjectFactory ofIncome = new com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas.ObjectFactory();
		// Llamada a servicio de INCOME
		GETCALENDARIOTIENDA paramGetcalendariotienda = ofIncome.createGETCALENDARIOTIENDA();
		//TODO Validar objeto de entrada
		GetcalendariotiendaOutput getcalendariotiendaOutput001 = meta4ClientIncome.getcalendariotienda(paramGetcalendariotienda.getICMPARAMETROSTIENDA());
		
		int resultLogout001 = meta4ClientLogin.logout();
		LOG.info("resultLogout001: " + resultLogout001);
    	// FIN - META4
    	
    	LOG.info("paisRepository.findAllQuery(): " + paisRepository.findAllQuery());
    	LOG.info("paisRepository.count(): " + paisRepository.count());
    	LOG.info("solrQueueRepository.findAllQuery(): " + solrQueueRepository.findAllQuery());
    	LOG.info("solrQueueRepository.count(): " + solrQueueRepository.count());
        return 70L;
    }

    @Async
	@Override
	public CompletableFuture<Boolean> test1Async() throws Exception {
		LOG.info("INICIO - test1Async");
		Thread.sleep(5000);
		LOG.info("FIN - test1Async");		
		return CompletableFuture.completedFuture(Boolean.TRUE);
	}

    @Async
	@Override
	public CompletableFuture<Boolean> test2Async() throws Exception {
		LOG.info("INICIO - test2Async");
		Thread.sleep(4000);
		LOG.info("FIN - test2Async");		
		return CompletableFuture.completedFuture(Boolean.TRUE);
	}

    @Async
	@Override
	public CompletableFuture<Boolean> test3Async() throws Exception {
		LOG.info("INICIO - test3Async");
		Thread.sleep(3000);
		LOG.info("FIN - test3Async");		
		return CompletableFuture.completedFuture(Boolean.TRUE);
	}

    @Async
	@Override
	public CompletableFuture<Boolean> test4Async() throws Exception {
		LOG.info("INICIO - test4Async");
		Thread.sleep(2000);
		LOG.info("FIN - test4Async");		
		return CompletableFuture.completedFuture(Boolean.TRUE);
	}

    @Async
	@Override
	public CompletableFuture<Boolean> test5Async() throws Exception {
		LOG.info("INICIO - test5Async");
		Thread.sleep(1000);
		LOG.info("FIN - test5Async");		
		return CompletableFuture.completedFuture(Boolean.TRUE);
	}

	@Override
	public void testPtr() throws Exception {
		LOG.info("INICIO PROBANDO PTR");
		if (ptrClientVentaEmpleado != null) {
			LOG.info("PROBANDO PTR no null");
		}
		LOG.info("FIN PROBANDO PTR");
	}
    
}