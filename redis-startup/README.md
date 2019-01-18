# Spring Boot 集成 Redis

- [Spring Boot Doc -> 30.1 Redis](https://docs.spring.io/spring-boot/docs/1.5.19.RELEASE/reference/html/boot-features-nosql.html#boot-features-redis)
- [Spring Boot Doc -> 31.1. Supported cache providers](https://docs.spring.io/spring-boot/docs/1.5.19.RELEASE/reference/html/boot-features-caching.html#boot-features-caching-provider-redis)
- [Spring Data Redis](https://docs.spring.io/spring-data/data-redis/docs/1.8.18.RELEASE/reference/html/)
- [Sample Code 1](https://github.com/spring-projects/spring-boot/tree/v1.5.19.RELEASE/spring-boot-samples/spring-boot-sample-data-redis)
- [Sample Code 2](https://github.com/JeffLi1993/springboot-learning-example/tree/master/springboot-mybatis-redis)

## Redis 配置访问方式

### 注解方式

- `src/main/resources/application.properties` Redis 配置

## 初始化Redis

### Docker

- [Docker Hub -> redis](https://hub.docker.com/_/redis)

```bash
docker pull redis:5.0
docker run -d --name redis -p 6379:6379 redis:5.0
docker exec -it redis bash
```

```bash
➜  redis-startup git:(master) ✗ redis-cli keys  "warmup:*"
1) "warmup:redis.test"
```

## API

### Spring Data Redis

- [Spring Data Redis 1.8.18.RELEASE API](https://docs.spring.io/spring-data/data-redis/docs/1.8.18.RELEASE/api/)
