package com.inditex.rrhh.icmclcwb.model.secondary.dialect;

import java.sql.Types;

import org.hibernate.dialect.SQLServerDialect;

public class SQLServerNativeDialect extends SQLServerDialect {

    public SQLServerNativeDialect() {
        super();
        this.registerColumnType(Types.VARCHAR, "nvarchar($l)");
        this.registerColumnType(Types.CLOB, "ntext");
    }

    @Override
    public final void registerColumnType(int code, String name) {
        super.registerColumnType(code, name);
    }

}
