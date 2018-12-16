package sb.warmup.springmvc.service;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sb.warmup.springmvc.App;
import sb.warmup.springmvc.domain.Template;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * GeneralServiceTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GeneralServiceTest {

  private static Logger LOGGER = LoggerFactory.getLogger(GeneralServiceTest.class);
  @Autowired
  private GeneralService service;

  @Test
  public void parseTest() {
    Template tmpl = service.getTemplate("docs");
    LOGGER.debug("docs={}", tmpl.getQuery());
    LOGGER.debug("ds={}", tmpl.getDataSource());
    assertThat(tmpl.getQuery()).isEqualTo("MATCH (n:JudicialDocument) where n.documentType= \"{{type}}\" RETURN n");
  }

}