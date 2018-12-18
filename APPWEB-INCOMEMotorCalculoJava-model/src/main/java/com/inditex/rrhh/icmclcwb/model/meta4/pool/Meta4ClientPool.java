package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.util.concurrent.TimeUnit;

import org.springframework.retry.annotation.Retryable;

import com.inditex.rrhh.icmclcwb.api.meta4.exception.Meta4Exception;
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

    @Retryable
    public GetempleadosOutput getempleados(IcmParametrosentradaBlock param1, IcmParametrospaginacionBlock param2)
            throws InterruptedException, M4SoapException_Exception {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getempleados(param1, param2);
        } catch (Exception e) {
            expire(client);
            throw new Meta4Exception("Session caducada (Pool) (Exception)");
        } finally {
            release(client);
        }
    }

    @Retryable
    public GetcomisionempleadoOutput getcomisionempleado(IcmParametrosentradaBlock param1)
            throws InterruptedException, M4SoapException_Exception {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getcomisionempleado(param1);
        } catch (Exception e) {
            expire(client);
            throw new Meta4Exception("Session caducada (Pool) (Exception)");
        } finally {
            release(client);
        }
    }

    @Retryable
    public GettiendasempleadoOutput gettiendasempleado(IcmParametrosentradaBlock param1,
            IcmParametrospaginacionBlock param2) throws InterruptedException, M4SoapException_Exception {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().gettiendasempleado(param1, param2);
        } catch (Exception e) {
            expire(client);
            throw new Meta4Exception("Session caducada (Pool) (Exception)");
        } finally {
            release(client);
        }
    }

    public SearchtiendasOutput searchtiendas(IcmParametrosentradaBlock param1, IcmParametrospaginacionBlock param2)
            throws InterruptedException, M4SoapException_Exception {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().searchtiendas(param1, param2);
        } catch (Exception e) {
            expire(client);
            throw new Meta4Exception("Session caducada (Pool) (Exception)");
        } finally {
            release(client);
        }
    }

    @Retryable
    public GettiendasincomeOutput gettiendasincome(IcmParametrospaginacionBlock param1,
            IcmParametrosentradaBlock param2) throws InterruptedException, M4SoapException_Exception {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().gettiendasincome(param1, param2);
        } catch (Exception e) {
            expire(client);
            throw new Meta4Exception("Session caducada (Pool) (Exception)");
        } finally {
            release(client);
        }
    }

    @Retryable
    public SearchempleadosOutput searchempleados(IcmParametrospaginacionBlock param1, IcmParametrosentradaBlock param2)
            throws InterruptedException, M4SoapException_Exception {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().searchempleados(param1, param2);
        } catch (Exception e) {
            expire(client);
            throw new Meta4Exception("Session caducada (Pool) (Exception)");
        } finally {
            release(client);
        }
    }

}
