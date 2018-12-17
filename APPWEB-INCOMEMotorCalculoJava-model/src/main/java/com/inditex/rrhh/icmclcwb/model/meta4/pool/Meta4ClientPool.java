package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.util.concurrent.TimeUnit;

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
import stormpot.Timeout;

public class Meta4ClientPool extends Meta4ClientPoolBase {

    private final Meta4ClientFactory meta4ClientFactory;

    private final BlazePool<Meta4ClientPoolable> pool;

    public Meta4ClientPool(Meta4ClientFactory meta4ClientFactory) {
        this.meta4ClientFactory = meta4ClientFactory;
        Meta4ClientReallocator allocator = new Meta4ClientReallocator(meta4ClientFactory);
        Config<Meta4ClientPoolable> config = new Config<>();
        config.setAllocator(allocator);
        config.setSize(meta4ClientFactory.getMeta4ClientProperties().getSize());
        config.setExpiration(new Meta4ClientExpiration());
        this.pool = new BlazePool<>(config);
    }

    public void close() throws InterruptedException {
        System.out.println("shutdown()");
        pool.shutdown().await(
                new Timeout(meta4ClientFactory.getMeta4ClientProperties().getShutdownTimeout(), TimeUnit.MILLISECONDS));
    }

    public GetempleadosOutput getempleados(IcmParametrosentradaBlock param1, IcmParametrospaginacionBlock param2)
            throws InterruptedException, M4SoapException_Exception {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getempleados(param1, param2);
        } finally {
            release(client);
        }
    }

    public GetcomisionempleadoOutput getcomisionempleado(IcmParametrosentradaBlock param1)
            throws InterruptedException, M4SoapException_Exception {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getcomisionempleado(param1);
        } finally {
            release(client);
        }
    }

    public GettiendasempleadoOutput gettiendasempleado(IcmParametrosentradaBlock param1,
            IcmParametrospaginacionBlock param2) throws InterruptedException, M4SoapException_Exception {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().gettiendasempleado(param1, param2);
        } finally {
            release(client);
        }
    }

    public SearchtiendasOutput searchtiendas(IcmParametrosentradaBlock param1, IcmParametrospaginacionBlock param2)
            throws InterruptedException, M4SoapException_Exception {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().searchtiendas(param1, param2);
        } finally {
            release(client);
        }
    }

    public GettiendasincomeOutput gettiendasincome(IcmParametrospaginacionBlock param1,
            IcmParametrosentradaBlock param2) throws InterruptedException, M4SoapException_Exception {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().gettiendasincome(param1, param2);
        } finally {
            release(client);
        }
    }

    public SearchempleadosOutput searchempleados(IcmParametrospaginacionBlock param1, IcmParametrosentradaBlock param2)
            throws InterruptedException, M4SoapException_Exception {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().searchempleados(param1, param2);
        } finally {
            release(client);
        }
    }

}
