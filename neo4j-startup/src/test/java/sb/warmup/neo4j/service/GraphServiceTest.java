package sb.warmup.neo4j.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sb.warmup.neo4j.App;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
/**
 * 图谱服务测试
 * 
 * mvn test -Dtest=GraphServiceTest
 */
public class GraphServiceTest {
  private static Logger logger = LoggerFactory.getLogger(GraphServiceTest.class);

  @Autowired
  private GraphService graphService;

  @Test
  /**
   * 企业图谱
   * @throws JsonProcessingException
   */
  public void enterprises() throws JsonProcessingException {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("direct", 200);
    params.put("related", 200);
    logger.info("params={}", params);
    Object resp = this.graphService.execute("enterprises", params);
    logger.info("resp={}", JSON.toJSONString(resp));
    // assertThat(resp).isEqualTo("Hello World!");
  }

}
