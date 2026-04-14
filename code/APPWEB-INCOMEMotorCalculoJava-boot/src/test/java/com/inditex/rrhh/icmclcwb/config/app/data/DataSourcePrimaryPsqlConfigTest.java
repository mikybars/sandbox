package com.inditex.rrhh.icmclcwb.config.app.data;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.inditex.amigafwk.data.jdbc.datasources.DataSourceBuilder;
import com.inditex.amigafwk.data.jdbc.datasources.DataSourceType;

import javax.sql.DataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class DataSourcePrimaryPsqlConfigTest {

  @InjectMocks
  private DataSourcePrimaryPsqlConfig dataSourcePrimaryPsqlConfig;

  @Mock
  private DataSourceBuilder dataSourceBuilder;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void primaryDataSourceShouldReturnDataSource() {
    final DataSource dataSource = mock(DataSource.class);
    when(this.dataSourceBuilder.build(DataSourceType.NONXA)).thenReturn(dataSource);

    final DataSource result = this.dataSourcePrimaryPsqlConfig.primaryDataSource(this.dataSourceBuilder);

    assertNotNull(result);
  }

}
