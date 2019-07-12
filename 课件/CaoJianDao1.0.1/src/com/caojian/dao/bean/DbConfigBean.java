package com.caojian.dao.bean;

/**
 * 数据库以及数据源配置信息Bean 
 * CaoJianDAO,VERSION: 1.0
 * DATE: 2009-5-22
 * @author CAOJIAN
 */
public class DbConfigBean {
	//数据库连接类型
	private String connectionType;
	 // 数据库驱动
	private String driverClass;
	 // 数据库连接地址
	private String dbUrl;
	 // 用户名
	private String userName;
	 // 密码
	private String passWord;
	 // 初始大小
	private String initialSize;
	 // 最大活跃数
	private String maxActive;
	 // 最大闲置数
	private String maxIdle;
	//最小闲置数
	private String minIdle;
	 // 最大等待时间
	private String maxWait;
	 // 是否打印SQL语句
	private boolean showSql;
	//是否自动回收连接
	private boolean removeAbandoned;
	//是否打印自动回收信息
	private boolean logAbandonedNode;
	//回收连接超时秒数
	private String removeAbandonedTimeout;

	public boolean isRemoveAbandoned() {
		return removeAbandoned;
	}
	public void setRemoveAbandoned(boolean removeAbandoned) {
		this.removeAbandoned = removeAbandoned;
	}
	public boolean isLogAbandonedNode() {
		return logAbandonedNode;
	}
	public void setLogAbandonedNode(boolean logAbandonedNode) {
		this.logAbandonedNode = logAbandonedNode;
	}
	public String getRemoveAbandonedTimeout() {
		return removeAbandonedTimeout;
	}
	public void setRemoveAbandonedTimeout(String removeAbandonedTimeout) {
		this.removeAbandonedTimeout = removeAbandonedTimeout;
	}
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getInitialSize() {
		return initialSize;
	}
	public void setInitialSize(String initialSize) {
		this.initialSize = initialSize;
	}
	public String getMaxActive() {
		return maxActive;
	}
	public void setMaxActive(String maxActive) {
		this.maxActive = maxActive;
	}
	public String getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(String maxIdle) {
		this.maxIdle = maxIdle;
	}
	public String getMaxWait() {
		return maxWait;
	}
	public void setMaxWait(String maxWait) {
		this.maxWait = maxWait;
	}
	public boolean isShowSql() {
		return showSql;
	}
	public void setShowSql(boolean showSql) {
		this.showSql = showSql;
	}
	public String getConnectionType() {
		return connectionType;
	}
	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}
	public String getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(String minIdle) {
		this.minIdle = minIdle;
	}
}
