package com.inditex.rrhh.icmclcwb.config.pipe;

import static org.mockito.Mockito.when;

import com.inditex.aqsw.pipe.TracingResolverSessionId;
import com.inditex.aqsw.pipe.v1.MetadataBuilder;
import com.inditex.aqsw.pipe.v1.MetadataBuilderImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class CommisionCalculationConfigurationTest {

  @Mock
  private TracingResolverSessionId tracingResolverSessionId;

  @InjectMocks
  private CommisionCalculationConfiguration commisionCalculationConfiguration;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
    when(this.tracingResolverSessionId.getItxSessionId()).thenReturn("mockSessionId");
  }

  @Test
  public void metadataBuilderShouldReturnMetadataBuilderImpl() {
    final MetadataBuilder metadataBuilder = this.commisionCalculationConfiguration.metadataBuilder(this.tracingResolverSessionId);
    assert (metadataBuilder instanceof MetadataBuilderImpl);
  }
}
