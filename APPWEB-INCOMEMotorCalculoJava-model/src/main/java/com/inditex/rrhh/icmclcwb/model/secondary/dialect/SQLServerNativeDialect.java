package com.inditex.rrhh.icmclcwb.model.secondary.dialect;

import java.sql.Types;

import org.hibernate.dialect.SQLServerDialect;

public class SQLServerNativeDialect extends SQLServerDialect {

    public SQLServerNativeDialect() {
        registerColumnType(Types.VARCHAR, "nvarchar($l)");
        registerColumnType(Types.CLOB, "ntext");
    }

}
