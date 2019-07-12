package com.caojian.dao.bean;

/**
 * ���ݿ��Լ�����Դ������ϢBean 
 * CaoJianDAO,VERSION: 1.0
 * DATE: 2009-5-22
 * @author CAOJIAN
 */
public class DbConfigBean {
	//���ݿ���������
	private String connectionType;
	 // ���ݿ�����
	private String driverClass;
	 // ���ݿ����ӵ�ַ
	private String dbUrl;
	 // �û���
	private String userName;
	 // ����
	private String passWord;
	 // ��ʼ��С
	private String initialSize;
	 // ����Ծ��
	private String maxActive;
	 // ���������
	private String maxIdle;
	//��С������
	private String minIdle;
	 // ���ȴ�ʱ��
	private String maxWait;
	 // �Ƿ��ӡSQL���
	private boolean showSql;
	//�Ƿ��Զ���������
	private boolean removeAbandoned;
	//�Ƿ��ӡ�Զ�������Ϣ
	private boolean logAbandonedNode;
	//�������ӳ�ʱ����
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
