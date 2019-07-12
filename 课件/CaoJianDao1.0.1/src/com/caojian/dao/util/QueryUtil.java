package com.caojian.dao.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询数据方法辅助类 根据数据库类型映射成对应的java类型 存入Map
 * CaoJianDAO,VERSION: 1.0 
 * DATE: 2009-5-22
 * @author CAOJIAN
 */

public class QueryUtil {
	/**
	 * 返回查询结果信息，以List<Map>形式封装数据
	 * @return List<Map> 里面封装了查询的数据库内容
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String,Object>> getResultList(ResultSet rs) throws SQLException {
		List<Map<String,Object>> lt = new ArrayList<Map<String,Object>>();
		int columnCount = 0;
		if (rs != null) {
			ResultSetMetaData rsmd = rs.getMetaData();
			columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				Map<String,Object> map = new HashMap<String,Object>();
				for (int i = 1; i <= columnCount; i++) {
					String columnName = rsmd.getColumnName(i);
					int columnType = rsmd.getColumnType(i);
					/* 根据数据库类型，映射对应java类型存入Map */
					if (columnType == Types.INTEGER
							|| columnType == Types.BIGINT
							|| columnType == Types.SMALLINT
							|| columnType == Types.NUMERIC) {
						map.put(columnName.toUpperCase(), rs.getInt(columnName));
					} else if (columnType == Types.VARCHAR
							|| columnType == Types.NVARCHAR
							|| columnType == Types.CHAR) {
						map.put(columnName.toUpperCase(), rs.getString(columnName));
					} else if (columnType == Types.FLOAT
							|| columnType == Types.DOUBLE) {
						map.put(columnName.toUpperCase(), rs.getDouble(columnName));
					} else if (columnType == Types.DATE
							|| columnType == Types.TIMESTAMP
							|| columnType == Types.TIME) {
						map.put(columnName.toUpperCase(), rs.getDate(columnName));
					} else {
						map.put(columnName.toUpperCase(), rs.getString(columnName));
					}
				}
				lt.add(map);
			}
		}
		return lt;
	}
}
