# Springfox Demo

## Generate Project

[Spring Initializr](https://start.spring.io/)

- Spring Boot `1.5.19`
- Project Metadata groupId=`com.example`/artifactId=`springfox-demo`/package=`com.example.demo`
- Selected dependencies `web`, `security`, `actuator`, `lombk` //add one by one

### Add Dependency

```xml
    <!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
    <dependency>
      <groupId>io.springfox</groupId>
      <artifactId>springfox-swagger2</artifactId>
      <version>2.9.2</version>
    </dependency>
    <dependency>
      <groupId>io.springfox</groupId>
      <artifactId>springfox-swagger-ui</artifactId>
      <version>2.9.2</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/io.github.swagger2markup/swagger2markup -->
    <dependency>
      <groupId>io.github.swagger2markup</groupId>
      <artifactId>swagger2markup</artifactId>
      <version>1.3.3</version>
    </dependency>
```
