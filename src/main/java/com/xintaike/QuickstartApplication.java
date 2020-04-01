package com.xintaike;

import com.xintaike.utils.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class QuickstartApplication {

	public static void main(String[] args) {
		//取出spring容器引用
		ApplicationContext app = SpringApplication.run(QuickstartApplication.class, args);
		//初始化spring工具类
		SpringUtil.setApplicationContext(app);
	}

}
