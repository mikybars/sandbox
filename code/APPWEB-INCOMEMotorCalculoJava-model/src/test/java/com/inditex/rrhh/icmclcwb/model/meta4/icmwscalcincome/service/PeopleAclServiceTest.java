package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.rrhh.icmclccore.calculoincome.rest.client.api.TiendasOnlineApi;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchTiendasOnlineRequestDto;
import com.inditex.rrhh.icmclccore.calculoincome.rest.client.model.SearchTiendasOnlineResponseDto;
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
  PeopleAclMapper peopleAclMapper;

  @Captor
  ArgumentCaptor<SearchTiendasOnlineRequestDto> restRequestCaptor;

  @BeforeEach
  void beforeEach() {
    service = new PeopleAclService(tiendasOnlineApi, peopleAclMapper);
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
}
