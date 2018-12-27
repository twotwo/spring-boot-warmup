package sb.warmup.neo4j.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * QueryConfig
 */
@Configuration
@ConfigurationProperties(prefix="querys")
@Data
public class QueryConfig {
  private final Map<String,Query> map = new HashMap<String,Query>();
}