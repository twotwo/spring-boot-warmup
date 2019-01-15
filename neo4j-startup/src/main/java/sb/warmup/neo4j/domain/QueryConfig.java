package sb.warmup.neo4j.domain;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import lombok.extern.slf4j.Slf4j;
import sb.warmup.neo4j.yaml.YamlPropertySourceFactory;

/**
 * QueryConfig
 * 
 * <a href=
 * "https://stackoverflow.com/questions/30079255/propertysource-in-a-jar-for-an-external-file-on-the-classpath">参考</a>
 */
@Configuration
@PropertySources({
    @PropertySource(value = "${query.path}", ignoreResourceNotFound = true, factory = YamlPropertySourceFactory.class) })
@ConfigurationProperties(prefix = "querys")
@Slf4j
public class QueryConfig implements InitializingBean {
  private Map<String, Query> map;

  public void setMap(Map<String, Query> map) {
    log.debug("setMap, keys={}", map.keySet());
    this.map = map;
  }

  public Map<String, Query> getMap() {
    return this.map;
  }

  @Override
  public String toString() {
    return "size=" + map.size() + "; keys=" + map.keySet();
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    log.warn("map size={}", map.size());
    if (map == null) {
      map = new HashMap<String, Query>();
      log.error("Failed to Load Queries!");
    }
  }

  public Query getQuery(String keyword) {
    return Optional.ofNullable(map.get(keyword)).orElseThrow(() -> new RuntimeException("keyword not found"));
  }

  public List<Query> getQueries() {
    return map.values().stream().sorted(Comparator.comparing(Query::getHint)).collect(Collectors.toList());
  }
}