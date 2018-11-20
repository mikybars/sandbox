package com.inditex.rrhh.icmclcwb.model.secondary.repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaDetalleComisionableMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaSeccionMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.TiposHorasMock;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.PresenciaDetalleMockRowMapper;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.PresenciaTotalTiendaMockRowMapper;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.PresenciaTotalTiendaSeccionMockRowMapper;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.TiposHorasMockRowMapper;

@Repository("PTRPresenciasRepositoryJDBCTemplate")
public class PtrPresenciasMockRepositoryImpl implements PtrPresenciasMockRepository {

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public List<PresenciaDetalleMock> findPresencias(PresenciasDetalleRequestDto params) {

        if (request.getFechaDesde() != null) {
            String fecha1 = formatter.format(request.getFechaDesde());
            query.append(" AND FECHA >= CONVERT (datetime, :fechadesde, 103) ");
            param.addValue("fechadesde", fecha1);
        }

        if (request.getFechaHasta() != null) {
            String fecha2 = formatter.format(request.getFechaHasta());
            query.append(" AND FECHA <= CONVERT (datetime, :fechahasta, 103)  ");
            param.addValue("fechahasta", fecha2);
        }

        query.append(
                " ) P INNER JOIN M4CCL_ORGANIZACION_PAIS OP WITH (NOLOCK) ON P.ID_ORGANIZATION = OP.ID_ORGANIZATION AND P.REG_NUM = 1 WHERE 1 = 1 ");

        if (request.getSeccion() != null) {
            query.append(" AND P.SECCION IN ( :seccion ) ");
            param.addValue("seccion", request.getSeccion());
        }

		if (params.getFechaDesde() != null) {
			String fecha1 = formatter.format(params.getFechaDesde());
			query.append(" AND FECHA >= CONVERT (datetime, :fechadesde, 103) ");
			param.addValue("fechadesde", fecha1);
		}

        if (request.getTienda() != null) {
            query.append(" AND P.TIENDA IN (:tienda)");
            param.addValue("tienda", request.getTienda());
        }
        if (request.getPersonas() != null) {
            int size = request.getPersonas().size();
            if (size > 0) {
                query.append(" AND (P.PERSONA IN ( :persona0");
                param.addValue("persona0", request.getPersonas().get(0));
                for (Integer i = 1; i < size; i++) {
                    query.append(" , :persona" + i.toString() + " ");
                    param.addValue("persona" + i.toString(), request.getPersonas().get(i));
                }
                query.append(" ))");
            }
        }
        return namedParameterJdbcTemplate.query(query.toString(), param, new PresenciaDetalleMockRowMapper());
    }

    @Override
    public List<PresenciaDetalleComisionableMock> findPresenciasComisionable(Object[] request) {
        return new ArrayList<>();
    }

    @Override
    public List<PresenciaTotalTiendaMock> findPresenciasTotalTienda(PresenciasTotalTiendaRequestDto request) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        MapSqlParameterSource param = new MapSqlParameterSource();

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

        query.append(
                " INNER JOIN STD_WORK_LOCATION SW WITH (NOLOCK) ON SW.CCL_ID_COD_ORIGEN = CAST(PT.TIENDA AS nvarchar) INNER JOIN M4CCL_ATRIB_WLOC SP ON SP.STD_ID_WORK_LOCAT = SW.STD_ID_WORK_LOCAT AND SP.CCL_DT_START <= PT.FECHA AND PT.FECHA <= SP.CCL_DT_END WHERE 1 = 1 AND PT.ERROR = 'OK' ");

        if (request.getFechaDesde() != null) {
            String fecha1 = formatter.format(request.getFechaDesde());
            query.append(" AND PT.FECHA >=  CONVERT(datetime, :fechadesde , 103) ");
            param.addValue("fechadesde", fecha1);
        }
        if (request.getFechaHasta() != null) {
            String fecha2 = formatter.format(request.getFechaHasta());
            query.append(" AND PT.FECHA <= CONVERT(datetime, :fechahasta, 103) ");
            param.addValue("fechahasta", fecha2);
        }

        query.append(
                ") P INNER JOIN M4CCL_ORGANIZACION_PAIS OP WITH (NOLOCK) ON P.ID_ORGANIZATION = OP.ID_ORGANIZATION AND P.REG_NUM = 1 WHERE 1 = 1 "
                        + origen);

        if (request.getOrigen() != null) {
            query.append(" AND OP.CCL_ID_ORIGEN IN ( :origen)");
        }
        if (request.getCadena() != null) {
            query.append(" AND P.CCL_ID_CADENA IN ( ");
            if (request.getCadena().get(0) != null) {
                query.append(" :cadena0 ");
                param.addValue("cadena0", request.getCadena().get(0));
            }
            for (Integer e = 1; e < request.getCadena().size(); e++) {
                query.append(", :cadena" + e.toString() + " ");
                param.addValue("cadena" + e.toString(), request.getCadena().get(e));
            }
            query.append(")");
        }
        if (request.getTipo() != null) {
            query.append(" AND P.TIPO IN ( :tipo)");
            param.addValue("tipo", request.getTipo());
        }

        if (request.getTiendas() != null) {
            int size = request.getTiendas().size();
            if (size > 0) {
                query.append(" AND (P.TIENDA IN ( :tienda0");
                param.addValue("tienda0", request.getTiendas().get(0));

                for (Integer i = 1; i < size; i++) {
                    query.append(" ,:tienda" + i.toString() + " ");
                    param.addValue("tienda" + i.toString(), request.getTiendas().get(i));
                }
                query.append("))");
            }
        }
        query.append(origen);
        query.append(" GROUP BY OP.CCL_ID_ORIGEN,P.TIENDA,P.FECHA");
        return namedParameterJdbcTemplate.query(query.toString(), param, new PresenciaTotalTiendaMockRowMapper());
    }

    @Override
    public List<PresenciaTotalTiendaSeccionMock> findPresenciasTotalTiendaSeccion(
            PresenciasTotalTiendaSeccionRequestDto request) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        MapSqlParameterSource param = new MapSqlParameterSource();

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

        if (request.getFechaDesde() != null) {
            String fecha1 = formatter.format(request.getFechaDesde());
            query.append(" AND PT.FECHA >=   CONVERT(datetime, :fechadesde , 103) ");
            param.addValue("fechadesde", fecha1);
        }
        if (request.getFechaHasta() != null) {
            String fecha2 = formatter.format(request.getFechaHasta());
            query.append(" AND PT.FECHA <=  CONVERT(datetime, :fechahasta , 103) ");
            param.addValue("fechahasta", fecha2);
        }
        query.append(" AND PT.ERROR = 'OK') P INNER JOIN M4CCL_ORGANIZACION_PAIS OP WITH "
                + "(NOLOCK) ON P.ID_ORGANIZATION = OP.ID_ORGANIZATION AND P.REG_NUM = 1 WHERE 1 = 1 " + origen);
        if (request.getTipo() != null) {
            query.append(" AND P.TIPO = :tipo  ");
            param.addValue("tipo", request.getTipo());
        }

        if (request.getCadena() != null) {
            query.append(" AND P.CCL_ID_CADENA IN ( ");
            if (request.getCadena().get(0) != null) {
                query.append(" :cadena0 ");
                param.addValue("cadena0", request.getCadena().get(0));
            }
            for (Integer e = 1; e < request.getCadena().size(); e++) {
                query.append(", :cadena" + e.toString() + " ");
                param.addValue("cadena" + e.toString(), request.getCadena().get(e));
            }
            query.append(")");
        }

        if (request.getTiendaSeccion() != null) {
            int size = request.getTiendaSeccion().size();
            if (size > 0) {
                if (request.getTiendaSeccion().get(0).getSeccion() == null) {
                    query.append(" AND  ((P.TIENDA = :tienda0 ) ");
                    param.addValue("tienda0", request.getTiendaSeccion().get(0).getTienda());
                } else {
                    query.append(" AND  ((P.TIENDA = :tienda0 AND P.SECCION = :seccion0 ) ");
                    param.addValue("tienda0", request.getTiendaSeccion().get(0).getTienda());
                    param.addValue("seccion0", request.getTiendaSeccion().get(0).getSeccion());
                }

                for (Integer i = 1; i < size; i++) {

                    if (request.getTiendaSeccion().get(i).getSeccion() == null) {
                        query.append(" OR  (P.TIENDA = :tienda" + i.toString() + " ) ");
                        param.addValue("tienda" + i.toString(), request.getTiendaSeccion().get(i).getTienda());
                    } else {
                        query.append(" OR  (P.TIENDA = :tienda" + i.toString() + " AND P.SECCION = :seccion "
                                + i.toString() + " )");
                        param.addValue("tienda" + i.toString(), request.getTiendaSeccion().get(i).getTienda());
                        param.addValue("seccion" + i.toString(), request.getTiendaSeccion().get(i).getSeccion());
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

        }
        query.append(" GROUP BY OP.CCL_ID_ORIGEN, P.TIENDA,P.SECCION,  P.FECHA");
        return namedParameterJdbcTemplate.query(query.toString(), param,
                new PresenciaTotalTiendaSeccionMockRowMapper());
    }

    @Override
    public List<TiposHorasMock> findTiposHoras(TiposHorasRequestDto request) {
        List<TiposHorasMock> presencias;
        String consulta;
        Object[] params = { request.getOrigen() };
        if (request.getOrigen() == 11) {
            consulta = consultaTiposHorasEspana + whereTiposHorasOrigen + consultaTiposHoras2;
            presencias = jdbcTemplate.query(consulta, params, new TiposHorasMockRowMapper());
        } else {
            consulta = consultaTiposHorasGHRS + whereTiposHorasOrigen + consultaTiposHoras2;
            presencias = jdbcTemplate.query(consulta, params, new TiposHorasMockRowMapper());
        }
        return presencias;
    }

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
				new PresenciaTotalTiendaSeccionMockRowMapper());
	}

	@Override
	public List<TiposHorasMock> findTiposHoras(TiposHorasRequestDto dto) {
		List<TiposHorasMock> presencias;

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

		return namedParameterJdbcTemplate.query(query.toString(), param, new TiposHorasMockRowMapper());
	}

}