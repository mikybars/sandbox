package com.inditex.rrhh.icmclcwb.api.app.util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class AsyncUtils {

	public static void checkAsyncAvaliable(List<CompletableFuture<Void>> cfList) {
		CompletableFuture.anyOf(cfList
				.toArray(new CompletableFuture[cfList.size()]));
		Map<Boolean, List<CompletableFuture<Void>>> resultPersistence = cfList
				.stream().collect(Collectors.partitioningBy(CompletableFuture::isDone));
		List<CompletableFuture<Void>> cfFinished = resultPersistence.values().stream()
				.flatMap(List::stream).collect(Collectors.toList());
		cfList.removeAll(cfFinished);
	}
}
