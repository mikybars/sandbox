package com.inditex.rrhh.icmclcwb.config.app.data.query;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class QueryPropertiesLoaderTest {

  private static final String RESOURCE_PATTERN = "classpath*:/query/test/*.xml";

  private static final String PRECISION = "NUMERIC(20,4)";

  private static final String DECIMAL = "4";

  @Mock
  private ResourceLoader resourceLoader;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @ParameterizedTest(name = "cast={0}, round={1}")
  @CsvSource({
      "false, false",
      "true,  false",
      "false, true",
      "true,  true"
  })
  void loadBeanShouldReturnBean(final boolean cast, final boolean round) throws IOException {
    final PropertiesFactoryBean result =
        QueryPropertiesLoader.loadBean(this.resourceLoader, RESOURCE_PATTERN, PRECISION, DECIMAL, cast, round);

    assertNotNull(result);
    verify(this.resourceLoader, times(1)).getClassLoader();
  }

}
