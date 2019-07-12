package com.caojian.dao.basedao;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ����DAO�㣬���ڶ����ݿ�Ĳ���
 * ����ɾ���ģ���
 * CaoJianDAO,VERSION: 1.0 
 * DATE: 2009-5-22
 * @author CAOJIAN
 */
public interface BaseDao {
	/**
	 * ��ѯ���ݣ�����List��װ�Ľ������ÿ����¼��Map��װ
	 * @param sql sql���
	 * @param param sql�����������û������null
	 * @return List��װ�Ľ����
	 * @throws Exception
	 */
	public List<Map<String,Object>> queryForList (String sql, Object[] param) throws Exception;
	
	/**
	 * ��ѯ���ݣ�����Integer���
	 * @param sql sql���
	 * @param param sql�����������û������null
	 * @return Integer���
	 * @throws Exception
	 */
	public int queryForInteger (String sql, Object[] param) throws Exception;
	
	/**
	 * ��ѯ���ݣ�����long���
	 * @param sql sql���
	 * @param param sql�����������û������null
	 * @return long���
	 * @throws Exception
	 */
	public long queryForLong (String sql, Object[] param) throws Exception;
	
	/**
	 * ��ѯ���ݣ�����double���
	 * @param sql sql���
	 * @param param sql�����������û������null
	 * @return double���
	 * @throws Exception
	 */
	public double queryForDouble (String sql, Object[] param) throws Exception;
	
	/**
	 * ��ѯ���ݣ�����float���
	 * @param sql sql���
	 * @param param sql�����������û������null
	 * @return float���
	 * @throws Exception
	 */
	public float queryForFloat (String sql, Object[] param) throws Exception;
	
	/**
	 * ��ѯ���ݣ������ַ������
	 * @param sql sql���
	 * @param param sql�����������û������null
	 * @return String���
	 * @throws Exception
	 */
	public String queryForString (String sql, Object[] param) throws Exception;
	
	/**
	 * ��ѯ���ݣ�����Object���
	 * @param sql sql���
	 * @param param sql�����������û������null
	 * @return Object���
	 * @throws Exception
	 */
	public Object queryForObject (String sql, Object[] param) throws Exception;
	
	/**
	 * ��ȡÿҳ��ʾ����
	 * @return ÿҳ��ʾ����
	 */
	public int getRowsNum ();
	
	/**
	 * ����ÿҳ��ʾ����
	 * @param rowsNum ÿҳ��ʾ����
	 */
	public void setRowsNum (int rowsNum);
	
	/**
	 * ��ȡ��ҳҳ��
	 * @param rowsCount ��¼����
	 * @return ��ҳҳ��
	 */
	public int getPageCount (int rowsCount);
	
	/**
	 * ��ҳ��ѯ����
	 * @param sql sql��������oracle���ݿ�sql�б�����ʹ�ñ���
	 * @param param sql�����������û������null
	 * @param pageNo ����ҳ��
	 * @return List��װ�Ľ����
	 * @throws Exception
	 */
	public List<Map<String,Object>> queryForPage (String sql,Object[] param,int pageNo) throws Exception;
	
	/**
	 * ִ�и��»�ɾ������������ɾ���ģ�
	 * @param sql sql���
	 * @param param sql�����������û������null
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int executeUpdate (String sql, Object[] param) throws Exception;
	
	/**
	 * ִ����������
	 * @param sqls sql�������
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int executeBath (String[] sqls) throws Exception;
	
	/**
	 * ��Map��ȡ�� 
	 * @param map
	 * @param key
	 * @return int
	 */
	@SuppressWarnings("unchecked")
	public int getIntegerFromMap (Map map,String key) throws Exception;
	
	/**
	 * ��Map��ȡ��long
	 * @param map
	 * @param key
	 * @return long
	 */
	@SuppressWarnings("unchecked")
	public long getLongFromMap (Map map,String key) throws Exception;
	
	/**
	 * ��Map��ȡ��double
	 * @param map
	 * @param key
	 * @return double
	 */
	@SuppressWarnings("unchecked")
	public double getDoubleFromMap (Map map,String key) throws Exception;
	
	/**
	 * ��Map��ȡ��float
	 * @param map
	 * @param key
	 * @return float
	 */
	@SuppressWarnings("unchecked")
	public float getFloatFromMap (Map map,String key) throws Exception;
	
	/**
	 * ��Map��ȡ��String
	 * @param map
	 * @param key
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	public String getStringFromMap (Map map,String key) throws Exception;
	
	/**
	 * ��Map��ȡ��java.util.Date
	 * @param map
	 * @param key
	 * @return java.util.Date
	 */
	@SuppressWarnings("unchecked")
	public Date getDateFromMap (Map map,String key) throws Exception;
	
	/**
	 * ��Map��ȡ��Object
	 * @param map
	 * @param key
	 * @return Object
	 */
	@SuppressWarnings("unchecked")
	public Object getObjectFromMap (Map map,String key) throws Exception;
	
}
