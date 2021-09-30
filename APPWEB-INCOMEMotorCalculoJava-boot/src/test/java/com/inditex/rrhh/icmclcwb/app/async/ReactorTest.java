package com.inditex.rrhh.icmclcwb.app.async;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.app.exception.ReactorIcmclcwbException;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import com.inditex.aqsw.framework.common.reactor.autoconfiguration.ItxSchedulers;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class ReactorTest {

    @Autowired
    private Logger log;

    private final static List<String> algoritmos = new ArrayList<>();

    private final static List<String> personas = new ArrayList<>();

    private final static String prefijoAlgoritmo = "algoritmo-";

    private final static String prefijoPersona = "persona-";

    private void run(final String... args) {
        final List<String> items = Arrays.asList(args);
        this.log.info("Inicio :: run() :: {}", items);
        TestUtils.threadSleep();
        if (items.contains("persona-4") || items.contains("persona-7")) {
            this.log.error("Ha fallado el bloque: {}", items);
            new ReactorIcmclcwbException("Ha fallado el bloque:");
        }
        this.log.info("Fin :: run() :: {}", items);
    }

    @BeforeEach
    public void setUp() {
        for (int x = 0; x < 20; x++) {
            algoritmos.add(prefijoAlgoritmo + x);
        }
        for (int x = 0; x < 1000; x++) {
            personas.add(prefijoPersona + x);
        }
    }

    @Disabled
    @Test
    public void reactorSequentialBlockLastTest() {
        this.log.info("Inicio :: ReactorSequentialBlockLastTest");
        final Instant start = Instant.now();
        Flux.fromIterable(personas).log().parallel().runOn(Schedulers.parallel()).doOnNext(item -> {
            this.log.info("ReactorSequentialBlockLastTest :: doOnNext() :: {}", item);
        }).map(item -> {
            this.log.info("ReactorSequentialBlockLastTest :: Inicio :: map() :: {}", item);
            this.run(item);
            this.log.info("ReactorSequentialBlockLastTest :: Fin :: map() :: {}", item);
            return Flux.empty();
        }).sequential().blockLast();
        final Instant end = Instant.now();
        final Duration duration = Duration.between(start, end);
        this.log.info("Fin :: ReactorSequentialBlockLastTest :: {}", duration);
    }

    @Disabled
    @Test
    public void reactorSequentialCollectListBlockTest() {
        this.log.info("Inicio :: reactorSequentialCollectListBlockTest");
        final Instant start = Instant.now();
        Flux.fromIterable(personas).log().parallel().runOn(Schedulers.parallel()).doOnNext(item -> {
            this.log.info("reactorSequentialCollectListBlockTest :: doOnNext() :: {}", item);
        }).map(item -> {
            this.log.info("reactorSequentialCollectListBlockTest :: Inicio :: map() :: {}", item);
            this.run(item);
            this.log.info("reactorSequentialCollectListBlockTest :: Fin :: map() :: {}", item);
            return Flux.empty();
        }).sequential().collectList().block();
        final Instant end = Instant.now();
        final Duration duration = Duration.between(start, end);
        this.log.info("Fin :: reactorSequentialCollectListBlockTest :: {}", duration);
    }

    @Disabled
    @Test
    public void reactorSequentialCollectListBlockTestWithChild() {
        this.log.info("Inicio :: reactorSequentialCollectListBlockTestWithChild");
        final Instant start = Instant.now();

        Flux.fromIterable(algoritmos).log().parallel().runOn(ItxSchedulers.boundedElastic()).doOnNext(item -> {
            this.log.info("reactorSequentialCollectListBlockTest :: algoritmos :: doOnNext() :: {}", item);
        }).map(algoritmo -> {
            this.log.info("reactorSequentialCollectListBlockTest :: algoritmos :: Inicio :: map() :: {}", algoritmo);

            Flux.fromIterable(StreamUtils.partition(personas, 100))
                .log()
                .parallel()
                .runOn(ItxSchedulers.boundedElastic())
                .doOnNext(partitionPersonas -> {
                    this.log.info(
                            "reactorSequentialCollectListBlockTestWithChild :: partitionPersonas :: doOnNext() :: {}",
                            partitionPersonas);
                })
                .map(partitionPersonas -> {
                    this.log.info(
                            "reactorSequentialCollectListBlockTestWithChild :: partitionPersonas :: Inicio :: map() :: {}",
                            partitionPersonas);
                    this.run(partitionPersonas.toArray(new String[partitionPersonas.size()]));
                    this.log.info(
                            "reactorSequentialCollectListBlockTestWithChild :: partitionPersonas :: Fin :: map() :: {}",
                            partitionPersonas);
                    return Flux.empty();
                })
                .sequential()
                .collectList()
                .block();

            this.log.info("reactorSequentialCollectListBlockTest :: algoritmos :: Fin :: map() :: {}", algoritmo);
            return Flux.empty();
        }).sequential().collectList().block();

        final Instant end = Instant.now();
        final Duration duration = Duration.between(start, end);
        this.log.info("Fin :: reactorSequentialCollectListBlockTestWithChild :: {}", duration);
    }

}
