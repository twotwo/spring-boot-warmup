# Getting Started

## 快速开始

- [参考文档](https://mybatis.plus/guide/quick-start.html)

### 初始化工程

使用 Spring Initializr 快速初始化一个 Spring Boot 工程

添加依赖

- spring-boot-starter
- spring-boot-starter-test
- mybatis-plus-boot-starter
- lombok
- h2

```xml
    <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId>
      <scope>runtime</scope>
    </dependency>
```

### 数据库 Schema & Data

- `src/main/resources/db/schema-h2.sql`
- `src/main/resources/db/data-h2.sql`

### 配置 application.yml

`src/main/resources/application.yaml`

```yaml
# DataSource Config
spring:
  datasource:
    driver-class-name: org.h2.Driver
    schema: classpath:db/schema-h2.sql
    data: classpath:db/data-h2.sql
    url: jdbc:h2:mem:test
    username: root
    password: test
```

### 在 Spring Boot 启动类中添加 @MapperScan 注解，扫描 Mapper 文件夹

```java
// DemoApplication.java
@MapperScan("com.li3huo.mybatisplus.demo.mapper")
```

### 编码

- 实体类 `src/main/java/com/li3huo/mybatisplus/demo/entity/User.java`
- Mapper 类 `src/main/java/com/li3huo/mybatisplus/demo/mapper/UserMapper.java`
- 测试类 `src/test/java/com/li3huo/mybatisplus/demo/DemoApplicationTests.java`

### 运行测试

首先启动后台服务 `docker-compose up -d`

然后运行 `mvn test`

```mysql
CREATE DATABASE test
    DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci;
```

## 注解

- [参考文档](https://mybatis.plus/guide/annotation.html)

### @TableName

entity.User

```java
@Data
@TableName("t_user")
public class User {
  private Long id;
  private String name;
  private Integer age;
  private String email;
}
```

### @TableId

```java
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;
```

### @TableField

```java
@Data
@Accessors(chain = true)
@TableName("t_order")
public class ExamOrder extends BaseEntity {
  private String patient;
  // don't handle one-to-many relationship
  @TableField(exist = false)
  ...
}

@Data
@EqualsAndHashCode
public class BaseEntity {
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
}
```

## CRUD

[Mapper CRUD](https://mybatis.plus/guide/crud-interface.html)


## Cache with Redis

1. pom.xml add `starter-cache` & `starter-data-redis`
2. application.yaml `Cache Config` & `Redis Config`
3. DemoApplication.java add `@EnableCaching`
4. ExamService.java `@CacheConfig(cacheNames = "ExamItemsCache")` & `@Cacheable`
5. ExamItem.java `implements Serializable`
 