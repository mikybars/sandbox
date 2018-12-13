package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.time.LocalDateTime;

import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;

import stormpot.Reallocator;
import stormpot.Slot;

public class Meta4ClientReallocator implements Reallocator<Meta4ClientPoolable> {

	private final Meta4ClientFactory meta4ClientFactory;

	public Meta4ClientReallocator(Meta4ClientFactory meta4ClientFactory) {
		this.meta4ClientFactory = meta4ClientFactory;
	}

	@Override
	public Meta4ClientPoolable allocate(Slot slot) throws Exception {
		System.out.println("allocate()");
		LoginService loginService = meta4ClientFactory.getLoginServiceFactory().build(LoginService.class);
		IcmWsIncomeService icmWsIncomeService = meta4ClientFactory.getIcmWsIncomeServiceFactory()
				.build(IcmWsIncomeService.class);
		IcmWsCalcIncomeService icmWsCalcIncomeService = meta4ClientFactory.getIcmWsCalcIncomeServiceFactory()
				.build(IcmWsCalcIncomeService.class);

		String id = loginService.login(meta4ClientFactory.getMeta4ClientCredentials().getUser(),
				meta4ClientFactory.getMeta4ClientCredentials().getPassword(),
				meta4ClientFactory.getMeta4ClientCredentials().getLanguage()).getSessionID();
		icmWsIncomeService.retrieveM4Session(id);
		icmWsCalcIncomeService.retrieveM4Session(id);

		Meta4Client client = new Meta4Client();
		
		Meta4ClientSession session = new Meta4ClientSession();
		session.setId(id);
		session.setFechaCreacion(LocalDateTime.now());
		client.setSession(session);
		
		client.setCredentials(meta4ClientFactory.getMeta4ClientCredentials());
		
		Meta4ClientService service = new Meta4ClientService();
		service.setLoginService(loginService);
		service.setIcmWsIncomeService(icmWsIncomeService);
		service.setIcmWsCalcIncomeService(icmWsCalcIncomeService);
		client.setService(service);

		return new Meta4ClientPoolable(slot, client);
	}

	@Override
	public void deallocate(Meta4ClientPoolable poolable) throws Exception {
		// Nothing to do here
		// But it's a perfect place to close sockets, files, etc.
		System.out.println("deallocate()");
	}

	@Override
	public Meta4ClientPoolable reallocate(Slot slot, Meta4ClientPoolable poolable) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("reallocate()");
//		slot.release(poolable);
//		return allocate(slot);
		return null;
	}

}
