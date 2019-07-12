package com.caojian.dao.basedao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.caojian.dao.basedao.BaseDao;
import com.caojian.dao.bean.DbConfigBean;
import com.caojian.dao.bean.DbcpBean;
import com.caojian.dao.bean.JdbcBean;
import com.caojian.dao.util.QueryUtil;
import com.caojian.dao.util.XMLUtil;

/**
 * 基础DAO层，用于对数据库的操作
 * 增，删，改，查
 * CaoJianDAO,VERSION: 1.0 
 * DATE: 2009-5-22
 * @author CAOJIAN
 */
public class BaseDaoImpl implements BaseDao {
	//数据库连接类型
	private String connectionType;
	// 数据库驱动类
	private String driverClass;
	 // 是否打印sql语句
	private boolean showSql;
	 // 分页查询，每页显示的条数,默认为10
	private int rowsNum = 10;
	
	/**
	 * 默认构造函数
	 * 初始化数据库连接类型，数据库驱动信息，以及是否打印sql等信息
	 */
	public BaseDaoImpl () {
		DbConfigBean dsb = XMLUtil.getDbConfig();
		this.connectionType = dsb.getConnectionType();
		this.driverClass = dsb.getDriverClass();
		this.showSql = dsb.isShowSql();
	}
	
	/**
	 * 查询数据，返回List封装的结果集，每条记录以Map封装
	 * @param sql sql语句
	 * @param param sql语句参数，如果没有则传入null
	 * @return List封装的结果集
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryForList(String sql, Object[] param) throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Map<String, Object>> result = null;
		try {
			connection = getConnection ();
			pst = connection.prepareStatement(sql);
			if (null != param && param.length > 0) {
				for (int i = 0;i<param.length;i++) {
					pst.setObject(i+1, param[i]);
				}
			}
			rs = pst.executeQuery();
			result = QueryUtil.getResultList(rs);
			this.printSql(sql, param);
		} catch (Exception e) {
			throw new RuntimeException (e);
		} finally {
			this.closeResultSet(rs);
			this.closeStatement(pst);
			this.closeConnection(connection);
		}
		return result;
	}

	/**
	 * 查询数据，返回Integer结果
	 * @param sql sql语句
	 * @param param sql语句参数，如果没有则传入null
	 * @return Integer结果
	 * @throws Exception
	 */
	public int queryForInteger(String sql, Object[] param) throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int result = 0;
		try {
			connection = getConnection ();
			pst = connection.prepareStatement(sql);
			if (null != param && param.length > 0) {
				for (int i = 0;i<param.length;i++) {
					pst.setObject(i+1, param[i]);
				}
			}
			rs = pst.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
			this.printSql(sql, param);
		} catch (Exception e) {
			throw new RuntimeException (e);
		} finally {
			this.closeResultSet(rs);
			this.closeStatement(pst);
			this.closeConnection(connection);
		}
		return result;
	}
	
	/**
	 * 查询数据，返回long结果
	 * @param sql sql语句
	 * @param param sql语句参数，如果没有则传入null
	 * @return long结果
	 * @throws Exception
	 */
	public long queryForLong(String sql, Object[] param) throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		long result = 0L;
		try {
			connection = getConnection ();
			pst = connection.prepareStatement(sql);
			if (null != param && param.length > 0) {
				for (int i = 0;i<param.length;i++) {
					pst.setObject(i+1, param[i]);
				}
			}
			rs = pst.executeQuery();
			if (rs.next()) {
				result = rs.getLong(1);
			}
			this.printSql(sql, param);
		} catch (Exception e) {
			throw new RuntimeException (e);
		} finally {
			this.closeResultSet(rs);
			this.closeStatement(pst);
			this.closeConnection(connection);
		}
		return result;
	}
	
	/**
	 * 查询数据，返回double结果
	 * @param sql sql语句
	 * @param param sql语句参数，如果没有则传入null
	 * @return double结果
	 * @throws Exception
	 */
	public double queryForDouble(String sql, Object[] param) throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		double result = 0D;
		try {
			connection = getConnection ();
			pst = connection.prepareStatement(sql);
			if (null != param && param.length > 0) {
				for (int i = 0;i<param.length;i++) {
					pst.setObject(i+1, param[i]);
				}
			}
			rs = pst.executeQuery();
			if (rs.next()) {
				result = rs.getDouble(1);
			}
			this.printSql(sql, param);
		} catch (Exception e) {
			throw new RuntimeException (e);
		} finally {
			this.closeResultSet(rs);
			this.closeStatement(pst);
			this.closeConnection(connection);
		}
		return result;
	}
	
	/**
	 * 查询数据，返回float结果
	 * @param sql sql语句
	 * @param param sql语句参数，如果没有则传入null
	 * @return float结果
	 * @throws Exception
	 */
	public float queryForFloat(String sql, Object[] param) throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		float result = 0F;
		try {
			connection = getConnection ();
			pst = connection.prepareStatement(sql);
			if (null != param && param.length > 0) {
				for (int i = 0;i<param.length;i++) {
					pst.setObject(i+1, param[i]);
				}
			}
			rs = pst.executeQuery();
			if (rs.next()) {
				result = rs.getFloat(1);
			}
			this.printSql(sql, param);
		} catch (Exception e) {
			throw new RuntimeException (e);
		} finally {
			this.closeResultSet(rs);
			this.closeStatement(pst);
			this.closeConnection(connection);
		}
		return result;
	}
	
	/**
	 * 查询数据，返回字符串结果
	 * @param sql sql语句
	 * @param param sql语句参数，如果没有则传入null
	 * @return String结果
	 * @throws Exception
	 */
	public String queryForString(String sql, Object[] param) throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String result = "";
		try {
			connection = getConnection ();
			pst = connection.prepareStatement(sql);
			if (null != param && param.length > 0) {
				for (int i = 0;i<param.length;i++) {
					pst.setObject(i+1, param[i]);
				}
			}
			rs = pst.executeQuery();
			if (rs.next()) {
				result = rs.getString(1);
			}
			this.printSql(sql, param);
		} catch (Exception e) {
			throw new RuntimeException (e);
		} finally {
			this.closeResultSet(rs);
			this.closeStatement(pst);
			this.closeConnection(connection);
		}
		return result;
	}
	
	/**
	 * 查询数据，返回Object结果
	 * @param sql sql语句
	 * @param param sql语句参数，如果没有则传入null
	 * @return Object结果
	 * @throws Exception
	 */
	public Object queryForObject(String sql, Object[] param) throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Object result = null;
		try {
			connection = getConnection ();
			pst = connection.prepareStatement(sql);
			if (null != param && param.length > 0) {
				for (int i = 0;i<param.length;i++) {
					pst.setObject(i+1, param[i]);
				}
			}
			rs = pst.executeQuery();
			if (rs.next()) {
				result = rs.getObject(1);
			}
			this.printSql(sql, param);
		} catch (Exception e) {
			throw new RuntimeException (e);
		} finally {
			this.closeResultSet(rs);
			this.closeStatement(pst);
			this.closeConnection(connection);
		}
		return result;
	}
	
	/**
	 * 获取每页显示条数
	 * @return 每页显示条数
	 */
	public int getRowsNum() {
		return this.rowsNum;
	}
	
	/**
	 * 设置每页显示条数
	 * @param rowsNum 每页显示条数
	 */
	public void setRowsNum(int rowsNum) {
		this.rowsNum = rowsNum;
	}
	
	/**
	 * 获取分页页数
	 * @param rowsCount 记录条数
	 * @return 分页页数
	 */
	public int getPageCount(int rowsCount) {
		// 算法： 数据总条数+(每页显示条数-1)/每页显示条数
		return (rowsCount + (this.rowsNum - 1)) / this.rowsNum;
	}
	
	/**
	 * 分页查询数据
	 * @param sql sql语句，如果使用Oracle数据库，sql语句中，表请使用别名
	 * @param param sql语句参数，如果没有则传入null
	 * @param pageNo 请求页码
	 * @return List封装的结果集
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryForPage(String sql, Object[] param,int pageNo) throws Exception {
		//根据不同的数据库类型，调用不同的分页查询方法
		if ("com.mysql.jdbc.Driver".equals(this.driverClass)) {
			return this.MySqlPageQuery(sql,param,pageNo);
		} else if ("oracle.jdbc.driver.OracleDriver".equals(this.driverClass)) {
			return this.oraclePageQuery(sql,param,pageNo);
		} else {
			throw new RuntimeException ("目前还不能对当前数据库进行分页查询！");
		}
	}
	
	/**
	 * oracle分页查询
	 * @param sql sql语句sql请使用别名
	 * @param param sql语句参数，没有可传入null
	 * @param pageNo 请求页码
	 * @return List封装的结果集
	 */
	private List<Map<String, Object>> oraclePageQuery(String sql, Object[] param,
			int pageNo) throws Exception {
		/*
		sql = "SELECT query_result.* FROM "+"(SELECT rownum row_num,"+(sql.trim().substring(6))+") " +
			  "query_result WHERE query_result.row_num between "+(((pageNo - 1) * this.rowsNum) + 1)+" " +
			  "and "+(pageNo * this.rowsNum);
			  */
		StringBuilder sqlSb = new StringBuilder("SELECT query_result.* FROM (SELECT rownum row_num,");
		sqlSb.append(sql.trim().substring(6)).append(") query_result WHERE query_result.row_num between ")
			 .append((((pageNo - 1) * this.rowsNum) + 1)).append(" and ").append((pageNo * this.rowsNum));
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Map<String, Object>> result = null;
		try {
			connection = getConnection ();
			pst = connection.prepareStatement(sqlSb.toString());
			if (null != param && param.length > 0) {
				for (int i = 0;i<param.length;i++) {
					pst.setObject(i+1, param[i]);
				}
			}
			rs = pst.executeQuery();
			result = QueryUtil.getResultList(rs);
			this.printSql(sqlSb.toString(), param);
		} catch (Exception e) {
			throw new RuntimeException (e);
		} finally {
			this.closeResultSet(rs);
			this.closeStatement(pst);
			this.closeConnection(connection);
		}
		return result;
	}
	/**
	 * MySql分页查询
	 * @param sql sql语句
	 * @param param sql语句参数，没有可传入null
	 * @param pageNo 请求页码
	 * @return List封装的结果集
	 */
	private List<Map<String, Object>> MySqlPageQuery(String sql, Object[] param,
			int pageNo) throws Exception {
		//sql = sql + " limit "+((pageNo-1)*this.rowsNum)+","+this.rowsNum;
		StringBuilder sqlSb = new StringBuilder(sql);
		sqlSb.append(" limit ").append(((pageNo-1)*this.rowsNum)).append(",").append(this.rowsNum);
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Map<String, Object>> result = null;
		try {
			connection = getConnection ();
			pst = connection.prepareStatement(sqlSb.toString());
			if (null != param && param.length > 0) {
				for (int i = 0;i<param.length;i++) {
					pst.setObject(i+1, param[i]);
				}
			}
			rs = pst.executeQuery();
			result = QueryUtil.getResultList(rs);
			this.printSql(sqlSb.toString(), param);
		} catch (Exception e) {
			throw new RuntimeException (e);
		} finally {
			this.closeResultSet(rs);
			this.closeStatement(pst);
			this.closeConnection(connection);
		}
		return result;
	}
	
	/**
	 * 执行更新或删除操作（增，删，改）
	 * @param sql sql语句
	 * @param param sql语句参数，如果没有则传入null
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public synchronized int executeUpdate(String sql, Object[] param) throws Exception {
		int result = 0;
		PreparedStatement pst = null;
		Connection connection = null;
		try {
			connection = getConnection ();
			connection.setAutoCommit(false);
			pst = connection.prepareStatement(sql);
			if (null != param && param.length > 0) {
				for (int i = 0;i<param.length;i++) {
					pst.setObject(i+1, param[i]);
				}
			}
			result = pst.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
			this.printSql(sql, param);
		} catch (Exception e) {
			connection.rollback();
			throw new RuntimeException (e);
		} finally {
			this.closeStatement(pst);
			this.closeConnection(connection);
		}
		return result;
	}
	
	/**
	 * 执行批量更新
	 * @param sqls sql语句数组
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public synchronized int executeBath(String[] sqls) throws Exception {
		Connection connection = null;
		Statement st = null;
		int result = 0;
		try {
			connection = getConnection ();
			connection.setAutoCommit(false);
			st = connection.createStatement();
			for (String sql : sqls) {
				st.addBatch(sql);
			}
			int[] temp = st.executeBatch();
			for (int i : temp) {
				if (i > 0) {
					result += i;
				}
			}
			connection.commit();
			connection.setAutoCommit(true);
			if (this.showSql) {
				for (String sql : sqls) {
					System.out.println("SQL: " + sql);
				}
			}
		} catch (Exception e) {
			connection.rollback();
			throw new RuntimeException (e);
		} finally {
			this.closeStatement(st);
			this.closeConnection(connection);
		}
		return result;
	}
	
	/**
	 * 根据配置决定使用哪种连接，并返回数据库连接
	 * 默认情况下使用JDBC连接
	 * @return Connection
	 * @throws Exception
	 */
	private Connection getConnection () throws Exception {
		Connection connection = null;
		if ("dbcp".equalsIgnoreCase(this.connectionType)) {
			//使用数据库连接池
			connection = DbcpBean.getInstance().getConnection();
		} else {
			//使用JDBC
			connection = JdbcBean.getInstance().getConnection();
		} 
		return connection;
	}
	
	/**
	 * 关闭数据库连接Connection
	 * @param connection
	 * @throws Exception
	 */
	private void closeConnection (Connection connection) throws Exception {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}
	
	/**
	 * 关闭Statement对象
	 * @param st
	 * @throws Exception
	 */
	private void closeStatement (Statement st) throws Exception {
		if (st != null) {
			st.close();
			st = null;
		}
	}
	/**
	 * 关闭ResultSet对象
	 * @param rs
	 * @throws Exception
	 */
	private void closeResultSet (ResultSet rs) throws Exception {
		if (rs != null) {
			rs.close();
			rs = null;
		}
	}
	
	/**
	 * 根据配置，打印sql语句
	 * @param sql sql语句
	 * @param param sql语句参数
	 */
	private void printSql (String sql, Object[] param) {
		if (this.showSql) {
			StringBuilder sqlInfo = new StringBuilder("SQL: " + sql);
			if (null != param && param.length > 0) {
				sqlInfo.append("   param:{");
				for (int i = 0;i<param.length;i++) {
					if (i == (param.length - 1)) {
						sqlInfo.append(param[i] + "}");
					}  else {
						sqlInfo.append(param[i] + " , ");
					}
				}
			}
			System.out.println(sqlInfo);
		}
	}

	/**
	 * 从Map中取出java.util.Date
	 * @param map
	 * @param key
	 * @return java.util.Date
	 */
	@SuppressWarnings("unchecked")
	public Date getDateFromMap(Map map, String key) throws Exception {
		return (Date)map.get(key.toUpperCase());
	}

	/**
	 * 从Map中取出double
	 * @param map
	 * @param key
	 * @return double
	 */
	@SuppressWarnings("unchecked")
	public double getDoubleFromMap(Map map, String key) throws Exception {
		return Double.parseDouble(getStringFromMap(map,key.toUpperCase()));
	}

	/**
	 * 从Map中取出float
	 * @param map
	 * @param key
	 * @return float
	 */
	@SuppressWarnings("unchecked")
	public float getFloatFromMap(Map map, String key) throws Exception {
		return Float.parseFloat(getStringFromMap(map,key.toUpperCase()));
	}

	/**
	 * 从Map中取出int
	 * @param map
	 * @param key
	 * @return int
	 */
	@SuppressWarnings("unchecked")
	public int getIntegerFromMap(Map map, String key) throws Exception {
		return Integer.parseInt(getStringFromMap(map,key.toUpperCase()));
	}

	/**
	 * 从Map中取出long
	 * @param map
	 * @param key
	 * @return long
	 */
	@SuppressWarnings("unchecked")
	public long getLongFromMap(Map map, String key) throws Exception {
		return Long.parseLong(getStringFromMap(map,key.toUpperCase()));
	}

	/**
	 * 从Map中取出Object
	 * @param map
	 * @param key
	 * @return Object
	 */
	@SuppressWarnings("unchecked")
	public Object getObjectFromMap(Map map, String key) throws Exception {
		return map.get(key.toUpperCase());
	}

	/**
	 * 从Map中取出String
	 * @param map
	 * @param key
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	public String getStringFromMap(Map map, String key) throws Exception {
		return String.valueOf(map.get(key.toUpperCase()));
	}

	/**
	 * 获取数据库连接类型
	 * @return 当前使用的数据库连接类型
	 */
	public String getConnectionType() {
		return connectionType;
	}

	/**
	 * 设置数据库连接类型
	 * @param connectionType
	 */
	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

	/**
	 * 是否打印sql
	 * @return 是否打印sql
	 */
	public boolean isShowSql() {
		return showSql;
	}

	/**
	 * 设置是否打印sql
	 * @param showSql
	 */
	public void setShowSql(boolean showSql) {
		this.showSql = showSql;
	}

	/**
	 * 获取数据库驱动类型
	 * @return 数据库驱动类型
	 */
	public String getDriverClass() {
		return driverClass;
	}

}
