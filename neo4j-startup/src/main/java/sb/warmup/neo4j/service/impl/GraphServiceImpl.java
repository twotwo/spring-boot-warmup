package sb.warmup.neo4j.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.neo4j.driver.internal.InternalPath;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import sb.warmup.neo4j.service.GraphService;

@Service
public class GraphServiceImpl implements GraphService {
  private static Logger LOGGER = LoggerFactory.getLogger(GraphServiceImpl.class);

  private final Session neo4jSession;

  // private final ElasticsearchTemplate esTemplate;

  public GraphServiceImpl(Session neo4jSession) throws IOException {
    this.neo4jSession = neo4jSession;
  }

  @Override
  public Object execute(String keyword, Map<String, Object> params) {
    // 关联企业的涉诉情况
    String queryStr = "MATCH p=shortestPath((bacon:Person {name:'Kevin Bacon'})-[*]-(meg:Person {name:'Meg Ryan'}))RETURN p";
    LOGGER.info("query={}", queryStr);

    Iterator<Map<String, Object>> namesIterator = neo4jSession.query(queryStr, Collections.emptyMap()).queryResults()
        .iterator();

    return toD3Format(namesIterator);
  }

  /**
   * 把查询结果转化成前端展示的图谱格式
   * 
   * @param result
   * @return
   */
  private Map<String, Object> toD3Format(Iterator<Map<String, Object>> result) {
    List<Map<String, Object>> nodes = new ArrayList<>();
    List<Map<String, Object>> rels = new ArrayList<>();
    while (result.hasNext()) {
      for (Map.Entry<String, Object> entry : result.next().entrySet()) {
        InternalPath path = (InternalPath) entry.getValue();
        for (Node node : path.nodes()) {
          String types = StringUtils.join(node.labels(), ",");
          LOGGER.debug("key={}, path @id={}, @types={}, @labels={}, name={}", entry.getKey(), node.id(), types,
              node.labels(), node.get("name"));
          nodes.add(map("@id", node.id(), "@label", node.labels(), "@types", types));

        }
        for (Relationship relationship : path.relationships()) {
          LOGGER.debug("relationship @id={}, @source={}, @target={}, @type={}", relationship.id(),
              relationship.startNodeId(), relationship.endNodeId(), relationship.type());
          rels.add(map("@id", relationship.id(), "@type", relationship.type(), "@source", relationship.startNodeId(),
              "@target", relationship.endNodeId()));
        }
      }
    }
    return map("nodes", nodes, "links", rels);
  }

  private Map<String, Object> map(Object... args) {
    Map<String, Object> result = new HashMap<String, Object>(2);
    for (int i = 0; i < args.length - 1; i++) {
      result.put(args[i].toString(), args[++i]);
    }
    return result;
  }

}
