package com.caojian.dao.basedao;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 基础DAO层，用于对数据库的操作
 * 增，删，改，查
 * CaoJianDAO,VERSION: 1.0 
 * DATE: 2009-5-22
 * @author CAOJIAN
 */
public interface BaseDao {
	/**
	 * 查询数据，返回List封装的结果集，每条记录以Map封装
	 * @param sql sql语句
	 * @param param sql语句参数，如果没有则传入null
	 * @return List封装的结果集
	 * @throws Exception
	 */
	public List<Map<String,Object>> queryForList (String sql, Object[] param) throws Exception;
	
	/**
	 * 查询数据，返回Integer结果
	 * @param sql sql语句
	 * @param param sql语句参数，如果没有则传入null
	 * @return Integer结果
	 * @throws Exception
	 */
	public int queryForInteger (String sql, Object[] param) throws Exception;
	
	/**
	 * 查询数据，返回long结果
	 * @param sql sql语句
	 * @param param sql语句参数，如果没有则传入null
	 * @return long结果
	 * @throws Exception
	 */
	public long queryForLong (String sql, Object[] param) throws Exception;
	
	/**
	 * 查询数据，返回double结果
	 * @param sql sql语句
	 * @param param sql语句参数，如果没有则传入null
	 * @return double结果
	 * @throws Exception
	 */
	public double queryForDouble (String sql, Object[] param) throws Exception;
	
	/**
	 * 查询数据，返回float结果
	 * @param sql sql语句
	 * @param param sql语句参数，如果没有则传入null
	 * @return float结果
	 * @throws Exception
	 */
	public float queryForFloat (String sql, Object[] param) throws Exception;
	
	/**
	 * 查询数据，返回字符串结果
	 * @param sql sql语句
	 * @param param sql语句参数，如果没有则传入null
	 * @return String结果
	 * @throws Exception
	 */
	public String queryForString (String sql, Object[] param) throws Exception;
	
	/**
	 * 查询数据，返回Object结果
	 * @param sql sql语句
	 * @param param sql语句参数，如果没有则传入null
	 * @return Object结果
	 * @throws Exception
	 */
	public Object queryForObject (String sql, Object[] param) throws Exception;
	
	/**
	 * 获取每页显示条数
	 * @return 每页显示条数
	 */
	public int getRowsNum ();
	
	/**
	 * 设置每页显示条数
	 * @param rowsNum 每页显示条数
	 */
	public void setRowsNum (int rowsNum);
	
	/**
	 * 获取分页页数
	 * @param rowsCount 记录条数
	 * @return 分页页数
	 */
	public int getPageCount (int rowsCount);
	
	/**
	 * 分页查询数据
	 * @param sql sql语句如果是oracle数据库sql中表名青使用别名
	 * @param param sql语句参数，如果没有则传入null
	 * @param pageNo 请求页码
	 * @return List封装的结果集
	 * @throws Exception
	 */
	public List<Map<String,Object>> queryForPage (String sql,Object[] param,int pageNo) throws Exception;
	
	/**
	 * 执行更新或删除操作（增，删，改）
	 * @param sql sql语句
	 * @param param sql语句参数，如果没有则传入null
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int executeUpdate (String sql, Object[] param) throws Exception;
	
	/**
	 * 执行批量更新
	 * @param sqls sql语句数组
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int executeBath (String[] sqls) throws Exception;
	
	/**
	 * 从Map中取出 
	 * @param map
	 * @param key
	 * @return int
	 */
	@SuppressWarnings("unchecked")
	public int getIntegerFromMap (Map map,String key) throws Exception;
	
	/**
	 * 从Map中取出long
	 * @param map
	 * @param key
	 * @return long
	 */
	@SuppressWarnings("unchecked")
	public long getLongFromMap (Map map,String key) throws Exception;
	
	/**
	 * 从Map中取出double
	 * @param map
	 * @param key
	 * @return double
	 */
	@SuppressWarnings("unchecked")
	public double getDoubleFromMap (Map map,String key) throws Exception;
	
	/**
	 * 从Map中取出float
	 * @param map
	 * @param key
	 * @return float
	 */
	@SuppressWarnings("unchecked")
	public float getFloatFromMap (Map map,String key) throws Exception;
	
	/**
	 * 从Map中取出String
	 * @param map
	 * @param key
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	public String getStringFromMap (Map map,String key) throws Exception;
	
	/**
	 * 从Map中取出java.util.Date
	 * @param map
	 * @param key
	 * @return java.util.Date
	 */
	@SuppressWarnings("unchecked")
	public Date getDateFromMap (Map map,String key) throws Exception;
	
	/**
	 * 从Map中取出Object
	 * @param map
	 * @param key
	 * @return Object
	 */
	@SuppressWarnings("unchecked")
	public Object getObjectFromMap (Map map,String key) throws Exception;
	
}
