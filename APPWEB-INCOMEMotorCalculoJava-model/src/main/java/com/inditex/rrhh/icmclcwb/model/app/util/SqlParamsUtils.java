package com.inditex.rrhh.icmclcwb.model.app.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class SqlParamsUtils {

    private static final String REGEXP_GROUP_1 = "$1";

    private static final String REGEXP_GROUP_3 = "$3";

    private static final String REGEXP_GROUP_1_REGEXP = "((\\(|=) *):";

    private static final String REGEXP_GROUP_3_REGEXP = "($|\\n|\\)| )";

    private SqlParamsUtils() {
    }

    /**
     * <b>Importante:</b> Este metodo no debe usarse para ejeuctar SQL, es para imprimir en el log las
     * consultas.
     */
    public static String replaceValues(String sql, Map<String, ? extends Object> params) {

        String result = sql;
        if (sql != null && params != null) {
            Iterator<String> iterator = params.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = createValueCreator(params.get(key)).createValue();
                String paramRegexp = new StringBuilder(REGEXP_GROUP_1_REGEXP).append(key)
                    .append(REGEXP_GROUP_3_REGEXP)
                    .toString();
                Pattern pattern = Pattern.compile(paramRegexp);
                Matcher matcher = pattern.matcher(result);
                if (matcher.find()) {
                    String v = new StringBuilder(REGEXP_GROUP_1).append(value).append(REGEXP_GROUP_3).toString();
                    result = matcher.replaceAll(v);
                }
                result = result.replaceAll(paramRegexp, value);
            }
        }

        return result;
    }

    private static ValueCreator createValueCreator(Object value) {
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

        private String value;

        private static final String SIMPLE_QUOTE = "'";

        @Override
        public String createValue() {
            return new StringBuilder(SIMPLE_QUOTE).append(value).append(SIMPLE_QUOTE).toString();
        }

    }

    @Data
    @AllArgsConstructor
    private static class DefaultValueCreator implements ValueCreator {

        private Object value;

        @Override
        public String createValue() {
            return value.toString();
        }

    }

    @Data
    @AllArgsConstructor
    private static class ListValueCreator implements ValueCreator {

        Collection<?> list;

        @Override
        public String createValue() {
            Stream<String> stream = list.stream().map(value -> createValueCreator(value).createValue());
            List<String> cleanList = stream.collect(Collectors.toList());
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
