create table ex01(
    ex_num number(5),
    ex_id varchar2(20),
    ex_name varchar2(20)
);

desc ex01;

select table_name from user_tables;

insert into ex01 values(5,'id','ÀÌ½ÂÇö');
insert into ex01 values(5,'id','ÀÌÁö¼ö');
insert into ex01 values(5,'id','±è°ÇÁÖ');

select * from ex01;

alter table ex01 add(ex_con number(10));

alter table ex01 drop(ex_con);

create sequence myseq
start with 0
increment by 1
minvalue 0
maxvalue 100
nocycle
nocache;

reviewed 09/03/18
