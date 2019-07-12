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
 * ����DAO�㣬���ڶ����ݿ�Ĳ���
 * ����ɾ���ģ���
 * CaoJianDAO,VERSION: 1.0 
 * DATE: 2009-5-22
 * @author CAOJIAN
 */
public class BaseDaoImpl implements BaseDao {
	//���ݿ���������
	private String connectionType;
	// ���ݿ�������
	private String driverClass;
	 // �Ƿ��ӡsql���
	private boolean showSql;
	 // ��ҳ��ѯ��ÿҳ��ʾ������,Ĭ��Ϊ10
	private int rowsNum = 10;
	
	/**
	 * Ĭ�Ϲ��캯��
	 * ��ʼ�����ݿ��������ͣ����ݿ�������Ϣ���Լ��Ƿ��ӡsql����Ϣ
	 */
	public BaseDaoImpl () {
		DbConfigBean dsb = XMLUtil.getDbConfig();
		this.connectionType = dsb.getConnectionType();
		this.driverClass = dsb.getDriverClass();
		this.showSql = dsb.isShowSql();
	}
	
	/**
	 * ��ѯ���ݣ�����List��װ�Ľ������ÿ����¼��Map��װ
	 * @param sql sql���
	 * @param param sql�����������û������null
	 * @return List��װ�Ľ����
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
	 * ��ѯ���ݣ�����Integer���
	 * @param sql sql���
	 * @param param sql�����������û������null
	 * @return Integer���
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
	 * ��ѯ���ݣ�����long���
	 * @param sql sql���
	 * @param param sql�����������û������null
	 * @return long���
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
	 * ��ѯ���ݣ�����double���
	 * @param sql sql���
	 * @param param sql�����������û������null
	 * @return double���
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
	 * ��ѯ���ݣ�����float���
	 * @param sql sql���
	 * @param param sql�����������û������null
	 * @return float���
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
	 * ��ѯ���ݣ������ַ������
	 * @param sql sql���
	 * @param param sql�����������û������null
	 * @return String���
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
	 * ��ѯ���ݣ�����Object���
	 * @param sql sql���
	 * @param param sql�����������û������null
	 * @return Object���
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
	 * ��ȡÿҳ��ʾ����
	 * @return ÿҳ��ʾ����
	 */
	public int getRowsNum() {
		return this.rowsNum;
	}
	
	/**
	 * ����ÿҳ��ʾ����
	 * @param rowsNum ÿҳ��ʾ����
	 */
	public void setRowsNum(int rowsNum) {
		this.rowsNum = rowsNum;
	}
	
	/**
	 * ��ȡ��ҳҳ��
	 * @param rowsCount ��¼����
	 * @return ��ҳҳ��
	 */
	public int getPageCount(int rowsCount) {
		// �㷨�� ����������+(ÿҳ��ʾ����-1)/ÿҳ��ʾ����
		return (rowsCount + (this.rowsNum - 1)) / this.rowsNum;
	}
	
	/**
	 * ��ҳ��ѯ����
	 * @param sql sql��䣬���ʹ��Oracle���ݿ⣬sql����У�����ʹ�ñ���
	 * @param param sql�����������û������null
	 * @param pageNo ����ҳ��
	 * @return List��װ�Ľ����
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryForPage(String sql, Object[] param,int pageNo) throws Exception {
		//���ݲ�ͬ�����ݿ����ͣ����ò�ͬ�ķ�ҳ��ѯ����
		if ("com.mysql.jdbc.Driver".equals(this.driverClass)) {
			return this.MySqlPageQuery(sql,param,pageNo);
		} else if ("oracle.jdbc.driver.OracleDriver".equals(this.driverClass)) {
			return this.oraclePageQuery(sql,param,pageNo);
		} else {
			throw new RuntimeException ("Ŀǰ�����ܶԵ�ǰ���ݿ���з�ҳ��ѯ��");
		}
	}
	
	/**
	 * oracle��ҳ��ѯ
	 * @param sql sql���sql��ʹ�ñ���
	 * @param param sql��������û�пɴ���null
	 * @param pageNo ����ҳ��
	 * @return List��װ�Ľ����
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
	 * MySql��ҳ��ѯ
	 * @param sql sql���
	 * @param param sql��������û�пɴ���null
	 * @param pageNo ����ҳ��
	 * @return List��װ�Ľ����
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
	 * ִ�и��»�ɾ������������ɾ���ģ�
	 * @param sql sql���
	 * @param param sql�����������û������null
	 * @return ��Ӱ�������
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
	 * ִ����������
	 * @param sqls sql�������
	 * @return ��Ӱ�������
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
	 * �������þ���ʹ���������ӣ����������ݿ�����
	 * Ĭ�������ʹ��JDBC����
	 * @return Connection
	 * @throws Exception
	 */
	private Connection getConnection () throws Exception {
		Connection connection = null;
		if ("dbcp".equalsIgnoreCase(this.connectionType)) {
			//ʹ�����ݿ����ӳ�
			connection = DbcpBean.getInstance().getConnection();
		} else {
			//ʹ��JDBC
			connection = JdbcBean.getInstance().getConnection();
		} 
		return connection;
	}
	
	/**
	 * �ر����ݿ�����Connection
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
	 * �ر�Statement����
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
	 * �ر�ResultSet����
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
	 * �������ã���ӡsql���
	 * @param sql sql���
	 * @param param sql������
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
	 * ��Map��ȡ��java.util.Date
	 * @param map
	 * @param key
	 * @return java.util.Date
	 */
	@SuppressWarnings("unchecked")
	public Date getDateFromMap(Map map, String key) throws Exception {
		return (Date)map.get(key.toUpperCase());
	}

	/**
	 * ��Map��ȡ��double
	 * @param map
	 * @param key
	 * @return double
	 */
	@SuppressWarnings("unchecked")
	public double getDoubleFromMap(Map map, String key) throws Exception {
		return Double.parseDouble(getStringFromMap(map,key.toUpperCase()));
	}

	/**
	 * ��Map��ȡ��float
	 * @param map
	 * @param key
	 * @return float
	 */
	@SuppressWarnings("unchecked")
	public float getFloatFromMap(Map map, String key) throws Exception {
		return Float.parseFloat(getStringFromMap(map,key.toUpperCase()));
	}

	/**
	 * ��Map��ȡ��int
	 * @param map
	 * @param key
	 * @return int
	 */
	@SuppressWarnings("unchecked")
	public int getIntegerFromMap(Map map, String key) throws Exception {
		return Integer.parseInt(getStringFromMap(map,key.toUpperCase()));
	}

	/**
	 * ��Map��ȡ��long
	 * @param map
	 * @param key
	 * @return long
	 */
	@SuppressWarnings("unchecked")
	public long getLongFromMap(Map map, String key) throws Exception {
		return Long.parseLong(getStringFromMap(map,key.toUpperCase()));
	}

	/**
	 * ��Map��ȡ��Object
	 * @param map
	 * @param key
	 * @return Object
	 */
	@SuppressWarnings("unchecked")
	public Object getObjectFromMap(Map map, String key) throws Exception {
		return map.get(key.toUpperCase());
	}

	/**
	 * ��Map��ȡ��String
	 * @param map
	 * @param key
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	public String getStringFromMap(Map map, String key) throws Exception {
		return String.valueOf(map.get(key.toUpperCase()));
	}

	/**
	 * ��ȡ���ݿ���������
	 * @return ��ǰʹ�õ����ݿ���������
	 */
	public String getConnectionType() {
		return connectionType;
	}

	/**
	 * �������ݿ���������
	 * @param connectionType
	 */
	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

	/**
	 * �Ƿ��ӡsql
	 * @return �Ƿ��ӡsql
	 */
	public boolean isShowSql() {
		return showSql;
	}

	/**
	 * �����Ƿ��ӡsql
	 * @param showSql
	 */
	public void setShowSql(boolean showSql) {
		this.showSql = showSql;
	}

	/**
	 * ��ȡ���ݿ���������
	 * @return ���ݿ���������
	 */
	public String getDriverClass() {
		return driverClass;
	}

}
