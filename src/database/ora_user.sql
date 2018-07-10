create table board(
    board_num number(5),
    board_title varchar2(20),
    board_writer varchar2(30),
    board_contents varchar2(500),
    board_date date
);

insert into board values (myseq1.nextval,'a01','author1','con1',sysdate);
insert into board values (myseq1.nextval,'a02','author2','con2',sysdate);
insert into board values (myseq1.nextval,'a03','author3','con3',sysdate);

select * from board;

commit;

create sequence myseq1
start with 1
increment by 1
minvalue 1
maxvalue 100
nocycle
nocache;

