# Spring Data REST

- [Spring Data REST](https://spring.io/projects/spring-data-rest) v3.1.3
- [Spring Initializr](https://start.spring.io/)

## 构造工程

Generate a `Maven Project` with `Java` and Spring Boot `2.1.0`

### Project Metadata

- Group `sb.warmup`
- Artifact `data-rest`

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