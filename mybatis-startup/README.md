# Spring Boot集成MyBatis

- [Spring Boot集成MyBatis的2种方式](https://www.cnblogs.com/nuccch/p/9060594.html)
- [Sample Code - MyBatis with Annotation](https://github.com/JeffLi1993/springboot-learning-example/tree/master/springboot-mybatis-annotation)

## 配置 MyBatis

- [XML 映射配置文件](http://www.mybatis.org/mybatis-3/zh/configuration.html)

### JDT Config

- `.classpath` JavaSE-1.8
- `.settings/org.eclipse.jdt.core.prefs` 1.8

### 注解方式

- `src/main/resources/application.properties` 数据源 & mybatis 配置

## 初始化MySQL

### Docker
- [Installing and Using MariaDB via Docker](https://mariadb.com/kb/en/library/installing-and-using-mariadb-via-docker/)
- [Docker Hub -> mariadb/server](https://hub.docker.com/r/mariadb/server/)

```bash
docker pull mariadb/server:10.3
# -v /tmp/elasticsearch_data:/usr/share/elasticsearch/data -v /tmp/es.yml:/usr/share/elasticsearch/config/elasticsearch.yml 
docker run -d --name mybatis -e "MYSQL_ROOT_PASSWORD=secret" \
        -e "MARIADB_DATABASE=sb-db" \
        -p 3306:3306 -v /tmp/mybatis:/var/lib/mysql \
        mariadb/server:10.3
docker exec -it mybatis bash
# 检查对外IP
➜  ~ docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' mybatis
172.17.0.2
```

### 初始化表结构和数据

```bash
➜  mybatis-startup git:(master) ✗ mysql -h127.0.0.1 -uroot -psecret < data/schema.sql
```

## API

### Using @Mapper Annotation

- [Quick Setup](http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/index.html)