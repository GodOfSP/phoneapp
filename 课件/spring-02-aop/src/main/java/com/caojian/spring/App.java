package com.caojian.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.caojian.spring.beans.MyService;
import com.caojian.spring.beans.XmlCfgService;
import com.caojian.spring.config.SpringConfiguration;

/**
 * Hello world!
 *
 */
public class App {
	private static final Log log = LogFactory.getLog(App.class);
	
	AnnotationConfigApplicationContext ctx = null;
	
    public static void main( String[] args ){
    	App app = new App();
    	app.start();
    	
    	app.runAopTest();
    	//app.runXmlAopTest();
    	
    	//app.block();
    	app.close();
    }
	
	private void runXmlAopTest() {
		XmlCfgService service = (XmlCfgService)ctx.getBean("xmlCfgService");
		//service.saveData("123");
		service.queryData();
	}

	private void runAopTest() {
		MyService service = (MyService)ctx.getBean("myService");
		//service.doSomething("test aop");
		service.querySomeData();
	}

	private void start() {
		ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		log.debug("SpringContext启动成功！");
	}
	
	private void close() {
		if (ctx != null)
			ctx.close();
		
		log.debug("SpringContext已关闭！");
	}
	
	private void block () {
		synchronized (App.class) {
			while (true) {
				try {
					App.class.wait();
				} catch (InterruptedException e) {
					log.error("同步出错:",e);
				}
			}
		}
	}

}
