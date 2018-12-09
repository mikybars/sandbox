package com.inditex.rrhh.icmclcwb.app.reactor.test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Lists;

import reactor.core.publisher.Flux;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Schedulers;


public class ReactorTest {

	private Flux<String> empleados;

	@Before
	public void setUp() {
		List<String> intList = Lists.newArrayList("empleado-1", "empleado-2", "empleado-3", "empleado-4", "empleado-5",
				"empleado-6", "empleado-7", "empleado-8", "empleado-9");
		empleados = Flux.fromIterable(intList);
	}
	
	
	@Test
	@Ignore
	public void ReactorSimpleTest1 () throws InterruptedException{
		
		final long startTime = System.currentTimeMillis();
		
		ParallelFlux<Object> parallelFlux = empleados
				.log().parallel()
				.runOn(Schedulers.parallel())
				.map((t) -> {
			return tiempo(t);
		});

		CountDownLatch latch = new CountDownLatch(1);
		
		parallelFlux.log().subscribe(o -> System.out.println("Subscribe recibido: " + o + " ,en thread: " + Thread.currentThread().getName()),error -> {error.printStackTrace();latch.countDown();}, () -> latch.countDown());
		
		latch.await();

		final long endTime = System.currentTimeMillis();
		System.out.println("FIN:" + (endTime - startTime));

		
	}
	
	
	
	@Test
	@Ignore
	public void ReactorSimpleTest2 () throws InterruptedException{
		
		
		final long startTime = System.currentTimeMillis();
		
		CountDownLatch latch = new CountDownLatch(1);
		empleados.log()
				.parallel()
				.runOn(Schedulers.parallel())
				.doOnNext(n -> {
					tiempo(n);
				})
			  .doAfterTerminate(latch::countDown)
			  .doOnError(error -> error.printStackTrace())
		     .subscribe( m -> System.out.println("Subscribe recibido - " + m + " en thread: " + Thread.currentThread().getName()));
				
		latch.await();
					
		final long endTime = System.currentTimeMillis();
		System.out.println("FIN:" + (endTime - startTime));

		
	}
	
	
	
	private static String tiempo(String n) {
		System.out.println("Dentro: "+ n);
		try {
			TimeUnit.SECONDS.sleep(1);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Termino");
		return "Procesado: " + n;
	}

}
