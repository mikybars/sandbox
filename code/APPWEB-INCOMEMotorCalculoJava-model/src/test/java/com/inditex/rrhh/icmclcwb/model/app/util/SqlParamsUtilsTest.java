package com.inditex.rrhh.icmclcwb.model.app.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class SqlParamsUtilsTest {

  private static final String SQL_NON_MULTIPLE = "SELECT ID FROM TABLA WHERE VALUE = :VALUE";

  private static final String SQL_MULTIPLE = "SELECT ID FROM TABLA WHERE VALUE IN (:VALUE)";

  private static final String SQL_SEVERAL_VALUES = "SELECT ID FROM TABLA WHERE VALUE = :VALUE OR VALUE = :VALUE2 OR VALUE = :VALUE3";

  private static final String SQL_SAME_VALUE = "SELECT ID FROM TABLA WHERE VALUE1 = :VALUE OR VALUE2 = :VALUE";

  private static final String VALUE = "VALUE";

  private static final String VALUE2 = "VALUE2";

  private static final String VALUE3 = "VALUE3";

  @Test
  public void replaceValuesNullSql() {
    assertNull(SqlParamsUtils.replaceValues(null, new HashMap<>()));
  }

  @Test
  public void replaceValuesNullMap() {
    String result = SqlParamsUtils.replaceValues(SQL_NON_MULTIPLE, null);
    assertEquals(SQL_NON_MULTIPLE, result);
  }

  @Test
  public void replaceValuesMissingValue() {

    Map<String, Object> values = new HashMap<>();
    String result = SqlParamsUtils.replaceValues(SQL_NON_MULTIPLE, values);

    assertEquals(SQL_NON_MULTIPLE, result);
  }

  @Test
  public void replaceValuesNumericValue() {
    String expected = "SELECT ID FROM TABLA WHERE VALUE = 12";

    Map<String, Object> values = new HashMap<>();
    values.put(VALUE, 12);
    String result = SqlParamsUtils.replaceValues(SQL_NON_MULTIPLE, values);

    assertEquals(expected, result);
  }

  @Test
  public void replaceValuesStringValue() {
    String expected = "SELECT ID FROM TABLA WHERE VALUE = 'hola'";

    Map<String, Object> values = new HashMap<>();
    values.put(VALUE, "hola");
    String result = SqlParamsUtils.replaceValues(SQL_NON_MULTIPLE, values);

    assertEquals(expected, result);
  }

  @Test
  public void replaceValuesNumberListValue() {

    String expected = "SELECT ID FROM TABLA WHERE VALUE IN (12, 199)";
    Map<String, Object> values = new HashMap<>();
    values.put(VALUE, Arrays.asList(12, 199));

    String result = SqlParamsUtils.replaceValues(SQL_MULTIPLE, values);
    assertEquals(expected, result);
  }

  @Test
  public void replaceValuesStringListValue() {

    String expected = "SELECT ID FROM TABLA WHERE VALUE IN ('hola', 'adios')";
    Map<String, Object> values = new HashMap<>();
    values.put(VALUE, Arrays.asList("hola", "adios"));

    String result = SqlParamsUtils.replaceValues(SQL_MULTIPLE, values);
    assertEquals(expected, result);

  }

  @Test
  public void replaceValuesMixedListValue() {

    String expected = "SELECT ID FROM TABLA WHERE VALUE IN ('hola', 900)";
    Map<String, Object> values = new HashMap<>();
    values.put(VALUE, Arrays.asList("hola", 900));

    String result = SqlParamsUtils.replaceValues(SQL_MULTIPLE, values);
    assertEquals(expected, result);

  }

  @Test
  public void replaceValuesSeveralValues() {

    String expected = "SELECT ID FROM TABLA WHERE VALUE = 1 OR VALUE = 2 OR VALUE = 'hola'";
    Map<String, Object> values = new HashMap<>();
    values.put(VALUE, 1);
    values.put(VALUE2, 2);
    values.put(VALUE3, "hola");

    String result = SqlParamsUtils.replaceValues(SQL_SEVERAL_VALUES, values);
    assertEquals(expected, result);
  }

  @Test
  public void replaceValuesSameValue() {

    String expected = "SELECT ID FROM TABLA WHERE VALUE1 = 225 OR VALUE2 = 225";
    Map<String, Object> values = new HashMap<>();
    values.put(VALUE, 225);

    String result = SqlParamsUtils.replaceValues(SQL_SAME_VALUE, values);
    assertEquals(expected, result);
  }

}
