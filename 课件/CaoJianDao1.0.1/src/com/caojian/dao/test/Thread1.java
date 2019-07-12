package com.caojian.dao.test;

import com.caojian.dao.basedao.impl.BaseDaoImpl;

public class Thread1  extends BaseDaoImpl implements Runnable {

	public void run() {
		for (int i = 0;i<50;i++) {
			String sql = "insert into th_news (title,content,source,publishtime) values ('title','content','source','2008-8-8')";
			try {
				System.out.println(this.executeUpdate(sql, null));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class Thread2 extends BaseDaoImpl implements Runnable {
	public void run() {
		for (int i = 0;i<50;i++) {
			try {
				System.out.println(this.queryForList("select * from th_news", null));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

