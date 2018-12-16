package sb.warmup.springmvc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * GeneralServiceTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GeneralServiceTest {
  @Autowired
  private GeneralService service;

  @Test
  public void parseTest() {
    Resource resource = new ClassPathResource("template.json");
    String str = service.stearmToString(resource.getInputStream());
  }
  
}