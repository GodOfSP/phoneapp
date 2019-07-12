package com.caojian.bootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableTransactionManagement //启注解事务管理，等同于xml配置方式的 <tx:annotation-driven /> SpringBoot会自动配置
@SpringBootApplication
public class BootDemoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BootDemoApplication.class);
	
	/**
	 * 自定义事务管理器，不配置的话SpringBoot默认为我们注入
	 * 其中 dataSource 框架会自动为我们注入
	 * @param dataSource
	 * @return
	 */
//    @Bean
//    public PlatformTransactionManager txManager(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

	public static void main(String[] args) {
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>SaaS WEB服务启动中...");
		
		SpringApplication.run(BootDemoApplication.class, args);
		
		log.info("");
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>SaaS WEB服务启动成功 (^_^)");
	}

}
