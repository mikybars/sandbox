package com.inditex.rrhh.icmclcwb.app.reactor.test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.inditex.aqsw.framework.common.core.exception.ApplicationException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
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
		
		parallelFlux.log().subscribe(
				o -> System.out
						.println("Subscribe recibido: " + o + " ,en thread: " + Thread.currentThread().getName()),
				error -> {
					error.printStackTrace();
					latch.countDown();
				}, () -> latch.countDown());
		
		latch.await();

		final long endTime = System.currentTimeMillis();
		System.out.println("FIN:" + (endTime - startTime));

		
	}
	
	
	
	@Test	
	@Ignore
	public void ReactorSimpleTest2 ()  {
		
		
		final long startTime = System.currentTimeMillis();
		
		CountDownLatch latch = new CountDownLatch(1);
		empleados.log()
				.parallel()
				.runOn(Schedulers.parallel())
				.doOnNext(n -> {
					Flux<Void> x = tiempo(n);					
					
					x.onErrorResume(error -> { 
				        System.out.println("Error tiempo: " + error);
				        return Flux.empty();
					}).subscribe();
					
				})
			  .doAfterTerminate(latch::countDown)
			  .doOnError(error -> System.out.println("Error: "+ error ))
		     .subscribe( m -> System.out.println("Subscribe recibido - " + m + " en thread: " + Thread.currentThread().getName()), error-> System.out.println("error subscribe:" +error),null  );
				
		try {
			latch.await();
		} catch (InterruptedException e) {
			System.out.println("latch"+ e.getMessage()); 
		}
					
		final long endTime = System.currentTimeMillis();
		System.out.println("FIN:" + (endTime - startTime));

		
	}
	
	
	
	private static Flux<Void> tiempo(String n) {
		System.out.println("Dentro: "+ n);						
		try {						
			if (n.equals("empleado-4")){
				System.out.println("Se cumple condicion");												 				
				 return Flux.error(new ApplicationException(
			                "Error genérico "));								
			}
			
			TimeUnit.SECONDS.sleep(1);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Termino");		
		return Flux.empty();
	}

}
