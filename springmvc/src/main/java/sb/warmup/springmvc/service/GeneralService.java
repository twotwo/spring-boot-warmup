package sb.warmup.springmvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import sb.warmup.springmvc.domain.Template;

import com.alibaba.fastjson.JSON;

/**
 * GeneralService
 */
@Service
public class GeneralService {
  private static Logger LOGGER = LoggerFactory.getLogger(GeneralService.class);

  Map<String, Template> templates = new HashMap<String, Template>();

  public GeneralService() {
    Resource resource = new ClassPathResource("template.json");
    try {
      List<Template> list = JSON.parseArray(stearmToString(resource.getInputStream()), Template.class);
      for (Template t : list) {
        templates.put(t.getKeyword(), t);
      }
    } catch (IOException e) {
      // e.printStackTrace();
    }
    LOGGER.info("load template = {}", templates.size());
  }

  /**
   * Stream to String
   * 
   * @param input
   * @return
   */
  public String stearmToString(InputStream input) throws IOException {
    BufferedReader reader = null;
    StringBuffer sb = new StringBuffer();
    try {
      InputStreamReader inputStreamReader = new InputStreamReader(input, "UTF-8");
      reader = new BufferedReader(inputStreamReader);
      String str = null;
      while ((str = reader.readLine()) != null) {
        sb.append(str);
      }
      reader.close();
    } catch (IOException e) {
      throw e;
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return sb.toString();
  }

  public Template getTemplate(String keyword) {
    return templates.get(keyword);
  }

}