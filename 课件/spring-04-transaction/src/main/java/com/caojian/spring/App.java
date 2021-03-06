package com.caojian.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.caojian.spring.config.SpringConfiguration;
import com.caojian.spring.service.TestService;

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
    	
    	app.testTransAction ();
    	
    	app.close();
    }
	
	private void testTransAction() {
		TestService service = (TestService)ctx.getBean("testService");
		service.saveStudent();
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
