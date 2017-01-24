package com.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@SpringBootApplication	//컴포넌트 검색과 자동 구성 활성화
						//@Configuration, @ComponentScan, @EnableAutoConfiguation 을 묶은것이다
public class BookAdminApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		// 애플리케이션 부트스트랩
		SpringApplication.run(BookAdminApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// /login 경로를 login 템플릿으로 매핑
		registry.addViewController("/login").setViewName("login");
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new ReaderHandlerMethodArgumentResolver());
	}
}
