package com.caojian.dao.test;

import java.util.List;
import java.util.Map;

import com.caojian.dao.basedao.impl.BaseDaoImpl;

/**
 * 测试类 可供参考
 * 
 * @author caojian
 */
public class Test extends BaseDaoImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Test test = new Test();
		test.testQuery ();//测试单值查询
		test.testQueryList ();//测试多列多行查询
		test.testPageQuery ();//测试分页查询（mysql）如果是oracle数据库sql中表请使用别名
		test.testUpdate();
		test.testMAP();
	}

	private void testUpdate() throws Exception {
		System.out.println(this.executeUpdate(
								"insert into th_news (title,content,source,publishtime) values (?,?,?,?)",
								new Object[] { "title", "content", "source",
										"20090909" }));
		System.out.println(this.executeUpdate(
				"delete from th_news where title=?", new Object[] { "title" }));
		String[] sqls = new String[] {
				"insert into th_news (title,content,source,publishtime) values ('title','content','source','2008-8-8')",
				"insert into th_news (title,content,source,publishtime) values ('title','content','source','2008-8-8')",
				"insert into th_news (title,content,source,publishtime) values ('title','content','source','2008-8-8')",
				"insert into th_news (title,content,source,publishtime) values ('title','content','source','2008-8-8')",
				"insert into th_news (title,content,source,publishtime) values ('title','content','source','2008-8-8')" };
		System.out.println(this.executeBath(sqls));
		String[] sqls2 = new String[]{"delete from th_news where uid=12","delete from th_news where uid=13",
				"delete from th_news where uid=8"};
		System.out.println(this.executeBath(sqls2));
	}

	@SuppressWarnings("unchecked")
	private void testPageQuery() throws Exception {
		this.setRowsNum(3);
		List<Map<String, Object>> lt = this.queryForPage(
				"select * from ts_module where sortid in (?,?,?)",
				new Object[] { "1001", "1005", "1006" }, 1);
		for (Map map : lt) {
			System.out.println(map);
		}
	}

	private void testQuery() throws Exception {
		System.out.println(this.queryForInteger(
				"select count(1) from ts_module", null));
		System.out.println(this.queryForLong(
				"select sum(sortid) from ts_module", null));
		System.out.println(this.queryForDouble(
				"select avg(sortid) from ts_module where showinmenu=?",
				new Object[] { "1" }));
	}

	@SuppressWarnings("unchecked")
	private void testQueryList() throws Exception {
		List<Map<String, Object>> lt = this.queryForList(
				"select * from ts_module where orderid=?", new Object[]{"1"});
		for (Map map : lt) {
			System.out.println(map);
		}
	}
	
	/**
	 * 特别注意:不同的数据库查询出来的List结果集里面的Map的key（也就是列名）大小写不一（oracle全大写，mysql小写）
	 * 为了解决这个问题，采用了getXxxFromMap（map,key）这个方法来解决，你可以不必区分大小写
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void testMAP() throws Exception {
		List<Map<String,Object>> lt = this.queryForList("select * from th_news", null);
		for (Map map : lt) {
			System.out.println(this.getStringFromMap(map, "CoNTEnt"));
			System.out.println(this.getDateFromMap(map, "PublishTime"));
			System.out.println(this.getStringFromMap(map, "title"));
			System.out.println(this.getDoubleFromMap(map, "uId"));
			System.out.println(this.getObjectFromMap(map, "uid"));
			System.out.println(this.getIntegerFromMap(map, "state"));
			System.out.println(this.getStringFromMap(map, "imgURL"));
		}
		
	}

}
