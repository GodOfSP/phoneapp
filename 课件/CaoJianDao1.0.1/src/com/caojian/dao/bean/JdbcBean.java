package com.caojian.dao.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.caojian.dao.util.XMLUtil;

/**
 * jdbc模版，用于创建连接
 * CaoJianDAO,VERSION: 1.0 
 * DATE: 2009-5-22
 * @author CAOJIAN
 */
public class JdbcBean {
	
	//私有的静态对象
	private static JdbcBean jdbcBean = null;
	//数据库驱动
	private String driverClass;
	//数据库URL
	private String dbUrl;
	//数据库用户名
	private String userName;
	//数据库密码
	private String passWord;
	
	/**
	 * 私有的构造函数
	 * 初始化数据库连接
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
	 * 静态方法，获取实例
	 * @return JdbcBean实例
	 */
	public static JdbcBean getInstance () {
		if (null == jdbcBean) {
			jdbcBean = new JdbcBean();
		}
		return jdbcBean;
	}
	
	/**
	 * 获取数据库连接
	 * @return Connection
	 */
	public synchronized Connection getConnection () {
		Connection connection = null;
		try {
			Class.forName(this.driverClass);
			connection = DriverManager.getConnection(this.dbUrl,this.userName,this.passWord);
		} catch (Exception e) {
			System.out.println("获取数据库连接出错！");
			e.printStackTrace();
			return null;
		} 
		return connection;
	}
	
	/**
	 * 关闭数据库连接
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
