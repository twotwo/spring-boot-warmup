DROP TABLE IF EXISTS t_user;
DROP TABLE IF EXISTS t_exam_item;
DROP TABLE IF EXISTS t_order;
DROP TABLE IF EXISTS t_order_item;
DROP TABLE IF EXISTS t_checklist;

CREATE TABLE t_user
(
	id BIGINT AUTO_INCREMENT COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
	PRIMARY KEY (id)
);

CREATE TABLE t_exam_item (
    id BIGINT AUTO_INCREMENT COMMENT '主键ID',
    create_time TIMESTAMP COMMENT '创建时间',
    update_time TIMESTAMP COMMENT '更新时间',
    name VARCHAR(255) NOT NULL COMMENT '体检项目名称',
		content VARCHAR(512) NOT NULL COMMENT '具体内容',
    price BIGINT DEFAULT 0 COMMENT '项目费用',
    PRIMARY KEY (id)
) COMMENT '体检项目表';

create table t_order (
    id BIGINT AUTO_INCREMENT COMMENT '主键ID',
    create_time TIMESTAMP COMMENT '创建时间',
    update_time TIMESTAMP COMMENT '更新时间',
    patient VARCHAR(255) NOT NULL COMMENT '检查者',
    total BIGINT DEFAULT 0 COMMENT '订单费用',
    state TINYINT NOT NULL COMMENT '订单状态，详见enums.OrderState',
    PRIMARY KEY (id)
) COMMENT '体检订单表';

create table t_order_item (
    order_id BIGINT NOT NULL COMMENT '外键-订单ID',
    item_id BIGINT NOT NULL COMMENT '外键-体检项目ID'
) COMMENT '体检订单项目表';

create table t_checklist (
    order_id BIGINT NOT NULL COMMENT '外键-订单ID',
    item_id BIGINT NOT NULL COMMENT '外键-体检项目ID',
    check_time TIMESTAMP COMMENT '检查时间',
		doctor VARCHAR(255) COMMENT '检查医生',
		record VARCHAR(512) COMMENT '检查记录',
		state TINYINT COMMENT '项目检查状态，'
) COMMENT '体检检查单';