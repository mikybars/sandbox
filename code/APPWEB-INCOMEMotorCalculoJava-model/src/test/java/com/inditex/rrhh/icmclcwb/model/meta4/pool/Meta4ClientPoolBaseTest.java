package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.inditex.rrhh.icmclcwb.api.meta4.exception.Meta4IcmclcwbException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import stormpot.Pool;
import stormpot.PoolException;
import stormpot.Timeout;

@ExtendWith(SpringExtension.class)
public class Meta4ClientPoolBaseTest {

  @Mock
  private Pool<Meta4ClientPoolable> pool;

  @Mock
  private Meta4ClientPoolable poolable;

  @InjectMocks
  private Meta4ClientPoolBase meta4ClientPoolBase;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
    public void claimShouldThrowExceptionWhenPoolClaimReturnsNull() throws InterruptedException, PoolException {
        when(this.pool.claim(any(Timeout.class))).thenReturn(null);
        assertThrows(Meta4IcmclcwbException.class, () -> this.meta4ClientPoolBase.claim(this.pool));
    }

  @Test
    public void claimShouldThrowExceptionWhenPoolClaimThrowsPoolException() throws InterruptedException, PoolException {
        when(this.pool.claim(any(Timeout.class))).thenThrow(PoolException.class);
        assertThrows(Meta4IcmclcwbException.class, () -> this.meta4ClientPoolBase.claim(this.pool));
    }

  @Test
    public void claimShouldThrowExceptionWhenPoolClaimThrowsInterruptedException() throws InterruptedException, PoolException {
        when(this.pool.claim(any(Timeout.class))).thenThrow(InterruptedException.class);
        assertThrows(Meta4IcmclcwbException.class, () -> this.meta4ClientPoolBase.claim(this.pool));
    }

}
