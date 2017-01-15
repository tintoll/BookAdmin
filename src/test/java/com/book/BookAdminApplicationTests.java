package com.book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
//스프링 부트로 컨텍스트 로드
@SpringApplicationConfiguration(classes = BookAdminApplication.class)
@WebAppConfiguration
public class BookAdminApplicationTests {

	@Test
	public void contextLoads() { //컨텍스트 로드 테스트
	}

}
