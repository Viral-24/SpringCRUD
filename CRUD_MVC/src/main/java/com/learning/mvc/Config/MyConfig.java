package com.learning.mvc.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
@EnableWebMvc
@ComponentScan(basePackages = {"com.learning.mvc"})
public class MyConfig {
	
	@Bean
	public InternalResourceViewResolver getResolver() {
		InternalResourceViewResolver resolver =new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

}
