# Elastic Search 第一个程序

- [使用springdata操作es出错](https://mp.weixin.qq.com/s/2P85VockSOhZolU7s7xxTw)
- [Reference](https://docs.spring.io/spring-data/elasticsearch/docs/2.1.x/reference/html/)
- [Java API](https://docs.spring.io/spring-data/elasticsearch/docs/2.1.x/api/) spring-boot v1.5 -> spring-data-elasticsearch v2.1.x

## 配置 ES

### Homebrew版本
`vi /usr/local/etc/elasticsearch/elasticsearch.yml`

```yaml
cluster.name: elasticsearch_dev
```
### Docker

- [Docker Hub -> elasticsearch](https://hub.docker.com/_/elasticsearch)
- [](https://www.elastic.co/guide/en/elasticsearch/reference/6.x/docker.html)

```bash
docker pull elasticsearch:2.4.6
# -v /tmp/elasticsearch_data:/usr/share/elasticsearch/data -v /tmp/es.yml:/usr/share/elasticsearch/config/elasticsearch.yml 
docker run -d --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:2.4.6
```

### Query

```bash
➜  es-startup git:(master) ✗ curl "localhost:9200/_cat/indices?v"
health status index    pri rep docs.count docs.deleted store.size pri.store.size 
green  open   customer   1   0          2            0      6.3kb          6.3kb
➜  es-startup git:(master) ✗ curl -XGET 'http://localhost:9200/customer/_search?q=*&pretty'
{
  ...
}
```

## API

### Using @Query Annotation

- [2.2.3. Using @Query Annotation](https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#elasticsearch.query-methods.at-query)