package com.inditex.rrhh.icmclcwb.model.meta4.service;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper.IcmWsCalcIncomeMapper;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeServiceImpl;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class Meta4PageableServiceImplTest {

  @InjectMocks
  private Meta4IcmWsCalcIncomeServiceImpl meta4IcmWsCalcIncomeServiceImpl;

  @InjectMocks
  private Meta4PageableServiceImpl meta4PageableServiceImpl;

  @Mock
  protected Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Mock
  private IcmWsCalcIncomeMapper icmWsCalcIncomeMapper;

  @Mock
  private Meta4ClientPool meta4ClientPool;

  @Mock
  private Map<String, Meta4PropertiesDto> meta4Properties;

  @Test
  public void getResultItemException() throws NoSuchMethodException, SecurityException, IllegalAccessException,
      IllegalArgumentException, InvocationTargetException {
    Assertions.assertThrows(Exception.class, () -> {

      final PageableDto<Serializable> request = new PageableDto<>();

      this.meta4PageableServiceImpl.getResultItem(request,
          Meta4PropertiesConstants.FLAG_CALCULA, FlagCalculaResponseDto.class,
          FlagCalculaResultItemDto.class);

      verify(this.meta4IcmWsCalcIncomeServiceImpl, timeout(1000).times(1))
          .getFlagCalcula(ArgumentMatchers.any(FlagCalculaRequestDto.class));
    });
  }

  @Test
  public void getResultItem() throws NoSuchMethodException, SecurityException, IllegalAccessException,
      IllegalArgumentException, InvocationTargetException {
    final FlagCalculaRequestDto request = new FlagCalculaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    final PageableListDto<Serializable> response = new PageableListDto<>();
    response.setData(new ArrayList<>());
    response.setPage(new PageDto(1, 100));
    final GetflagcalculaOutput output = new GetflagcalculaOutput();
    final IcmListatiendasBlock tiendas = new IcmListatiendasBlock();
    tiendas.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
    output.setIcmListatiendas(tiendas);
    output.getIcmListatiendas().getIcmListatiendasRecordSet();
    final IcmParametrospaginacionBlock block = new IcmParametrospaginacionBlock();
    block.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    output.setIcmParametrospaginacion(block);
    final List<GenericTiendaResultItemDto> tienda = new ArrayList<GenericTiendaResultItemDto>();
    tienda.add(new GenericTiendaResultItemDto());

    this.meta4PageableServiceImpl.getResultItem(request,
        Meta4PropertiesConstants.FLAG_CALCULA, FlagCalculaResponseDto.class, FlagCalculaResultItemDto.class);

    verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1))
        .getFlagCalcula(ArgumentMatchers.any(FlagCalculaRequestDto.class));
  }

}
