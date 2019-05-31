package com.li3huo.mybatisplus.demo;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.li3huo.mybatisplus.demo.entity.User;
import com.li3huo.mybatisplus.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;

/**
 * @author li3huo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CRUDTest {

	@Resource
	private UserMapper userMapper;

	@Value("${test.key}")
	private String key;

	@Test
	public void contextLoads() {
		log.info("contextLoads() key={}", key);

	}

	@Test
	public void testInsert() {
		User user = new User().setName("li3huo").setAge(44).setEmail("admin@li3huo.com");
		assertThat(userMapper.insert(user)).isGreaterThan(0);
		assertThat(user.getId()).isNotNull();
	}

	@Test
	public void testSelect() {
		log.info("----- selectAll method test ------");

		List<User> userList = userMapper.selectList(null);
		// init 5 + add 1 = 6
		assertThat(userList.size()).isGreaterThan(5);
		userList.forEach(user -> log.info("user={}", user));
	}

	@Test
	public void testUpdate() {
		// updateById
		assertThat(userMapper.updateById(new User().setId(1L).setEmail("test@li3huo.com")))
				.isGreaterThan(0);

		// update by condition
		assertThat(userMapper.update(new User().setName("NewName"),
				Wrappers.<User>lambdaUpdate().set(User::getAge, 25).eq(User::getId, 1))).isGreaterThan(0);
		User user = userMapper.selectById(1);
		assertThat(user.getAge()).isEqualTo(25);
		assertThat(user.getName()).isEqualTo("NewName");

		// update by condition, entity is null
		userMapper.update(null,
				Wrappers.<User>lambdaUpdate().set(User::getEmail, null).eq(User::getId, 1));
		assertThat(userMapper.selectById(1).getEmail()).isNull();
		user = userMapper.selectById(1);
		assertThat(user.getEmail()).isNull();
		assertThat(user.getName()).isEqualTo("NewName");

		// update by condition with QueryWrapper
		userMapper.update(new User().setEmail("admin@li3huo.com"),
				new QueryWrapper<User>().lambda().eq(User::getId, 1));
		user = userMapper.selectById(1);
		assertThat(user.getEmail()).isEqualTo("admin@li3huo.com");

		//
		userMapper.update(new User().setEmail("test1@li3huo.com"),
				Wrappers.<User>lambdaUpdate().set(User::getAge, null).eq(User::getId, 1));
		user = userMapper.selectById(1);
		assertThat(user.getEmail()).isEqualTo("test1@li3huo.com");
		assertThat(user.getAge()).isNull();
	}

	@Test
	public void testDelete() {
		// assertThat(userMapper.deleteById(3L)).isGreaterThan(0);

		userMapper.insert(new User().setId(10086L).setName("李四").setEmail("bill@li3huo.com").setAge(3));

		userMapper
				.insert(new User().setId(10086L).setName("Bill").setEmail("bill@li3huo.com").setAge(3));
		userMapper.insert(new User().setId(10087L).setName("Ben").setEmail("ben@li3huo.com").setAge(5));

		assertThat(userMapper.delete(new QueryWrapper<User>().lambda().eq(User::getName, "bill")))
				.isGreaterThan(0);
	}
}

