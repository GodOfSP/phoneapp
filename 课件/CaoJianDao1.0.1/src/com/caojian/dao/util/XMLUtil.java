package com.caojian.dao.util;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.caojian.dao.bean.DbConfigBean;

/**
 * ��ȡXML������Ϣ������ 
 * �ṩ��̬�����õ����ݿ�������Ϣ�����ӳ�������Ϣ
 * CaoJianDAO,VERSION: 1.0 
 * DATE: 2009-5-22
 * @author CAOJIAN
 */
public class XMLUtil {
	/**
	 * ��ȡ����Դ������Ϣ
	 * @return ����Դ������Ϣ(db-config.xml)
	 */
	public static DbConfigBean getDbConfig() {
		DbConfigBean dsb = new DbConfigBean();
		SAXReader reader = new SAXReader();
		try {
			// ��ʼ��ȡ�����ļ���Ϣ
			Document document = reader.read(Thread.currentThread()
					.getContextClassLoader().getResourceAsStream("db-config.xml"));
			//��ȡ���ݿ���������
			Node connectionTypeNode = document.selectSingleNode("/datasource-config/connection-info/connection-type");
			dsb.setConnectionType(connectionTypeNode.getText().trim());
			//��ȡ������
			Node driverClassNode = document.selectSingleNode("/datasource-config/connection-info/driver-class");
			dsb.setDriverClass(driverClassNode.getText().trim());
			//��ȡ���ݿ�URL
			Node dbUrlNode = document.selectSingleNode("/datasource-config/connection-info/db-url");
			dsb.setDbUrl(dbUrlNode.getText().trim());
			//��ȡ�û���
			Node userNameNode = document.selectSingleNode("/datasource-config/connection-info/user-name");
			dsb.setUserName(userNameNode.getText().trim());
			//��ȡ����
			Node passWordNode = document.selectSingleNode("/datasource-config/connection-info/pass-word");
			dsb.setPassWord(passWordNode.getText().trim());
			//��ȡ�Ƿ��ӡSQL
			Node showSqlNode = document.selectSingleNode("/datasource-config/connection-info/show-sql");
			dsb.setShowSql("true".equalsIgnoreCase(showSqlNode.getText().trim()));
			//��ȡ��ʼ������
			Node initialSizeNode = document.selectSingleNode("/datasource-config/pool-info/initial-size");
			dsb.setInitialSize(initialSizeNode.getText().trim());
			//��ȡ��󼤻�������
			Node maxActiveNode = document.selectSingleNode("/datasource-config/pool-info/max-active");
			dsb.setMaxActive(maxActiveNode.getText().trim());
			//��ȡ�������������
			Node maxIdleNode = document.selectSingleNode("/datasource-config/pool-info/max-idle");
			dsb.setMaxIdle(maxIdleNode.getText().trim());
			//��ȡ��С��������
			Node minIdleNode = document.selectSingleNode("/datasource-config/pool-info/min-idle");
			dsb.setMinIdle(minIdleNode.getText().trim());
			//��ȡ��ȡ�������ȴ�������
			Node maxWaitNode = document.selectSingleNode("/datasource-config/pool-info/max-wait");
			dsb.setMaxWait(maxWaitNode.getText().trim());
			//�Ƿ��Զ���������
			Node removeAbandonedNode = document.selectSingleNode("/datasource-config/pool-info/remove-abandoned");
			dsb.setRemoveAbandoned("true".equalsIgnoreCase(removeAbandonedNode.getText().trim()));
			//�Զ��������ӳ�ʱ����
			Node removeAbandonedNodeTimeoutNode = document.selectSingleNode("/datasource-config/pool-info/remove-abandoned-timeout");
			dsb.setRemoveAbandonedTimeout(removeAbandonedNodeTimeoutNode.getText().trim());
			//�Ƿ��ӡ�Զ�������־��Ϣ
			Node logAbandonedNode = document.selectSingleNode("/datasource-config/pool-info/log-abandoned");
			dsb.setLogAbandonedNode("true".equalsIgnoreCase(logAbandonedNode.getText().trim()));
		} catch (Exception e) {
			System.out.println("�������ļ���ȡ����Դ������Ϣ����");
			e.printStackTrace();
			return null;
		}
		return dsb;
	}
}
