package com.inditex.rrhh.icmclcwb.model.secondary.repository;

import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.esotericsoftware.minlog.Log;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockDetalleComisionable;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockDetalle;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockTotalTienda;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockTotalTiendaSeccion;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockTiposHoras;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.PtrPresenciasMockDetalleRowMapper;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.PtrPresenciasMockTotalTiendaRowMapper;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.PtrPresenciasMockTotalTiendaSeccionRowMapper;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.PtrPresenciasMockTiposHorasRowMapper;

@Repository("PTRPresenciasRepositoryJDBCTemplate")
public class PtrPresenciasMockRepositoryImpl implements PtrPresenciasMockRepository {

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public List<PtrPresenciasMockDetalle> findPresencias(PtrPresenciasMockDetalleRequestDto params) {

		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		MapSqlParameterSource param = new MapSqlParameterSource();

		StringBuilder query = new StringBuilder();

		query.append(
				"SELECT P.PERSONA AS 'EMPLEADO', P.TIENDA AS 'ID_TIENDA', P.SECCION AS 'ID_SECCION', P.TIPO AS 'ID_TIPO', P.FECHA AS 'FECHA', P.CCL_ID_CADENA AS 'CADENA', (CAST(P.HORAS AS int) * 60) + PARSENAME(P.HORAS, 1) AS 'MINUTOS', 'FALSE' 'MODIFICADO_INCOME' FROM (SELECT PT.ID_ORGANIZATION, PT.PERSONA, PT.TIENDA, PT.SECCION, PT.TIPO, PT.FECHA, SP.CCL_ID_CADENA, PT.HORAS, ROW_NUMBER() OVER (PARTITION BY SP.STD_ID_WORK_LOCAT, PT.PERSONA, PT.FECHA ORDER BY SP.STD_ID_WORK_LOCAT) AS REG_NUM FROM ");

		if (params.getOrigen() != null) {
			String origen = "";
			if (params.getOrigen() == 11) {
				query.append(
						" PRESENCIAS_HORARIOS PT INNER JOIN STD_WORK_LOCATION SW WITH (NOLOCK) ON SW.CCL_ID_COD_ORIGEN = CAST(PT.TIENDA AS nvarchar) INNER JOIN M4CCL_ATRIB_WLOC SP ON SP.STD_ID_WORK_LOCAT = SW.STD_ID_WORK_LOCAT AND SP.CCL_DT_START <= PT.FECHA AND PT.FECHA <= SP.CCL_DT_END WHERE 1 = 1 AND PT.ERROR = 'OK' ");
				param.addValue("origen", params.getOrigen());
			} else {
				query.append(
						" M4CCL_PRESENCIAS_TA PT INNER JOIN STD_WORK_LOCATION SW WITH (NOLOCK) ON SW.CCL_ID_COD_ORIGEN = CAST(PT.TIENDA AS nvarchar) INNER JOIN M4CCL_ATRIB_WLOC SP ON SP.STD_ID_WORK_LOCAT = SW.STD_ID_WORK_LOCAT AND SP.CCL_DT_START <= PT.FECHA AND PT.FECHA <= SP.CCL_DT_END WHERE 1 = 1 AND PT.ERROR = 'OK' ");
				param.addValue("origen", params.getOrigen());
			}
		}

		if (params.getFechaDesde() != null) {
			String fecha1 = formatter.format(params.getFechaDesde());
			query.append(" AND FECHA >= CONVERT (datetime, :fechadesde, 103) ");
			param.addValue("fechadesde", fecha1);
		}

		if (params.getFechaHasta() != null) {
			String fecha2 = formatter.format(params.getFechaHasta());
			query.append(" AND FECHA <= CONVERT (datetime, :fechahasta, 103)  ");
			param.addValue("fechahasta", fecha2);
		}

		query.append(
				" ) P INNER JOIN M4CCL_ORGANIZACION_PAIS OP WITH (NOLOCK) ON P.ID_ORGANIZATION = OP.ID_ORGANIZATION AND P.REG_NUM = 1 WHERE 1 = 1 ");

		if (params.getSeccion() != null) {
			query.append(" AND P.SECCION IN ( :seccion ) ");
			param.addValue("seccion", params.getSeccion());
		}

		if (params.getOrigen() != null) {
			query.append(" AND OP.CCL_ID_ORIGEN IN ( :origen ) ");
			param.addValue("origen", params.getOrigen());
		}
		if (params.getTipo() != null) {
			query.append(" AND P.TIPO IN ( :tipo )");
			param.addValue("tipo", params.getTipo());
		}
		if (params.getCadena() != null) {
			query.append(" AND P.CCL_ID_CADENA IN ( ");
			if (params.getCadena().get(0) != null) {
				query.append(" :cadena0 ");
				param.addValue("cadena0", params.getCadena().get(0));
			}
			for (Integer e = 1; e < params.getCadena().size(); e++) {
				query.append(", :cadena" + e.toString() + " ");
				param.addValue("cadena" + e.toString(), params.getCadena().get(e));
			}
			query.append(")");
		}

		if (params.getTienda() != null) {
			query.append(" AND P.TIENDA IN (:tienda)");
			param.addValue("tienda", params.getTienda());
		}
		if (params.getPersonas() != null) {
			int size = params.getPersonas().size();
			if (size > 0) {
				query.append(" AND (P.PERSONA IN ( :persona0");
				param.addValue("persona0", params.getPersonas().get(0));
				for (Integer i = 1; i < size; i++) {
					query.append(" , :persona" + i.toString() + " ");
					param.addValue("persona" + i.toString(), params.getPersonas().get(i));
				}
				query.append(" ))");
			}
		}
		Log.info(query.toString());
		return namedParameterJdbcTemplate.query(query.toString(), param, new PtrPresenciasMockDetalleRowMapper());
	}

	@Override
	public List<PtrPresenciasMockDetalleComisionable> findPresenciasComisionable(Object[] Params) {
		return null;
	}

	@Override
	public List<PtrPresenciasMockTotalTienda> findPresenciasTotalTienda(PtrPresenciasMockTotalTiendaRequestDto dto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		MapSqlParameterSource param = new MapSqlParameterSource();

		StringBuilder query = new StringBuilder();
		String origen = "";
		query.append(
				"SELECT P.TIENDA AS 'ID_TIENDA', P.FECHA AS 'FECHA',  SUM((CAST(P.HORAS AS int) * 60) + PARSENAME(P.HORAS, 1)) AS 'MINUTOS' FROM (SELECT PT.TIENDA, PT.FECHA, PT.HORAS, PT.TIPO, PT.ID_ORGANIZATION, SP.STD_ID_WORK_LOCAT, SP.CCL_ID_CADENA, SP.STD_ID_LEG_ENT,ROW_NUMBER() OVER (PARTITION BY SP.STD_ID_WORK_LOCAT, PT.PERSONA, PT.FECHA ORDER BY SP.STD_ID_WORK_LOCAT) AS REG_NUM");
		if (dto.getOrigen() != null) {
			if (dto.getOrigen() == 11) {
				query.append(" FROM PRESENCIAS_HORARIOS PT");
			} else {
				query.append(" FROM M4CCL_PRESENCIAS_TA PT");
			}
			origen = " AND OP.CCL_ID_ORIGEN = :origen ";
			param.addValue("origen", dto.getOrigen());
		}

		query.append(
				" INNER JOIN STD_WORK_LOCATION SW WITH (NOLOCK) ON SW.CCL_ID_COD_ORIGEN = CAST(PT.TIENDA AS nvarchar) INNER JOIN M4CCL_ATRIB_WLOC SP ON SP.STD_ID_WORK_LOCAT = SW.STD_ID_WORK_LOCAT AND SP.CCL_DT_START <= PT.FECHA AND PT.FECHA <= SP.CCL_DT_END WHERE 1 = 1 AND PT.ERROR = 'OK' ");

		if (dto.getFechaDesde() != null) {
			String fecha1 = formatter.format(dto.getFechaDesde());
			query.append(" AND PT.FECHA >=  CONVERT(datetime, :fechadesde , 103) ");
			param.addValue("fechadesde", fecha1);
		}
		if (dto.getFechaHasta() != null) {
			String fecha2 = formatter.format(dto.getFechaHasta());
			query.append(" AND PT.FECHA <= CONVERT(datetime, :fechahasta, 103) ");
			param.addValue("fechahasta", fecha2);
		}

		query.append(
				") P INNER JOIN M4CCL_ORGANIZACION_PAIS OP WITH (NOLOCK) ON P.ID_ORGANIZATION = OP.ID_ORGANIZATION AND P.REG_NUM = 1 WHERE 1 = 1 "
						+ origen);

		if (dto.getOrigen() != null) {
			query.append(" AND OP.CCL_ID_ORIGEN IN ( :origen)");
		}
		if (dto.getCadena() != null) {
			query.append(" AND P.CCL_ID_CADENA IN ( ");
			if (dto.getCadena().get(0) != null) {
				query.append(" :cadena0 ");
				param.addValue("cadena0", dto.getCadena().get(0));
			}
			for (Integer e = 1; e < dto.getCadena().size(); e++) {
				query.append(", :cadena" + e.toString() + " ");
				param.addValue("cadena" + e.toString(), dto.getCadena().get(e));
			}
			query.append(")");
		}
		if (dto.getTipo() != null) {
			query.append(" AND P.TIPO IN ( :tipo)");
			param.addValue("tipo", dto.getTipo());
		}

		if (dto.getTiendas() != null) {
			int size = dto.getTiendas().size();
			if (size > 0) {
				query.append(" AND (P.TIENDA IN ( :tienda0");
				param.addValue("tienda0", dto.getTiendas().get(0));

				for (Integer i = 1; i < size; i++) {
					query.append(" ,:tienda" + i.toString() + " ");
					param.addValue("tienda" + i.toString(), dto.getTiendas().get(i));
				}
				query.append("))");
			}
		}
		query.append(origen);
		query.append(" GROUP BY OP.CCL_ID_ORIGEN,P.TIENDA,P.FECHA");
		return namedParameterJdbcTemplate.query(query.toString(), param, new PtrPresenciasMockTotalTiendaRowMapper());
	}

	@Override
	public List<PtrPresenciasMockTotalTiendaSeccion> findPresenciasTotalTiendaSeccion(
			PtrPresenciasMockTotalTiendaSeccionRequestDto dto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		MapSqlParameterSource param = new MapSqlParameterSource();

		StringBuilder query = new StringBuilder();
		query.append(
				"SELECT P.TIENDA AS 'ID_TIENDA', P.FECHA AS 'FECHA', P.SECCION AS 'ID_SECCION', SUM((CAST(P.HORAS AS int) * 60) + "
						+ " PARSENAME(P.HORAS, 1)) AS 'MINUTOS' FROM (SELECT PT.TIENDA,PT.FECHA,PT.HORAS,PT.TIPO,PT.ID_ORGANIZATION, "
						+ " PT.SECCION,SP.STD_ID_WORK_LOCAT, SP.CCL_ID_CADENA, SP.STD_ID_LEG_ENT, ROW_NUMBER() OVER"
						+ " (PARTITION BY SP.STD_ID_WORK_LOCAT, PT.PERSONA, PT.FECHA ORDER BY SP.STD_ID_WORK_LOCAT) AS REG_NUM FROM ");
		String origen = "";
		if (dto.getOrigen() != null) {
			if (dto.getOrigen() == 11) {
				query.append(" PRESENCIAS_HORARIOS PT");
			} else {
				query.append(" M4CCL_PRESENCIAS_TA PT");
			}
			origen = " AND OP.CCL_ID_ORIGEN = :origen ";
			param.addValue("origen", dto.getOrigen());
		}
		query.append(
				" INNER JOIN STD_WORK_LOCATION SW WITH (NOLOCK) ON SW.CCL_ID_COD_ORIGEN = CAST(PT.TIENDA AS nvarchar) INNER "
						+ " JOIN M4CCL_ATRIB_WLOC SP ON SP.STD_ID_WORK_LOCAT = SW.STD_ID_WORK_LOCAT AND SP.CCL_DT_START <= PT.FECHA "
						+ " AND PT.FECHA <= SP.CCL_DT_END WHERE 1 = 1");

		if (dto.getFechaDesde() != null) {
			String fecha1 = formatter.format(dto.getFechaDesde());
			query.append(" AND PT.FECHA >=   CONVERT(datetime, :fechadesde , 103) ");
			param.addValue("fechadesde", fecha1);
		}
		if (dto.getFechaHasta() != null) {
			String fecha2 = formatter.format(dto.getFechaHasta());
			query.append(" AND PT.FECHA <=  CONVERT(datetime, :fechahasta , 103) ");
			param.addValue("fechahasta", fecha2);
		}
		query.append(" AND PT.ERROR = 'OK') P INNER JOIN M4CCL_ORGANIZACION_PAIS OP WITH "
				+ "(NOLOCK) ON P.ID_ORGANIZATION = OP.ID_ORGANIZATION AND P.REG_NUM = 1 WHERE 1 = 1 " + origen);
		if (dto.getTipo() != null) {
			query.append(" AND P.TIPO = :tipo  ");
			param.addValue("tipo", dto.getTipo());
		}

		if (dto.getCadena() != null) {
			query.append(" AND P.CCL_ID_CADENA IN ( ");
			if (dto.getCadena().get(0) != null) {
				query.append(" :cadena0 ");
				param.addValue("cadena0", dto.getCadena().get(0));
			}
			for (Integer e = 1; e < dto.getCadena().size(); e++) {
				query.append(", :cadena" + e.toString() + " ");
				param.addValue("cadena" + e.toString(), dto.getCadena().get(e));
			}
			query.append(")");
		}

		if (dto.getTiendaSeccion() != null) {
			int size = dto.getTiendaSeccion().size();
			if (size > 0) {
				if (dto.getTiendaSeccion().get(0).getSeccion() == null) {
					query.append(" AND  ((P.TIENDA = :tienda0 ) ");
					param.addValue("tienda0", dto.getTiendaSeccion().get(0).getTienda());
				} else {
					query.append(" AND  ((P.TIENDA = :tienda0 AND P.SECCION = :seccion0 ) ");
					param.addValue("tienda0", dto.getTiendaSeccion().get(0).getTienda());
					param.addValue("seccion0", dto.getTiendaSeccion().get(0).getSeccion());
				}

				for (Integer i = 1; i < size; i++) {

					if (dto.getTiendaSeccion().get(i).getSeccion() == null) {
						query.append(" OR  (P.TIENDA = :tienda" + i.toString() + " ) ");
						param.addValue("tienda" + i.toString(), dto.getTiendaSeccion().get(i).getTienda());
					} else {
						query.append(" OR  (P.TIENDA = :tienda" + i.toString() + " AND P.SECCION = :seccion "
								+ i.toString() + " )");
						param.addValue("tienda" + i.toString(), dto.getTiendaSeccion().get(i).getTienda());
						param.addValue("seccion" + i.toString(), dto.getTiendaSeccion().get(i).getSeccion());
					}

				}
				query.append(")");
			}

		}
		query.append(" GROUP BY OP.CCL_ID_ORIGEN, P.TIENDA,P.SECCION,  P.FECHA");
		Log.info(query.toString());
		return namedParameterJdbcTemplate.query(query.toString(), param,
				new PtrPresenciasMockTotalTiendaSeccionRowMapper());
	}

	@Override
	public List<PtrPresenciasMockTiposHoras> findTiposHoras(PtrPresenciasMockTiposHorasRequestDto dto) {
		List<PtrPresenciasMockTiposHoras> presencias;

		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		MapSqlParameterSource param = new MapSqlParameterSource();

		StringBuilder query = new StringBuilder();

		query.append("SELECT 'TRUE' EXCLUIDODENOM, 'FALSE' EXCLUIDOCALCULO ,TIPO ,OP.CCL_ID_ORIGEN FROM");
		if (dto.getOrigen() == 11) {
			query.append(
					" [dbo].[PRESENCIAS_HORARIOS] P INNER JOIN M4CCL_ORGANIZACION_PAIS OP ON  P.ID_ORGANIZATION=OP.ID_ORGANIZATION WHERE  ERROR = 'OK'  ");
		} else {
			query.append(
					" [dbo].[M4CCL_PRESENCIAS_TA ] P INNER JOIN M4CCL_ORGANIZACION_PAIS OP ON  P.ID_ORGANIZATION=OP.ID_ORGANIZATION WHERE  ERROR = 'OK'  ");
		}
		query.append(" AND OP.CCL_ID_ORIGEN= :origen ");
		param.addValue("origen", dto.getOrigen());
		if (dto.getTipoHora() != null) {
			query.append(" AND P.TIPO= :tipo");
			param.addValue("tipo", dto.getTipoHora());
		}
		query.append(" GROUP BY OP.CCL_ID_ORIGEN, TIPO ");

		return namedParameterJdbcTemplate.query(query.toString(), param, new PtrPresenciasMockTiposHorasRowMapper());
	}

}