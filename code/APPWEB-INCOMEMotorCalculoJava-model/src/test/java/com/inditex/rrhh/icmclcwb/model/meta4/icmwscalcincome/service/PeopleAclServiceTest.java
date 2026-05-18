package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.OrigenesApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.TiendasOnlineApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchOrigenesRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchOrigenesResponseDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchTiendasOnlineRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchTiendasOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper.PeopleAclMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PeopleAclServiceTest {

  PeopleAclService service;

  @Mock
  TiendasOnlineApi tiendasOnlineApi;

  @Mock
  OrigenesApi origenesApi;

  @Mock
  PeopleAclMapper peopleAclMapper;

  @Captor
  ArgumentCaptor<SearchTiendasOnlineRequestDto> restRequestCaptor;

  @Captor
  ArgumentCaptor<SearchOrigenesRequestDto> origenesRestRequestCaptor;

  @BeforeEach
  void beforeEach() {
    service = new PeopleAclService(tiendasOnlineApi, origenesApi, peopleAclMapper);
  }

  @Nested
  class SearchTiendasOnline {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
      SearchTiendasOnlineRequestDto restRequest = new SearchTiendasOnlineRequestDto();
      SearchTiendasOnlineResponseDto restResponse = new SearchTiendasOnlineResponseDto();
      TiendaOnlineResponseDto expected = new TiendaOnlineResponseDto();
      when(peopleAclMapper.toSearchTiendasOnlineRequestDto(request)).thenReturn(restRequest);
      when(tiendasOnlineApi.searchTiendasOnline(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toTiendaOnlineResponseDto(restResponse)).thenReturn(expected);

      TiendaOnlineResponseDto result = service.searchTiendasOnline(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenInvokedExpectRequestMappedAndPassedToRestClient() {
      TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
      SearchTiendasOnlineRequestDto restRequest = new SearchTiendasOnlineRequestDto();
      when(peopleAclMapper.toSearchTiendasOnlineRequestDto(request)).thenReturn(restRequest);

      service.searchTiendasOnline(request);

      verify(peopleAclMapper, times(1)).toSearchTiendasOnlineRequestDto(request);
      verify(tiendasOnlineApi, times(1)).searchTiendasOnline(restRequestCaptor.capture());
      assertThat(restRequestCaptor.getValue()).isSameAs(restRequest);
    }

    @Test
    void whenRestClientReturnsResponseExpectMappedToApiDto() {
      TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
      SearchTiendasOnlineRequestDto restRequest = new SearchTiendasOnlineRequestDto();
      SearchTiendasOnlineResponseDto restResponse = new SearchTiendasOnlineResponseDto();
      when(peopleAclMapper.toSearchTiendasOnlineRequestDto(request)).thenReturn(restRequest);
      when(tiendasOnlineApi.searchTiendasOnline(restRequest)).thenReturn(restResponse);

      service.searchTiendasOnline(request);

      verify(peopleAclMapper, times(1)).toTiendaOnlineResponseDto(restResponse);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
      SearchTiendasOnlineRequestDto restRequest = new SearchTiendasOnlineRequestDto();
      when(peopleAclMapper.toSearchTiendasOnlineRequestDto(request)).thenReturn(restRequest);
      when(tiendasOnlineApi.searchTiendasOnline(restRequest)).thenReturn(null);
      when(peopleAclMapper.toTiendaOnlineResponseDto(null)).thenReturn(null);

      TiendaOnlineResponseDto result = service.searchTiendasOnline(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toTiendaOnlineResponseDto(null);
    }
  }

  @Nested
  class SearchOrigenes {

    @Test
    void whenInvokedExpectMappedResponseReturned() {
      OrigenRequestDto request = new OrigenRequestDto();
      SearchOrigenesRequestDto restRequest = new SearchOrigenesRequestDto();
      SearchOrigenesResponseDto restResponse = new SearchOrigenesResponseDto();
      OrigenResponseDto expected = new OrigenResponseDto();
      when(peopleAclMapper.toSearchOrigenesRequestDto(request)).thenReturn(restRequest);
      when(origenesApi.searchOrigenes(restRequest)).thenReturn(restResponse);
      when(peopleAclMapper.toOrigenResponseDto(restResponse)).thenReturn(expected);

      OrigenResponseDto result = service.searchOrigenes(request);

      assertThat(result).isSameAs(expected);
    }

    @Test
    void whenInvokedExpectRequestMappedAndPassedToRestClient() {
      OrigenRequestDto request = new OrigenRequestDto();
      SearchOrigenesRequestDto restRequest = new SearchOrigenesRequestDto();
      when(peopleAclMapper.toSearchOrigenesRequestDto(request)).thenReturn(restRequest);

      service.searchOrigenes(request);

      verify(peopleAclMapper, times(1)).toSearchOrigenesRequestDto(request);
      verify(origenesApi, times(1)).searchOrigenes(origenesRestRequestCaptor.capture());
      assertThat(origenesRestRequestCaptor.getValue()).isSameAs(restRequest);
    }

    @Test
    void whenRestClientReturnsResponseExpectMappedToApiDto() {
      OrigenRequestDto request = new OrigenRequestDto();
      SearchOrigenesRequestDto restRequest = new SearchOrigenesRequestDto();
      SearchOrigenesResponseDto restResponse = new SearchOrigenesResponseDto();
      when(peopleAclMapper.toSearchOrigenesRequestDto(request)).thenReturn(restRequest);
      when(origenesApi.searchOrigenes(restRequest)).thenReturn(restResponse);

      service.searchOrigenes(request);

      verify(peopleAclMapper, times(1)).toOrigenResponseDto(restResponse);
    }

    @Test
    void whenRestClientReturnsNullExpectMapperInvokedWithNullAndNullReturned() {
      OrigenRequestDto request = new OrigenRequestDto();
      SearchOrigenesRequestDto restRequest = new SearchOrigenesRequestDto();
      when(peopleAclMapper.toSearchOrigenesRequestDto(request)).thenReturn(restRequest);
      when(origenesApi.searchOrigenes(restRequest)).thenReturn(null);
      when(peopleAclMapper.toOrigenResponseDto(null)).thenReturn(null);

      OrigenResponseDto result = service.searchOrigenes(request);

      assertThat(result).isNull();
      verify(peopleAclMapper, times(1)).toOrigenResponseDto(null);
    }
  }
}
