package com.caojian.dao.bean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.caojian.dao.util.XMLUtil;

/**
 * DBCP工具类(数据库连接池)，用于获取连接和关闭连接池
 * CaoJianDAO,VERSION: 1.0 
 * DATE: 2009-5-22
 * @author CAOJIAN
 */
public class DbcpBean {
	 // 私有的静态实例
	private static DbcpBean dbcpBean = null;
	 // 私有的成员变量DataSource
	private static DataSource ds;
	/**
	 * 私有的构造函数，初始化DataSource
	 */
	private DbcpBean () {
		DbConfigBean dsb = XMLUtil.getDbConfig();
		this.initDS(dsb.getDriverClass(), dsb.getDbUrl(), dsb.getUserName(), dsb.getPassWord(), 
				Integer.parseInt(dsb.getInitialSize()), Integer.parseInt(dsb.getMaxActive()), 
				Integer.parseInt(dsb.getMaxIdle()),Integer.parseInt(dsb.getMinIdle()), Long.parseLong(dsb.getMaxWait()),dsb.isRemoveAbandoned(),
				Integer.parseInt(dsb.getRemoveAbandonedTimeout()),dsb.isLogAbandonedNode());
	}
	/**
	 * 初始化连接池
	 * @param driverClass 数据库驱动类
	 * @param dbUrl 数据库URL
	 * @param userName 用户名
	 * @param passWord 密码
	 * @param initialSize 初始化连接数
	 * @param maxActive 最大活跃连接数
	 * @param maxIdle 最大闲置连接数
	 * @param maxWait 得到连接最大等待毫秒数
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
     * 单例模式获取该类实例
     * @return DbcpBean实例
     */
	public static synchronized DbcpBean getInstance () {
		if (null == dbcpBean) {
			dbcpBean = new DbcpBean();
		}
		return dbcpBean;
	}
	/**
	 * 从连接池中获取连接
	 * @return Connection
	 */
	public synchronized Connection getConnection () {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			System.out.println("获取数据库连接出错！");
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 获取数据源DataSource
	 * @return DataSource
	 */
	public DataSource getDataSource () {
		return ds;
	}
	/**
	 * 获得数据源连接状态
	 * @return Map封装的状态信息
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
	 * 关闭连接池
	 * @throws SQLException
	 */
	public synchronized void closeDataSource () throws SQLException {
		BasicDataSource bds = (BasicDataSource)ds;
		bds.close();
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
