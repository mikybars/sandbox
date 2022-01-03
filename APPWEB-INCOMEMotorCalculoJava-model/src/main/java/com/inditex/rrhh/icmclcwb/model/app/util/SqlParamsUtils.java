package com.inditex.rrhh.icmclcwb.model.app.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class SqlParamsUtils {

  private static final String REGEXP_GROUP_1 = "$1";

  private static final String REGEXP_GROUP_3 = "$3";

  private static final String REGEXP_GROUP_1_REGEXP = "((\\(|=) *):";

  private static final String REGEXP_GROUP_3_REGEXP = "($|\\n|\\)| )";

  private SqlParamsUtils() {
  }

  /**
   * <b>Importante:</b> Este metodo no debe usarse para ejeuctar SQL, es para imprimir en el log las consultas.
   */
  public static String replaceValues(final String sql, final Map<String, ? extends Object> params) {

    String result = sql;
    if (sql != null && params != null) {
      for (final Entry<String, ? extends Object> entry : params.entrySet()) {
        final String key = entry.getKey();
        final String value = createValueCreator(entry.getValue()).createValue();
        final String paramRegexp = new StringBuilder(REGEXP_GROUP_1_REGEXP).append(key)
            .append(REGEXP_GROUP_3_REGEXP)
            .toString();
        final Pattern pattern = Pattern.compile(paramRegexp);
        final Matcher matcher = pattern.matcher(result);
        if (matcher.find()) {
          final String v = new StringBuilder(REGEXP_GROUP_1).append(value).append(REGEXP_GROUP_3).toString();
          result = matcher.replaceAll(v);
        }
        result = result.replaceAll(paramRegexp, value);
      }
    }

    return result;
  }

  private static ValueCreator createValueCreator(final Object value) {
    if (value == null) {
      return new NullValueCreator();
    } else if (value instanceof Collection) {
      return new ListValueCreator((Collection<?>) value);
    } else if (value instanceof String) {
      return new StringValueCreator((String) value);
    } else {
      return new DefaultValueCreator(value);
    }
  }

  private interface ValueCreator {

    String createValue();

  }

  @Data
  @AllArgsConstructor
  private static class StringValueCreator implements ValueCreator {

    private static final String SIMPLE_QUOTE = "'";

    private String value;

    @Override
    public String createValue() {
      return new StringBuilder(SIMPLE_QUOTE).append(this.value).append(SIMPLE_QUOTE).toString();
    }

  }

  @Data
  @AllArgsConstructor
  private static class DefaultValueCreator implements ValueCreator {

    private Object value;

    @Override
    public String createValue() {
      return this.value.toString();
    }

  }

  @Data
  @AllArgsConstructor
  private static class ListValueCreator implements ValueCreator {

    Collection<?> list;

    @Override
    public String createValue() {
      final Stream<String> stream = this.list.stream().map(value -> createValueCreator(value).createValue());
      final List<String> cleanList = stream.collect(Collectors.toList());
      return String.join(", ", cleanList);
    }

  }

  private static class NullValueCreator implements ValueCreator {

    @Override
    public String createValue() {
      return "null";
    }

  }

}
