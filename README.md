# spring-boot-warmup

## 24.6 Using YAML instead of Properties
- [24.6 Using YAML instead of Properties](https://docs.spring.io/spring-boot/docs/1.5.18.RELEASE/reference/html/boot-features-external-config.html#boot-features-external-config-yaml)

### 使用YAML配置文件读取查询List

```yaml
querys:
  list:
    - name: keyword1
      description: desc1
      dataSource: neo4j
      params: 
        name: My Company
        begin: 2018-01-01
        end: 2018-12-31
    - name: keyword2
      description: desc2
      dataSource: neo4j
      params: 
        name: My Company
```

### 使用YAML配置文件读取查询Map

```yaml
querys:
  map:
    keyword1:
      description: desc1
      dataSource: neo4j
      params: 
        name: My Company
        begin: 2018-01-01
        end: 2018-12-31
    keyword2:
      description: desc2
      dataSource: neo4j
      params: 
        name: My Company
```

### 主动加载 YAML 文件
- [Spring @PropertySource using YAML](https://stackoverflow.com/questions/21271468/spring-propertysource-using-yaml)
- [7.6. Customizing the nature of a bean](https://docs.spring.io/spring-framework/docs/4.3.21.RELEASE/spring-framework-reference/html/beans.html#beans-factory-lifecycle-initializingbean)

