package com.li3huo.mybatisplus.demo;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import javax.annotation.Resource;
import com.li3huo.mybatisplus.demo.entity.ExamItem;
import com.li3huo.mybatisplus.demo.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;

/**
 * @author li3huo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BookServiceTest {

	@Resource
	private BookService service;

	@Test
	public void testInsert() {
		List<ExamItem> items = service.getAllExamItem();
		service.createOrder("patient", items.toArray(new ExamItem[] {}));
		log.debug("items: {}", items);
		assertThat(items).isNotNull();
	}
}

