package com.inditex.rrhh.icmclcwb.model.primary.dialect;

import java.sql.Types;

import org.hibernate.dialect.DB2Dialect;

/**
 * The Class DB2NativeDialect.
 */
public class DB2NativeDialect extends DB2Dialect {

    /**
     * Instantiates a new DB 2 native dialect.
     */
    public DB2NativeDialect() {
        this.registerColumnType(Types.DOUBLE, "decimal(23,8)");
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
