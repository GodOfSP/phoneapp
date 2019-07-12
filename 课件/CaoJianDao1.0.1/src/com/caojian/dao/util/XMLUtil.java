package com.caojian.dao.util;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.caojian.dao.bean.DbConfigBean;

/**
 * 获取XML配置信息工具类 
 * 提供静态方法得到数据库连接信息和连接池配置信息
 * CaoJianDAO,VERSION: 1.0 
 * DATE: 2009-5-22
 * @author CAOJIAN
 */
public class XMLUtil {
	/**
	 * 读取数据源配置信息
	 * @return 数据源配置信息(db-config.xml)
	 */
	public static DbConfigBean getDbConfig() {
		DbConfigBean dsb = new DbConfigBean();
		SAXReader reader = new SAXReader();
		try {
			// 开始读取配置文件信息
			Document document = reader.read(Thread.currentThread()
					.getContextClassLoader().getResourceAsStream("db-config.xml"));
			//读取数据库连接类型
			Node connectionTypeNode = document.selectSingleNode("/datasource-config/connection-info/connection-type");
			dsb.setConnectionType(connectionTypeNode.getText().trim());
			//读取驱动类
			Node driverClassNode = document.selectSingleNode("/datasource-config/connection-info/driver-class");
			dsb.setDriverClass(driverClassNode.getText().trim());
			//读取数据库URL
			Node dbUrlNode = document.selectSingleNode("/datasource-config/connection-info/db-url");
			dsb.setDbUrl(dbUrlNode.getText().trim());
			//读取用户名
			Node userNameNode = document.selectSingleNode("/datasource-config/connection-info/user-name");
			dsb.setUserName(userNameNode.getText().trim());
			//读取密码
			Node passWordNode = document.selectSingleNode("/datasource-config/connection-info/pass-word");
			dsb.setPassWord(passWordNode.getText().trim());
			//读取是否打印SQL
			Node showSqlNode = document.selectSingleNode("/datasource-config/connection-info/show-sql");
			dsb.setShowSql("true".equalsIgnoreCase(showSqlNode.getText().trim()));
			//读取初始连接数
			Node initialSizeNode = document.selectSingleNode("/datasource-config/pool-info/initial-size");
			dsb.setInitialSize(initialSizeNode.getText().trim());
			//读取最大激活连接数
			Node maxActiveNode = document.selectSingleNode("/datasource-config/pool-info/max-active");
			dsb.setMaxActive(maxActiveNode.getText().trim());
			//读取闲最大置连接数
			Node maxIdleNode = document.selectSingleNode("/datasource-config/pool-info/max-idle");
			dsb.setMaxIdle(maxIdleNode.getText().trim());
			//读取最小闲置连接
			Node minIdleNode = document.selectSingleNode("/datasource-config/pool-info/min-idle");
			dsb.setMinIdle(minIdleNode.getText().trim());
			//读取获取连接最大等待毫秒数
			Node maxWaitNode = document.selectSingleNode("/datasource-config/pool-info/max-wait");
			dsb.setMaxWait(maxWaitNode.getText().trim());
			//是否自动回收连接
			Node removeAbandonedNode = document.selectSingleNode("/datasource-config/pool-info/remove-abandoned");
			dsb.setRemoveAbandoned("true".equalsIgnoreCase(removeAbandonedNode.getText().trim()));
			//自动回收连接超时秒数
			Node removeAbandonedNodeTimeoutNode = document.selectSingleNode("/datasource-config/pool-info/remove-abandoned-timeout");
			dsb.setRemoveAbandonedTimeout(removeAbandonedNodeTimeoutNode.getText().trim());
			//是否打印自动回收日志信息
			Node logAbandonedNode = document.selectSingleNode("/datasource-config/pool-info/log-abandoned");
			dsb.setLogAbandonedNode("true".equalsIgnoreCase(logAbandonedNode.getText().trim()));
		} catch (Exception e) {
			System.out.println("从配置文件读取数据源配置信息出错！");
			e.printStackTrace();
			return null;
		}
		return dsb;
	}
}
