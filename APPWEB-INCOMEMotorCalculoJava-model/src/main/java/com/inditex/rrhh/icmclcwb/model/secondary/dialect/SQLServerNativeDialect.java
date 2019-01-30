package com.inditex.rrhh.icmclcwb.model.secondary.dialect;

import java.sql.Types;

import org.hibernate.dialect.SQLServerDialect;

/**
 * The Class SQLServerNativeDialect.
 */
public class SQLServerNativeDialect extends SQLServerDialect {

    /**
     * Instantiates a new SQL server native dialect.
     */
    public SQLServerNativeDialect() {
        super();
        this.registerColumnType(Types.VARCHAR, "nvarchar($l)");
        this.registerColumnType(Types.CLOB, "ntext");
    }

    /**
     * Register column type.
     *
     * @param code the code
     * @param name the name
     */
    @Override
    public final void registerColumnType(int code, String name) {
        super.registerColumnType(code, name);
    }

}
