package io.renren.modules.spider.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ArrayStringTypeHandler extends BaseTypeHandler<List<String>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, String.join(",", parameter));
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String str = parseString(rs.getString(columnName));
        if (rs.wasNull())
            return null;
        return Arrays.asList(str.split(","));
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String str = parseString(rs.getString(columnIndex));
        if (rs.wasNull())
            return null;
        return Arrays.asList(str.split(","));
    }

    @Override
    public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String str = parseString(cs.getString(columnIndex));
        if (cs.wasNull())
            return null;
        return Arrays.asList(str.split(","));
    }

    private String parseString(String str) {
        String replace = str.replace("，", ",");
        StringBuilder stringBuilder = new StringBuilder(replace);
        if ("\"".equals(stringBuilder.charAt(0))) {
            stringBuilder.deleteCharAt(0);
        }
        if ("\"".equals(stringBuilder.charAt(stringBuilder.length() - 1))) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return new String(stringBuilder);
    }
}
