package com.inditex.rrhh.icmclcwb.model.app.service.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.dto.PaginationConfigPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.PageDto;

@Service
public class PaginationPropertiesFactory {

	@Autowired
	@Qualifier("paginationProperties")
	private List<PaginationConfigPropertiesDto> page;

    private static final Map<String, PaginationConfigPropertiesDto> propertiesCache = new HashMap<>();

    @PostConstruct
    public void initProperties() {
    	if(page != null && page.size() > 0){
    		for(PaginationConfigPropertiesDto pag : page) {
                propertiesCache.put(pag.getMethodName(), pag);
            }
    	}
    }

    public static PageDto getProperties(String methodName) {
    	PaginationConfigPropertiesDto props = propertiesCache.get(methodName);
        if(props == null) {
        	throw new RuntimeException("Unknown properties: " + methodName);
        }
		
        return getPageDTO(props);
    }

	private static PageDto getPageDTO(PaginationConfigPropertiesDto props) {
		return PageDto.builder()
				.campoOrden(props.getCampoOrden()).tipoOrden(props.getTipoOrden())
				.numeroPagina(props.getNumeroPagina()).numeroRegistrosPagina(props.getNumeroRegistrosPagina())
				.build();
	}
	
}
