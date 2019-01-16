-- -----------------------------------------------------
-- Table `sb-db`.`sb_customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sb-db`.`sb_customer` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` VARCHAR(64) NOT NULL COMMENT '卡片名称',
  `email` VARCHAR(64) NOT NULL COMMENT '邮件地址',
  `phone` VARCHAR(64) NULL COMMENT '电话号码',
  `description` TEXT NULL COMMENT '信息描述',
  `create_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;