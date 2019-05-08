package com.inditex.rrhh.icmclcwb.app.async;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.app.exception.ReactorIcmclcwbException;
import com.inditex.rrhh.icmclcwb.model.app.util.TestUtils;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class ReactorTest {

    @Autowired
    private Logger log;

    private final static List<String> personas = Arrays.asList("persona-1", "persona-2", "persona-3", "persona-4",
            "persona-5", "persona-6", "persona-7", "persona-8", "persona-9");

    @Test
    public void reactorSequentialBlockLastTest() {
        log.info("Inicio :: ReactorSequentialBlockLastTest");
        final Instant start = Instant.now();
        // CountDownLatch latch = new CountDownLatch(1);
        Flux.fromIterable(personas).log().parallel().runOn(Schedulers.parallel()).doOnNext(item -> {
            log.info("ReactorSequentialBlockLastTest :: doOnNext() :: {}", item);
        }).map(item -> {
            log.info("ReactorSequentialBlockLastTest :: Inicio :: map() :: {}", item);
            run(item);
            log.info("ReactorSequentialBlockLastTest :: Fin :: map() :: {}", item);
            return Flux.empty();
        }).sequential().blockLast();
        final Instant end = Instant.now();
        final Duration duration = Duration.between(start, end);
        log.info("Fin :: ReactorSequentialBlockLastTest :: {}", duration);
    }

    @Test
    public void reactorSequentialCollectListBlockTest() {
        log.info("Inicio :: reactorSequentialCollectListBlockTest");
        final Instant start = Instant.now();
        // CountDownLatch latch = new CountDownLatch(1);
        Flux.fromIterable(personas).log().parallel().runOn(Schedulers.parallel()).doOnNext(item -> {
            log.info("reactorSequentialCollectListBlockTest :: doOnNext() :: {}", item);
        }).map(item -> {
            log.info("reactorSequentialCollectListBlockTest :: Inicio :: map() :: {}", item);
            run(item);
            log.info("reactorSequentialCollectListBlockTest :: Fin :: map() :: {}", item);
            return Flux.empty();
        }).sequential().collectList().block();
        final Instant end = Instant.now();
        final Duration duration = Duration.between(start, end);
        log.info("Fin :: reactorSequentialCollectListBlockTest :: {}", duration);
    }

    private void run(String item) {
        log.info("Inicio :: run() :: {}", item);
        TestUtils.threadSleep();
        if ("persona-4".equals(item) || "persona-7".equals(item)) {
            log.error("run :: La persona persona '{}' falla", item);
            new ReactorIcmclcwbException("La persona persona '" + item + "' falla");
        }
        log.info("Fin :: run() :: {}", item);
    }

}
