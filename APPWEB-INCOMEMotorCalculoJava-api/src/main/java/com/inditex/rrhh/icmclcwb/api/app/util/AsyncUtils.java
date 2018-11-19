package com.inditex.rrhh.icmclcwb.api.app.util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

@Component
public class AsyncUtils {

    public static void checkAsyncAvaliable(final List<CompletableFuture<Void>> cfList) {
        CompletableFuture.anyOf(cfList.toArray(new CompletableFuture[cfList.size()]));
        Map<Boolean, List<CompletableFuture<Void>>> resultPersistence = cfList.stream()
                .collect(Collectors.partitioningBy(CompletableFuture::isDone));
        List<CompletableFuture<Void>> cfDone = resultPersistence.values().stream().flatMap(List::stream)
                .collect(Collectors.toList());
        cfList.removeAll(cfDone);
    }

    public static void exceptionally(final TrabajoDto trabajo, final CompletableFuture<?> cf,
            final List<CompletableFuture<?>> cfList) throws Exception {
        cfList.add(cf);
        cf.exceptionally(e -> {
            cfList.stream().forEach(item -> {
                if (!item.isDone()) {
                    item.cancel(true);
                }
            });
            return null;
        });
    }

    public static boolean isOk(final TrabajoDto trabajo, final List<CompletableFuture<?>> cfList) throws Exception {
        boolean result = true;
        for (CompletableFuture<?> item : cfList) {
            if (item.isCompletedExceptionally()) {
                result = false;
                break;
            }
        }
        return result;
    }

}