package com.jack.roleauthjwt.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrosConfiguration {
	
	public WebMvcConfigurer crosConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {

				registry.addMapping("/**")
				WebMvcConfigurer.super.addCorsMappings(registry);
			}
		};
	}

}
