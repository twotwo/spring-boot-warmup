package sb.warmup.neo4j.yaml;

import java.io.IOException;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义yaml文件资源加载类
 */
@Slf4j
public class YamlPropertySourceFactory extends DefaultPropertySourceFactory {

  @Override
  public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {

    if (resource == null) {
      super.createPropertySource(name, resource);
    }
    log.warn("resource={}", resource.getResource().getURI());
    return new YamlPropertySourceLoader().load(resource.getResource().getFilename(), resource.getResource(), null);
  }

}