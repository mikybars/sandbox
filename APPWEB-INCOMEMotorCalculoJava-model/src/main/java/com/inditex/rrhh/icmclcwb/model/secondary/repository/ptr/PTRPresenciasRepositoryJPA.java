package com.inditex.rrhh.icmclcwb.model.secondary.repository.ptr;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleMock;


public interface PTRPresenciasRepositoryJPA extends BaseRepository<PresenciaDetalleMock, Integer>{
	
	@Query(value="SELECT [ID],[TIPO],[TIENDA],[FECHA],[SECCION],[PERSONA],[HORAS],[CCL_ID_ORIGEN] FROM [dbo].[PRESENCIAS_HORARIOS] P INNER JOIN M4CCL_ORGANIZACION_PAIS OP ON  P.ID_ORGANIZATION=OP.ID_ORGANIZATION AND OP.CCL_ID_ORIGEN=11 WHERE TIENDA = :tienda AND FECHA >= :fecha1 AND FECHA <= :fecha2 AND ERROR = 'OK'",nativeQuery=true)
	List<PresenciaDetalleMock> findPresencias(@Param("tienda") String tienda,@Param("fecha1") String fecha1,@Param("fecha2") String fecha2);
	/**PresenciaDetalleComisionableMock findPresenciasComisionable( PresenciaDetalleComisionableMock presencia);
	PresenciaTotalTiendaMock findPresenciasTotalTienda( PresenciaTotalTiendaMock presencia);
	PresenciaTotalTiendaSeccionMock findPresenciasTotalTiendaSeccion( PresenciaTotalTiendaSeccionMock presencia);
	TiposHorasMock findTiposHoras( TiposHorasMock presencia);**/
}
