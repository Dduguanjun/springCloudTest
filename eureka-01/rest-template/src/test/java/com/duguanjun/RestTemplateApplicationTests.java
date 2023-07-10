package com.duguanjun;

import com.duguanjun.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class RestTemplateApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testRestTemplate(){

		RestTemplate restTemplate = new RestTemplate();

		String url = "https://www.baidu.com";
		//ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
		String result = restTemplate.getForObject(url, String.class);

		System.out.println(result);

	}

	@Test
	public void testGet(){
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8010/testGet?name=dgj";
		//String result = restTemplate.getForObject(url, String.class);
		//http协议
		ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);

		System.out.println(forEntity);
	}
	@Test
	public void testPostJson(){
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8010/testPost";
		User user = new User();
		user.setPhone("111111111111111111");
		user.setPassword("22222222222222222");
		user.setName("sddddd");

		//发post请求而且是json参数 因为web里面默认使用jackson将对象转换为json
		String result = restTemplate.postForObject(url, user,String.class);
		System.out.println(result);
	}
	@Test
	public void testPostForm(){
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8010/testPost2";

		//构建表单参数
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		map.add("name", "tange");
		map.add("phone", "23");
		map.add("password", "222222");
		String result = restTemplate.postForObject(url, map,String.class);

		System.out.println(result);
	}

}
