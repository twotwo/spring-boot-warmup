package sb.warmup.neo4j.domain;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import sb.warmup.neo4j.yaml.YamlPropertySourceFactory;

/**
 * QueryConfig
 */
@PropertySources({
    @PropertySource(factory = YamlPropertySourceFactory.class, value = "file:/opt/local/services/universe/application-query.yml", ignoreResourceNotFound = true),
    @PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:application-query.yml") })
@ConfigurationProperties(prefix="querys")
@Configuration
@Data @Slf4j
public class QueryConfig implements InitializingBean {
  private final Map<String, Query> map = new HashMap<String, Query>();

  @Override
  public void afterPropertiesSet() throws Exception {
    log.warn("map={}", map);
  }
}