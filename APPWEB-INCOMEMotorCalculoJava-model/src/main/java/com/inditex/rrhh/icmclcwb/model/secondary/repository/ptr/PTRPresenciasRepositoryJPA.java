package com.inditex.rrhh.icmclcwb.model.secondary.repository.ptr;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleComisionableMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaTotalTiendaMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaTotalTiendaSeccionMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.TiposHorasMock;


public interface PTRPresenciasRepositoryJPA extends BaseRepository<PresenciaDetalleMock, Integer>{
	
	@Query(value="SELECT TOP 10 [ID],[TIPO],[TIENDA],[FECHA],[SECCION],[PERSONA],[HORAS],[CCL_ID_ORIGEN] FROM [dbo].[PRESENCIAS_HORARIOS] P INNER JOIN M4CCL_ORGANIZACION_PAIS OP ON  P.ID_ORGANIZATION=OP.ID_ORGANIZATION AND OP.CCL_ID_ORIGEN=11",nativeQuery=true)
	List<PresenciaDetalleMock> findPresencias();
	
	/**PresenciaDetalleComisionableMock findPresenciasComisionable( PresenciaDetalleComisionableMock presencia);
	PresenciaTotalTiendaMock findPresenciasTotalTienda( PresenciaTotalTiendaMock presencia);
	PresenciaTotalTiendaSeccionMock findPresenciasTotalTiendaSeccion( PresenciaTotalTiendaSeccionMock presencia);
	TiposHorasMock findTiposHoras( TiposHorasMock presencia);**/
}
