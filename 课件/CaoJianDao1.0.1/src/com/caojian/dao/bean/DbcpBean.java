package com.caojian.dao.bean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.caojian.dao.util.XMLUtil;

/**
 * DBCP������(���ݿ����ӳ�)�����ڻ�ȡ���Ӻ͹ر����ӳ�
 * CaoJianDAO,VERSION: 1.0 
 * DATE: 2009-5-22
 * @author CAOJIAN
 */
public class DbcpBean {
	 // ˽�еľ�̬ʵ��
	private static DbcpBean dbcpBean = null;
	 // ˽�еĳ�Ա����DataSource
	private static DataSource ds;
	/**
	 * ˽�еĹ��캯������ʼ��DataSource
	 */
	private DbcpBean () {
		DbConfigBean dsb = XMLUtil.getDbConfig();
		this.initDS(dsb.getDriverClass(), dsb.getDbUrl(), dsb.getUserName(), dsb.getPassWord(), 
				Integer.parseInt(dsb.getInitialSize()), Integer.parseInt(dsb.getMaxActive()), 
				Integer.parseInt(dsb.getMaxIdle()),Integer.parseInt(dsb.getMinIdle()), Long.parseLong(dsb.getMaxWait()),dsb.isRemoveAbandoned(),
				Integer.parseInt(dsb.getRemoveAbandonedTimeout()),dsb.isLogAbandonedNode());
	}
	/**
	 * ��ʼ�����ӳ�
	 * @param driverClass ���ݿ�������
	 * @param dbUrl ���ݿ�URL
	 * @param userName �û���
	 * @param passWord ����
	 * @param initialSize ��ʼ��������
	 * @param maxActive ����Ծ������
	 * @param maxIdle �������������
	 * @param maxWait �õ��������ȴ�������
	 */
	@SuppressWarnings("deprecation")
	private void initDS(String driverClass, String dbUrl, String userName, String passWord, int initialSize,   
            int maxActive, int maxIdle,int minIdle, long maxWait,boolean removeAbandoned,
            int removeAbandonedTimeOut,boolean logAbandonedNode) {  
        BasicDataSource bds = new BasicDataSource();   
        bds.setDriverClassName(driverClass);
        bds.setUrl(dbUrl);
        bds.setUsername(userName);
        bds.setPassword(passWord);
        bds.setInitialSize(initialSize);
        bds.setMaxActive(maxActive);
        bds.setMaxIdle(maxIdle);
        bds.setMinIdle(minIdle);
        bds.setMaxWait(maxWait);
        bds.setRemoveAbandoned(removeAbandoned);
        bds.setRemoveAbandonedTimeout(removeAbandonedTimeOut);
        bds.setLogAbandoned(logAbandonedNode);
        ds = bds;
    }   
    /**
     * ����ģʽ��ȡ����ʵ��
     * @return DbcpBeanʵ��
     */
	public static synchronized DbcpBean getInstance () {
		if (null == dbcpBean) {
			dbcpBean = new DbcpBean();
		}
		return dbcpBean;
	}
	/**
	 * �����ӳ��л�ȡ����
	 * @return Connection
	 */
	public synchronized Connection getConnection () {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			System.out.println("��ȡ���ݿ����ӳ���");
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * ��ȡ����ԴDataSource
	 * @return DataSource
	 */
	public DataSource getDataSource () {
		return ds;
	}
	/**
	 * �������Դ����״̬
	 * @return Map��װ��״̬��Ϣ
	 * @throws SQLException
	 */ 
	 public Map<String, Integer> getDataSourceStats() throws SQLException {   
	     BasicDataSource bds = (BasicDataSource) ds;   
	     Map<String, Integer> map = new HashMap<String, Integer>(2);   
	     map.put("active_number", bds.getNumActive());   
	     map.put("idle_number", bds.getNumIdle());   
	     return map;   
	 }   
	/**
	 * �ر����ӳ�
	 * @throws SQLException
	 */
	public synchronized void closeDataSource () throws SQLException {
		BasicDataSource bds = (BasicDataSource)ds;
		bds.close();
	}
	/**
	 * �ر����ݿ�����
	 * @param connection
	 * @throws SQLException
	 */
	public static synchronized void closeConnection (Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}

}
