create table tb_camera (id  bigserial not null, name varchar(255), protocolo integer, primary key (id));
create table tb_canal (id  bigserial not null, descricao TEXT, numero integer,  primary key (id));
create table tb_camera_canal (camera_id int8 not null, canal_id int8 not null, primary key (camera_id, canal_id));
alter table tb_camera_canal add constraint FK5r4sbavb4nkd9xpl0f095qs2a foreign key (camera_id) references tb_camera;
alter table tb_camera_canal add constraint FKgbof0jclmaf8wn2alsoexxq3u foreign key (canal_id) references tb_canal;

INSERT INTO tb_canal (numero, descricao) VALUES (1, 'Canal Adm');
INSERT INTO tb_canal (numero, descricao) VALUES (2, 'Canal Salão');
INSERT INTO tb_canal (numero, descricao) VALUES (3, 'Canal RH');

INSERT INTO tb_camera (nome, protocolo) VALUES ('Câmera Adm 1', 1983564870);
INSERT INTO tb_camera (nome, protocolo) VALUES ('Câmera Adm 2', 1983564871);
INSERT INTO tb_camera (nome, protocolo) VALUES ('Câmera Salão 1', 1983564880);
INSERT INTO tb_camera (nome, protocolo) VALUES ('Câmera Salão 2', 1983564881);
INSERT INTO tb_camera (nome, protocolo) VALUES ('Câmera Rh 1', 1983564890);
INSERT INTO tb_camera (nome, protocolo) VALUES ('Câmera Rh 2', 1983564891);

INSERT INTO tb_camera_canal (camera_id, canal_id) VALUES (1, 1);
INSERT INTO tb_camera_canal (camera_id, canal_id) VALUES (2, 1);
INSERT INTO tb_camera_canal (camera_id, canal_id) VALUES (3, 2);
INSERT INTO tb_camera_canal (camera_id, canal_id) VALUES (4, 2);
INSERT INTO tb_camera_canal (camera_id, canal_id) VALUES (5, 3);
INSERT INTO tb_camera_canal (camera_id, canal_id) VALUES (6, 3);