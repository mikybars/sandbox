package com.inditex.rrhh.icmclcwb.model.primary.dialect;

import java.sql.Types;

import org.hibernate.dialect.DB2Dialect;

public class DB2NativeDialect extends DB2Dialect {

    public DB2NativeDialect() {
        registerColumnType(Types.DOUBLE, "decimal(23,8)");
    }

}
