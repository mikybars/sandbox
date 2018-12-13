package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.GetcomisionempleadoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.GettiendasempleadoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.GettiendasincomeOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.M4SoapException_Exception;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.SearchempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.SearchtiendasOutput;

import stormpot.BlazePool;
import stormpot.Config;
import stormpot.Pool;

public class Meta4ClientPool extends Meta4ClientPoolBase {

    private final Pool<Meta4ClientPoolable> pool;

    public Meta4ClientPool(Meta4ClientFactory meta4ClientFactory) {
        Meta4ClientReallocator allocator = new Meta4ClientReallocator(meta4ClientFactory);
        Config<Meta4ClientPoolable> config = new Config<>();
        config.setAllocator(allocator);
        config.setSize(10);
        //config.setExpiration(new TimeSpreadExpiration<>(30000, 60000, TimeUnit.MILLISECONDS));
        config.setExpiration(new Meta4ClientExpiration());
        pool = new BlazePool<>(config);
    }

    public void close() throws InterruptedException {
    	System.out.println("close()");
        //pool.shutdown().await(new Timeout(1, TimeUnit.MINUTES));
    }

    public GetempleadosOutput getempleados(IcmParametrosentradaBlock param1, IcmParametrospaginacionBlock param2)
            throws InterruptedException, M4SoapException_Exception {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getempleados(param1, param2);
        } finally {
            client.release();
        }
    }

    public GetcomisionempleadoOutput getcomisionempleado(IcmParametrosentradaBlock param1)
            throws InterruptedException, M4SoapException_Exception {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getcomisionempleado(param1);
        } finally {
            client.release();
        }
    }

    public GettiendasempleadoOutput gettiendasempleado(IcmParametrosentradaBlock param1,
            IcmParametrospaginacionBlock param2) throws InterruptedException, M4SoapException_Exception {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().gettiendasempleado(param1, param2);
        } finally {
            client.release();
        }
    }

    public SearchtiendasOutput searchtiendas(IcmParametrosentradaBlock param1, IcmParametrospaginacionBlock param2)
            throws InterruptedException, M4SoapException_Exception {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().searchtiendas(param1, param2);
        } finally {
            client.release();
        }
    }

    public GettiendasincomeOutput gettiendasincome(IcmParametrospaginacionBlock param1,
            IcmParametrosentradaBlock param2) throws InterruptedException, M4SoapException_Exception {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().gettiendasincome(param1, param2);
        } finally {
            client.release();
        }
    }

    public SearchempleadosOutput searchempleados(IcmParametrospaginacionBlock param1, IcmParametrosentradaBlock param2)
            throws InterruptedException, M4SoapException_Exception {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().searchempleados(param1, param2);
        } finally {
            client.release();
        }
    }

}
