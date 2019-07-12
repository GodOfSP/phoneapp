package com.caojian.dao.test;

import java.util.List;
import java.util.Map;

import com.caojian.dao.basedao.impl.BaseDaoImpl;

/**
 * ������ �ɹ��ο�
 * 
 * @author caojian
 */
public class Test extends BaseDaoImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Test test = new Test();
		test.testQuery ();//���Ե�ֵ��ѯ
		test.testQueryList ();//���Զ��ж��в�ѯ
		test.testPageQuery ();//���Է�ҳ��ѯ��mysql�������oracle���ݿ�sql�б���ʹ�ñ���
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
	 * �ر�ע��:��ͬ�����ݿ��ѯ������List����������Map��key��Ҳ������������Сд��һ��oracleȫ��д��mysqlСд��
	 * Ϊ�˽��������⣬������getXxxFromMap��map,key��������������������Բ������ִ�Сд
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
