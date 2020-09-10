package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.retry.annotation.Retryable;

import com.inditex.rrhh.icmclcwb.api.meta4.exception.Meta4IcmclcwbException;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetagruponlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetausenciasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcadenaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcoefjornadaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfchdiasminimosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfchtpventaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfiguracionOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfpreciohoraOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfprodventaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfventaonlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetdesplazrealOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosdesplazOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadospresenciaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempresasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetestructurascomOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetestructuraspolOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetfestivosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetflagcalculaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetorigenesOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetperiodosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresenciamanualOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresupuestosrangoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresupuestoswlocOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasincomeOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasonlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetventacongeladaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalcadenaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchdiasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchventaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconforigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfpreciohoraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaldesplazrealBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosdesplazBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadospresenciaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalestructuraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalorigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalperiodoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestosrangoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestoswlocBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsociedadBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalventacongeladaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SaveprocesoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchtiendasOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stormpot.Pool;
import stormpot.Timeout;

public class Meta4ClientPool extends Meta4ClientPoolBase {

    private static final Logger log = LoggerFactory.getLogger(Meta4ClientPool.class);

    private final Meta4ClientFactory meta4ClientFactory;

    private final Pool<Meta4ClientPoolable> pool;

    public Meta4ClientPool(final Meta4ClientFactory meta4ClientFactory) {
        this.meta4ClientFactory = meta4ClientFactory;
        this.pool = Pool.from(new Meta4ClientReallocator(meta4ClientFactory))
            .setSize(meta4ClientFactory.getMeta4ClientProperties().getSize())
            .setExpiration(new Meta4ClientExpiration())
            .setBackgroundExpirationEnabled(false)
            .build();
    }

    public void close() {
        log.info("Inicio :: Meta4ClientPool :: close()");
        try {
            this.pool.shutdown()
                .await(new Timeout(this.meta4ClientFactory.getMeta4ClientProperties().getShutdownTimeout(),
                        TimeUnit.MILLISECONDS));
        } catch (final InterruptedException e) {
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        }
        log.info("Fin :: Meta4ClientPool :: close()");
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetempleadosdesplazOutput getempleadosdesplaz(final IcmParametrospaginacionBlock param1,
            final IcmParamcalempleadosdesplazBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getempleadosdesplaz(param2, param1);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetorigenesOutput getorigenes(final IcmParamcalsociedadBlock param1,
            final IcmParametrospaginacionBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getorigenes(param1, param2);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetempresasOutput getempresas(final IcmParamcalorigenBlock param1,
            final IcmParametrospaginacionBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getempresas(param2, param1);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }


    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetcadenaOutput getcadena(final IcmParamcalcadenaBlock param1,
            final IcmParametrospaginacionBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getcadena(param1, param2);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetconfprodventaOutput getconfprodventa(final IcmParametrosentradaBlock param1,
            final IcmParametrospaginacionBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getconfprodventa(param1, param2);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetconfventaonlineOutput getconfventaonline(final IcmParametrosentradaBlock param1,
            final IcmParametrospaginacionBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getconfventaonline(param1, param2);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetagruponlineOutput getagruponline(final IcmParamcalorigenBlock param1,
            final IcmParametrospaginacionBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getagruponline(param1, param2);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetflagcalculaOutput getflagcalcula(final IcmParametrosentradaBlock param1,
            final IcmParametrospaginacionBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getflagcalcula(param2, param1);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetcoefjornadaOutput getcoefjornada(final IcmParametrosentradaBlock param1,
            final IcmParametrospaginacionBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getcoefjornada(param1, param2);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetfestivosOutput getfestivos(final IcmParametrosentradaBlock param1,
            final IcmParametrospaginacionBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getfestivos(param2, param1);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetpresenciamanualOutput getpresenciamanual(final IcmParametrosentradaBlock param1,
            final IcmParametrospaginacionBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getpresenciamanual(param1, param2);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetempleadospresenciaOutput getempleadospresencia(final IcmParamcalempleadospresenciaBlock param1,
            final IcmParametrospaginacionBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getempleadospresencia(param1, param2);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetperiodosOutput getperiodos(final IcmParamcalperiodoBlock param1,
            final IcmParametrospaginacionBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getperiodos(param1, param2);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetempleadosOutput getempleados(final IcmParametrosentradaBlock param1,
            final IcmParametrospaginacionBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getempleados(param1, param2);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetestructurascomOutput getestructurascom(final IcmParamcalestructuraBlock param1) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getestructurascom(param1);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetestructuraspolOutput getestructuraspol(final IcmParamcalestructuraBlock param1) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getestructuraspol(param1);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }


    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public SearchtiendasOutput searchtiendas(final IcmParamcaltiendasBlock param1,
            final IcmParametrospaginacionBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().searchtiendas(param2, param1);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GettiendasincomeOutput gettiendasincome(final IcmParametrospaginacionBlock param1,
            final IcmParametrosentradaBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().gettiendasincome(param2, param1);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GettiendasonlineOutput gettiendasonline(final IcmParametrospaginacionBlock param1,
            final IcmParametrosentradaBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().gettiendasonline(param1, param2);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public SearchempleadosOutput searchempleados(final IcmParametrospaginacionBlock param1,
            final IcmParamcalempleadoBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().searchempleados(param2, param1);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public SaveprocesoOutput saveproceso(final IcmParamcalprocesoBlock param) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().saveproceso(param);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetausenciasOutput getausencias(final IcmParametrospaginacionBlock param1,
            final IcmParamcalempleadoBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getausencias(param1, param2);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetconfiguracionOutput getconfiguracion(final IcmParamcalconforigenBlock param) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getconfiguracion(param);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetconfchdiasminimosOutput getconfchdiasminimos(final IcmParamcalconfchdiasBlock param) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getconfchdiasminimos(param);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetpresupuestoswlocOutput getpresupuestoswloc(final IcmParamcalpresupuestoswlocBlock param1,
            final IcmParametrospaginacionBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getpresupuestoswloc(param2, param1);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetconfpreciohoraOutput getconfpreciohora(final IcmParamcalconfpreciohoraBlock param) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getconfpreciohora(param);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetconfchtpventaOutput getconfchtpventa(final IcmParamcalconfchventaBlock param) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getconfchtpventa(param);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetpresupuestosrangoOutput getpresupuestosrango(final IcmParametrospaginacionBlock param1,
            final IcmParamcalpresupuestosrangoBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getpresupuestosrango(param1, param2);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetventacongeladaOutput getventacongelada(final IcmParametrospaginacionBlock param1,
            final IcmParamcalventacongeladaBlock param2) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getventacongelada(param1, param2);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "${app.envars.meta4.config.max-attempts}")
    public GetdesplazrealOutput getdesplazreal(final IcmParamcaldesplazrealBlock param1) {
        final Meta4ClientPoolable client = this.claim(this.pool);
        try {
            return client.getIcmWsCalcIncomeService().getdesplazreal(param1);
        } catch (final Exception e) {
            this.catchException(e, client, Arrays.asList(param1, param1));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            this.release(client);
        }
    }

}
