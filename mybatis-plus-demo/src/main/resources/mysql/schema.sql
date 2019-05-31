DROP TABLE IF EXISTS t_user;
DROP TABLE IF EXISTS t_exam_item;
DROP TABLE IF EXISTS t_order;
DROP TABLE IF EXISTS t_order_item;

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
    create_time TIMESTAMP,
    update_time TIMESTAMP,
    name VARCHAR(255) COMMENT '体检项目名称',
		content VARCHAR(512) COMMENT '具体内容',
    price BIGINT,
    PRIMARY KEY (id)
);

create table t_order (
    id BIGINT AUTO_INCREMENT COMMENT '主键ID',
    create_time TIMESTAMP,
    update_time TIMESTAMP,
    patient VARCHAR(255),
    total BIGINT,
    state TINYINT COMMENT '订单状态，详见enums.OrderState',
    PRIMARY KEY (id)
);

create table t_order_item (
    order_id bigint not null COMMENT '外键-订单ID',
    item_id bigint not null COMMENT '外键-体检项目ID',
		doctor VARCHAR(255) COMMENT '检查医生',
		record VARCHAR(512) COMMENT '检查记录',
		state TINYINT COMMENT '项目检查状态，',
);