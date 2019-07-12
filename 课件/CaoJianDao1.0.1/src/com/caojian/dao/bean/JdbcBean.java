package com.caojian.dao.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.caojian.dao.util.XMLUtil;

/**
 * jdbcģ�棬���ڴ�������
 * CaoJianDAO,VERSION: 1.0 
 * DATE: 2009-5-22
 * @author CAOJIAN
 */
public class JdbcBean {
	
	//˽�еľ�̬����
	private static JdbcBean jdbcBean = null;
	//���ݿ�����
	private String driverClass;
	//���ݿ�URL
	private String dbUrl;
	//���ݿ��û���
	private String userName;
	//���ݿ�����
	private String passWord;
	
	/**
	 * ˽�еĹ��캯��
	 * ��ʼ�����ݿ�����
	 */
	private JdbcBean () {
		if (null == this.driverClass || "".equals(this.driverClass)
				|| null == this.dbUrl || "".equals(this.dbUrl)
				|| null == this.userName || "".equals(this.userName)
				|| null == this.passWord || "".equals(this.passWord)) {
			DbConfigBean dsb = XMLUtil.getDbConfig();
			this.driverClass = dsb.getDriverClass();
			this.dbUrl = dsb.getDbUrl();
			this.userName = dsb.getUserName();
			this.passWord = dsb.getPassWord();
		}
	}
	
	/**
	 * ��̬��������ȡʵ��
	 * @return JdbcBeanʵ��
	 */
	public static JdbcBean getInstance () {
		if (null == jdbcBean) {
			jdbcBean = new JdbcBean();
		}
		return jdbcBean;
	}
	
	/**
	 * ��ȡ���ݿ�����
	 * @return Connection
	 */
	public synchronized Connection getConnection () {
		Connection connection = null;
		try {
			Class.forName(this.driverClass);
			connection = DriverManager.getConnection(this.dbUrl,this.userName,this.passWord);
		} catch (Exception e) {
			System.out.println("��ȡ���ݿ����ӳ���");
			e.printStackTrace();
			return null;
		} 
		return connection;
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
