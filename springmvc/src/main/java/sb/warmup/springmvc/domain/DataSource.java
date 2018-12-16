package sb.warmup.springmvc.domain;

/**
 * DataSource
 */
public enum DataSource {

  NEO4J("neo4j", "Neo4j DataSrouce"),

  ELASTICSEARCH("es", "Elasticsearch DataSrouce");

  public final String type;
  public final String description;
  DataSource(String type, String description) {
    this.type = type;
    this.description = description;
  }

  public static DataSource toDataSource(String type) {
    for (DataSource dataSource : DataSource.values()) {
        if (dataSource.type.equalsIgnoreCase(type)) {
            return dataSource;
        }
    }
    throw new RuntimeException("DataSource unknown Type: "+type);
}
}