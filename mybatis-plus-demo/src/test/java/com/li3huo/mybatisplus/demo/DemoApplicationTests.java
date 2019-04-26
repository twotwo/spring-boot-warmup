package com.li3huo.mybatisplus.demo;

import java.util.List;
import javax.annotation.Resource;
import com.li3huo.mybatisplus.demo.entity.User;
import com.li3huo.mybatisplus.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoApplicationTests {

	@Resource
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSelect() {
		log.info("----- selectAll method test ------");

		List<User> userList = userMapper.selectList(null);
		Assert.assertEquals(5, userList.size());
		userList.forEach(user -> log.info("user={}", user));
	}

}
