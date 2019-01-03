package sb.warmup.neo4j.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import sb.warmup.neo4j.App;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
/**
 * 图谱服务测试
 * 
 * mvn test -Dtest=QueryConfigTest -Dquery.path=file:/tmp/new.yml
 */
@Slf4j
public class QueryConfigTest {

  @Autowired
  private QueryConfig config;

  @Test
  public void readConfig() {
    log.info("myConfig={}",config);
    log.info("company-timeline={}",config.getQuery("company-timeline").getDescription());
    assertEquals(config.getQuery("company-timeline").getDescription(),"get company info by year");
    log.info("es-demo={}", config.getQuery("es-demo"));
  }

}
