DELETE FROM t_user;
INSERT INTO t_user (name, age, email) VALUES
('张三', 18, 'test1@li3huo.com'),
('李四', 20, 'test2@li3huo.com'),
('Tom', 28, 'test3@li3huo.com'),
('Sandy', 21, 'test4@li3huo.com'),
('Bob', 24, 'test5@li3huo.com');

DELETE FROM t_exam_item;
INSERT INTO t_exam_item (name, content, price, create_time, update_time) VALUES
('腹部彩色多普勒','肝、胆、脾、胰，双肾，输尿管，膀胱，前列腺（男）/子宫及附件（女）', 3000, now(), now()),
('血常规','白细胞计数（WBC）、淋巴细胞（LYM）、粒细胞、红细胞计数（RBC）', 3000, now(), now()),
('乙肝5项','乙肝表面抗原（HbsAg）、表面抗体（HbsAb）、e抗原（HbeAg）、e抗体（HbeAb）、核心抗体（HbcAb）', 3000, now(), now()),
('血脂4项','总胆固醇（TC）、甘油三酯（TG）、 高密度脂蛋白（HDL-C）、低密度脂蛋白（LDL-C）', 3000, now(), now()),
('一般检查','血压、身高、体重、体重指数', 3000, now(), now()),
('X线检查','胸部正位片', 3000, now(), now()),
('心电图','12导联心电图', 3000, now(), now()),
('内科5项','心、肺、肝、脾、神经系统', 3000, now(), now()),
('外科7项','皮肤、脊柱、四肢、甲状腺、乳房、肛门、外生殖器等', 3000, now(), now()),
('眼科4项','视力、辨色力、外眼、眼压、眼底、裂隙灯检查等', 3000, now(), now()),
('耳鼻咽喉','听力、外耳、内耳、鼻腔、鼻中膈、咽部、喉部等', 3000, now(), now()),
('其它','咱们再查点什么吧', 3000, now(), now());


