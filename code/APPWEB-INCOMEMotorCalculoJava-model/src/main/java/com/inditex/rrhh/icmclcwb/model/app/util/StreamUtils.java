package com.inditex.rrhh.icmclcwb.model.app.util;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class StreamUtils {

  private StreamUtils() {
  }

  public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
    Set<Object> seen = ConcurrentHashMap.newKeySet();
    return t -> seen.add(keyExtractor.apply(t));
  }

  public static <T> Collection<List<T>> partition(Collection<T> collection, int size) {
    final AtomicInteger counter = new AtomicInteger(0);
    return collection.stream().collect(Collectors.groupingBy(item -> counter.getAndIncrement() / size)).values();
  }

}
