# Springfox Demo

## Generate Project

[Spring Initializr](https://start.spring.io/)

- Spring Boot `1.5.19`
- Project Metadata groupId=`com.example`/artifactId=`springfox-demo`/package=`com.example.demo`
- Selected dependencies `web`, `security`, `actuator`, `lombk` //add one by one

### Add Dependency

```xml
    <!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
    <!-- 让项目支持 OpenAPI Spec -->
    <dependency>
      <groupId>io.springfox</groupId>
      <artifactId>springfox-swagger2</artifactId>
      <version>2.9.2</version>
    </dependency>
    <!-- 让项目支持 API 调试 -->
    <dependency>
      <groupId>io.springfox</groupId>
      <artifactId>springfox-swagger-ui</artifactId>
      <version>2.9.2</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/io.github.swagger2markup/swagger2markup -->
    <!-- 让项目支持 OpenAPI 文档导出 -->
    <dependency>
      <groupId>io.github.swagger2markup</groupId>
      <artifactId>swagger2markup</artifactId>
      <version>1.3.3</version>
    </dependency>
```

### Spring Boot Layers Management

无侵入的引入 Swagger2 支持

#### 1. Injection Swagger2 Configuration

config.`Swagger2Config`.java

run `mvn clean spring-boot:run -Dswagger.enabled`

#### 2. Swagger2 Dev behind Reverse Proxy

run `mvn clean spring-boot:run -Dswagger.enabled -Dspringfox.documentation.swagger.v2.host=your-host/your-context`

方法2

- 配置 `application.yml`
- 访问 `http://localhost:8080/demo/swagger-ui.html`
- 请求 配置中对应的服务地址

#### 3. Injection Swagger2 Doc Generator

test.`Swagger2MarkupTest`

run `mvn test -Dswagger.enabled`

run `asciidoctor -n target/api-doc/API.adoc`

#### 4. Set ApiModelProperty for View Object