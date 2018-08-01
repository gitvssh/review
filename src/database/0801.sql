create table member(
M_id varchar2(12),
M_password varchar2(16),
m_name varchar2(20),
m_birth number(8),
m_sex varchar2(2),
m_phonenum number(11),
m_event varchar2(20)
);


insert into member values('a0001','123123123','이순신',880101,'남',11111111111,'이벤트');
insert into member values('a0002','123123123','이순신2',880102,'여',11111111111,'이벤트');
insert into member values('a0003','123123123','이순신3',880103,'남',11111111111,'이벤트');
insert into member values('a0004','123123123','이순신4',880104,'여',11111111111,'이벤트');
insert into member values('a0005','123123123','이순신5',880105,'남',11111111111,'이벤트');