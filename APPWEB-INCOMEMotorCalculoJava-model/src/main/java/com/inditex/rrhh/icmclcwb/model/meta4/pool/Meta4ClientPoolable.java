package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;

import stormpot.Poolable;
import stormpot.Slot;

public class Meta4ClientPoolable implements Poolable {

	private final Slot slot;

	private final Meta4Client session;

	public Meta4ClientPoolable(Slot slot, Meta4Client session) {
		this.slot = slot;
		this.session = session;
	}

	public void expire() {
	    slot.expire(this);
	}
	
	@Override
	public void release() {
		System.out.println("release()");
		slot.release(this);
	}
	
	//TODO eliminar metodo
	public void close() {
	    System.out.println("close123()");
	}

	public Meta4ClientSession getSession() {
		return session.getSession();
	}

	public LoginService getLoginService() {
		return session.getService().getLoginService();
	}

	public IcmWsCalcIncomeService getIcmWsCalcIncomeService() {
		return session.getService().getIcmWsCalcIncomeService();
	}

}
