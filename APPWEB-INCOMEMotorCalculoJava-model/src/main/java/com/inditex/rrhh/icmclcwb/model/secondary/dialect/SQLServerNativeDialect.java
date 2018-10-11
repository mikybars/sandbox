package com.inditex.rrhh.icmclcwb.model.secondary.dialect;

import java.sql.Types;

import org.hibernate.dialect.SQLServerDialect;

public class SQLServerNativeDialect extends SQLServerDialect {

	public SQLServerNativeDialect() {
		super();
//		registerColumnType(Types.CHAR, "nchar(1)");
	    registerColumnType(Types.VARCHAR, "nvarchar($l)");
//	    registerColumnType(Types.LONGVARCHAR, "nvarchar($l)");
	    registerColumnType(Types.CLOB, "ntext");
	}

//	public String getTypeName(int code, int length, int precision, int scale) throws HibernateException {
//		if (code != 2005) {
//			return super.getTypeName(code, length, precision, scale);
//		} else {
//			return "ntext";
//		}
//	}

}