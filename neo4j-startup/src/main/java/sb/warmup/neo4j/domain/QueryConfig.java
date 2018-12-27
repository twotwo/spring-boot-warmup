package sb.warmup.neo4j.domain;

import java.util.ArrayList;
import java.util.List;

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
  private final List<Query> list = new ArrayList<>();
}