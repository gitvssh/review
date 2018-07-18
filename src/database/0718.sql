create table h_order(
    o_num varchar2(5),
    o_date date,
    sale number(5,2),
    pay number(7),
    m_pay varchar2(10)

);

create table m_add(
    o_num varchar2(5),
    m_num varchar2(5),
    amout number(3),
    m_money number(7)
);

create table menu(
    m_num varchar2(5),
    m_name varchar2(16)
);

insert into h_order values('a0001',sysdate,0,10000,'카드');
insert into h_order values('a0002',sysdate,0.1,4500,'카드');
insert into h_order values('a0003',sysdate,0,5000,'카드');

insert into m_add values('a0001','1',1,5000);
insert into m_add values('a0001','2',1,5000);
insert into m_add values('a0002','1',1,5000);
insert into m_add values('a0003','3',1,5000);

insert into menu values('1','와퍼세트');
insert into menu values('2','크런치치킨');
insert into menu values('3','칠리치즈버거');

alter table menu add(vat number(3,2));
update menu set vat=0.1;
select * from menu;
desc menu;
alter table m_add rename column amout to amount;
alter table m_add modify m_num varchar2(10);

select a.o_num,c.m_num,b.m_name,c.amount 
from h_order a,menu b,m_add c
where a.o_num=c.o_num and b.m_num=c.m_num
;