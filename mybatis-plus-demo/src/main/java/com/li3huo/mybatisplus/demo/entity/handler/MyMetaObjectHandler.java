package com.li3huo.mybatisplus.demo.entity.handler;

import java.util.Date;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * MyMetaObjectHandler
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
  @Override
  public void insertFill(MetaObject metaObject) {
      log.info("start insert fill ....");
      this.setFieldValByName("create_time", new Date(), metaObject);
  }

  @Override
  public void updateFill(MetaObject metaObject) {
      log.info("start update fill ....");
      this.setUpdateFieldValByName("update_time", new Date(), metaObject);
  }
  
}