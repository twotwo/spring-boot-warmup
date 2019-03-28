package com.example.demo;

import java.net.URL;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import io.swagger.config.SwaggerConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {App.class, SwaggerConfig.class},
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class Swagger2MarkupTest {
	public static final String API_DIR = "http://localhost:8080/v2/api-docs";
	public static final String DOC_DIR = "./target/api-doc";

	@Test
	public void genAsciiDocs() throws Exception {
		// 输出Ascii格式
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withMarkupLanguage(MarkupLanguage.ASCIIDOC).withOutputLanguage(Language.EN)
				.withPathsGroupedBy(GroupBy.TAGS).withGeneratedExamples().withoutPathSecuritySection()
				.withInterDocumentCrossReferences().build();

		Swagger2MarkupConverter.from(new URL(API_DIR)).withConfig(config).build()
				.toFile(Paths.get(DOC_DIR + "/API"));
	}

	@Test
	public void genMarkdownFile() throws Exception {
		// 输出Markdown到单文件
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withMarkupLanguage(MarkupLanguage.MARKDOWN).withOutputLanguage(Language.ZH)
				.withPathsGroupedBy(GroupBy.TAGS).withGeneratedExamples().withoutInlineSchema().build();

		Swagger2MarkupConverter.from(new URL(API_DIR)).withConfig(config).build()
				.toFile(Paths.get(DOC_DIR + "/API"));
	}

}
