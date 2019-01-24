package com.inditex.rrhh.icmclcwb.model.primary.dialect;

import java.sql.Types;

import org.hibernate.dialect.DB2Dialect;

public class DB2NativeDialect extends DB2Dialect {

    public DB2NativeDialect() {
        super();
        registerColumnType(Types.DOUBLE, "decimal(23,8)");
//        registerColumnType(Types.INTEGER, "decimal($p)");
//        registerColumnType(Types.NUMERIC, "decimal($p,$s)");
//        registerColumnType(Types.DECIMAL, "decimal($p,$s)");
    }

}