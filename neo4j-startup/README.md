# Neo4j 第一个程序

- [The Neo4j Drivers Manual v1.7 for Java](https://neo4j.com/docs/pdf/neo4j-driver-manual-1.7-java.pdf)
- [Neo4j Java Driver 1.7 API](https://neo4j.com/docs/api/java-driver/1.7/)
- [Spring Boot Neo4j Sample](https://github.com/spring-projects/spring-boot/tree/v1.5.18.RELEASE/spring-boot-samples/spring-boot-sample-data-neo4j)
- [Using Neo4j from Spring](https://neo4j.com/developer/spring-data-neo4j/) ✩⭐️️️️
- [Spring Data Neo4J](https://spring.io/projects/spring-data-neo4j#learn)

## 初始化数据

Run `:play movies` command, and click and run the Cypher statement to insert the dataset

```

```

### 数据迁移

```bash
# backup in docker
docker exec -ti my_neo4j_1 bash
tar czf graph.db.tar.gz /var/lib/neo4j/data/databases/graph.db
# cp out of docker
docker cp my_neo4j_1:/tmp/graph.db.tar.gz .
```


## 运行

```bash
mvn spring-boot:run
mvn test -Dtest=GraphServiceTest
```

## Dev Info

### API for development

`mvn dependency:tree | grep -i neo4j`

-- spring-data/data-neo4j/4.2.17

- `org.springframework.data.neo4j.util`.[IterableUtils](https://docs.spring.io/spring-data/data-neo4j/docs/4.2.17.RELEASE/api/org/springframework/data/neo4j/util/IterableUtils.html)
- `org.springframework.data.neo4j.repository`.[GraphRepository<T>](https://docs.spring.io/spring-data/data-neo4j/docs/4.2.17.RELEASE/api/org/springframework/data/neo4j/repository/GraphRepository.html)
- `org.springframework.data.neo4j.repository`.[Neo4jRepository<T,ID extends Serializable>](https://docs.spring.io/spring-data/data-neo4j/docs/4.2.17.RELEASE/api/org/springframework/data/neo4j/repository/Neo4jRepository.html)
- `org.springframework.data.neo4j.repository.support`.[SimpleNeo4jRepository](https://docs.spring.io/spring-data/data-neo4j/docs/4.2.17.RELEASE/api/org/springframework/data/neo4j/repository/support/SimpleNeo4jRepository.html) `SimpleNeo4jRepository(Class<T> domainClass, org.neo4j.ogm.session.Session session)`

-- org.neo4j/neo4j-ogm-core/2.1.6

- `org.neo4j.ogm.session`.[Utils](https://static.javadoc.io/org.neo4j/neo4j-ogm-core/2.1.6/org/neo4j/ogm/session/Utils.html)
- `org.neo4j.ogm.session`.[Neo4jSession](https://static.javadoc.io/org.neo4j/neo4j-ogm-core/2.1.6/org/neo4j/ogm/session/Neo4jSession.html)

-- org.neo4j/neo4j-ogm-api/2.1.6

- `org.neo4j.ogm.model`.[Result](https://static.javadoc.io/org.neo4j/neo4j-ogm-api/2.1.6/org/neo4j/ogm/model/Query.html)

-- jdk/1.8

- `java.util`.[LinkedHashMap<K,V>](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html)

### Cypher Queries
- [3.7.4.3 Cypher queries](https://neo4j.com/docs/ogm-manual/3.1/reference/#reference:session:loading-entities:cypher-queries)