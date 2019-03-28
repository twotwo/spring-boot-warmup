package com.example.demo.config;

import com.google.common.collect.Lists;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2Config
 * 
 * <a href="https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api">Setting Up Swagger
 * 2 with a Spring REST API</a>
 */
@Configuration
@EnableSwagger2
@ConditionalOnExpression("'${swagger.enabled}' == 'true'")
public class Swagger2Config {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.example.demo.web"))
        .paths(PathSelectors.regex("/.*")).build().useDefaultResponseMessages(false)
        .globalResponseMessage(RequestMethod.POST,
            Lists.newArrayList(new ResponseMessageBuilder().code(500).message("内部服务错误").build(),
                new ResponseMessageBuilder().code(400).message("请求格式错误").build()));
  }

  @Bean
  UiConfiguration uiConfig() {
    return UiConfigurationBuilder.builder().deepLinking(true).displayOperationId(false)
        .defaultModelsExpandDepth(1).defaultModelExpandDepth(1)
        .defaultModelRendering(ModelRendering.EXAMPLE).displayRequestDuration(false)
        .docExpansion(DocExpansion.NONE).filter(false).maxDisplayedTags(null)
        .operationsSorter(OperationsSorter.ALPHA).showExtensions(false).tagsSorter(TagsSorter.ALPHA)
        .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS).validatorUrl(null)
        .build();
  }
}
