package sb.warmup.neo4j.service;

import java.util.Map;

/**
 * 首页搜索导航服务
 *
 */
public interface GraphService {
  Object execute(String keyword, Map<String, Object> params);
}
