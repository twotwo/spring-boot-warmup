# Spring MVC

- [Spring Data REST](https://spring.io/projects/spring-data-rest) v3.1.3
- [Spring Initializr](https://start.spring.io/)

## 构造工程

Generate a `Maven Project` with `Java` and Spring Boot `1.5.18`

### Project Metadata

- Group `sb.warmup`
- Artifact `springmvc`

### Dependencies

`Rest Repositories`

```bash
$ mvn dependency:tree
sb.warmup:data-rest:jar:0.0.1-SNAPSHOT
+- org.springframework.boot:spring-boot-starter-data-rest:jar:2.1.0.RELEASE:compile
|  +- org.springframework.boot:spring-boot-starter-json:jar:2.1.0.RELEASE:compile
|  +- org.springframework.boot:spring-boot-starter-web:jar:2.1.0.RELEASE:compile
|  |  +- org.springframework.boot:spring-boot-starter-tomcat:jar:2.1.0.RELEASE:compile
|  |  |  +- org.apache.tomcat.embed:tomcat-embed-core:jar:9.0.12:compile
|  |  |  +- org.apache.tomcat.embed:tomcat-embed-el:jar:9.0.12:compile
|  |  |  \- org.apache.tomcat.embed:tomcat-embed-websocket:jar:9.0.12:compile
|  |  +- org.hibernate.validator:hibernate-validator:jar:6.0.13.Final:compile
|  |  |  +- javax.validation:validation-api:jar:2.0.1.Final:compile
|  |  |  +- org.jboss.logging:jboss-logging:jar:3.3.2.Final:compile
|  |  |  \- com.fasterxml:classmate:jar:1.4.0:compile
|  |  \- org.springframework:spring-webmvc:jar:5.1.2.RELEASE:compile
|  |     +- org.springframework:spring-aop:jar:5.1.2.RELEASE:compile
|  |     +- org.springframework:spring-context:jar:5.1.2.RELEASE:compile
|  |     \- org.springframework:spring-expression:jar:5.1.2.RELEASE:compile
|  \- org.springframework.data:spring-data-rest-webmvc:jar:3.1.2.RELEASE:compile
\- org.springframework.boot:spring-boot-starter-test:jar:2.1.0.RELEASE:test
```

## Profiles

参考 [Profiles](https://docs.spring.io/spring-boot/docs/1.5.18.RELEASE/reference/html/boot-features-profiles.html)

### src/main/resources/application.properties

```
spring.profiles.active = local
```

## Logging

参考 [Logging](https://docs.spring.io/spring-boot/docs/1.5.18.RELEASE/reference/html/boot-features-logging.html) & ["How-to" Logging](https://docs.spring.io/spring-boot/docs/1.5.18.RELEASE/reference/html/howto-logging.html)

### pom.xml

- spring-boot-starter-logging ==> spring-boot-starter-log4j2

### src/main/resources/application-profile.properties

```
# Color-coded output
spring.output.ansi.enabled=DETECT
# Log Levels
logging.level.root=WARN
logging.level.sb.warmup.springmvc=DEBUG
```

### src/main/resources/log4j2-profile.xml

参考 [Color-coded output](http://wiki.li3huo.com/apache_log4j#Color-coded_output) 