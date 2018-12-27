package sb.warmup.neo4j.domain;

import java.util.Map;
import lombok.Data;

/**
 * 预配置查询
 */

@Data
public class Query {
	private String name;
	private String description;
	private String dataSource;
	private Map<String, Object> params;
	private String query;
}