select * from employees;

create table ex01
as
select * from employees;

select * from ex01;

select table_name from user_tables;

create table ex02
as
select * from employees
where 1=2;

create table ex03
as
select * from employees
where salary>=5000;

select salary from ex03 order by 1;

create table ex04 
as
select * from employees
where salary>(select avg(salary)
from employees
where department_id = 80);

select salary from ex04 order by 1;

select *
from employees
where salary<(
select min(avg(salary)) from employees
group by job_id);

create table ex05(
    num_id varchar2(5),
    name varchar2(20)
    );
    
create table ex06
as
select * from employees;
//view생성하는 방법
create view ex07_view
as
select employee_id, emp_name, department_id,job_id
from employees;

select * from ex07_view
where department_id=80;

create view emp_idv
as
select a.employee_id,a.emp_name,a.department_id,b.department_name,a.job_id,c.job_title
from employees a, departments b, jobs c
where a.department_id=b.department_id and a.job_id=c.job_id;

select emp_name,department_name,job_title from emp_idv;

select * from employees;

create or replace view ex01_v
as
select employee_id "e_id",emp_name as e_name,hire_date,department_id "d_id",job_id,email,phone_number from employees
where hire_date>'2000/01/01' and department_id=80;

drop view ex01_v;
select * from ex01_v;

create view ex02_v
as
select employee_id "e_id",emp_name "e_name", department_id "d_id"
from employees
where salary>
(select avg(salary)
from employees);

select * from ex02_v;

drop view ex01_v;

create table doctor(
d_id varchar2(10),
d_num varchar2(10),
d_name varchar2(10),
d_address varchar2(20),
d_phone number(11),
d_job varchar2(10),
d_depart number(5)
);

create table hos_department(
dep_id number(5),
dep_name varchar2(10),
dep_phone number(11),
dep_cap varchar2(10),
constraint pk_hos_department primary key (dep_id)
);

create table chart(
char_id number(10),
char_prescipt varchar2(10),
char_main varchar2(500),
char_date date,
desease varchar2(10),
pat_id varchar2(10),
doc_id varchar2(10),
nur_id varchar2(10)
);

create table prescription(
pres_id varchar2(10),
pres_date date,
prelist_id varchar2(10)
);

create table prelist_id(
pres_id varchar2(10),
med_id varchar2(10),
med_num number(5)
);

create table medicine(
med_id varchar2(10),
med_name varchar2(10),
med_date date,
med_count number(5)
);

create table patient(
pat_id varchar2(10),
pat_name varchar2(10),
gender varchar2(10),
height number(3),
weight number(3),
pat_phone number(11),
address varchar2(20),
pat_num number(13),
par_name varchar2(10),
par_phone number(11),
charlist varchar2(10),
doc_id varchar2(10),
nur_id varchar2(10)
);

create table nurse(
nur_id varchar2(10),
nur_name varchar2(10),
nur_phone number(11),
nur_job varchar2(10),
pat_id varchar2(10)
);

insert into doctor values('a0001','00001','김김김','서울','11111111111','인턴',1);
insert into doctor values('a0002','00002','김김2','서울','11111111112','인턴',1);
insert into doctor values('a0003','00003','김김3','서울','11111111113','의사',1);
insert into doctor values('a0004','00004','김김4','서울','11111111114','의사',1);
insert into doctor values('a0005','00005','김김5','서울','11111111115','과장',1);

insert into hos_department values(1,'내과',22222222222,'a0005');

insert into chart values(33333,'p0001','abcdabcd',sysdate,'감기','p0001','d0001','n0001');

insert into patient values('p0001','환환환','남',111,99,88888888888,'서울',1212121212121,'보호자',88888888888,'','a0001','n0001');
insert into patient values('p0002','환환2','남',111,99,88888888888,'서울',1212121212121,'보호2',88888888888,'','a0002','n0002');
insert into patient values('p0003','환환3','여',111,99,88888888888,'서울',1212121212121,'보호3',88888888888,'','a0003','n0003');
insert into patient values('p0004','환환4','여',111,99,88888888888,'서울',1212121212121,'보호4',88888888888,'','a0004','n0004');
insert into patient values('p0005','환환5','남',111,99,88888888888,'서울',1212121212121,'보호5',88888888888,'','a0005','n0005');
insert into patient values('p0006','환환6','여',111,99,88888888888,'서울',1212121212121,'보호6',88888888888,'','a0003','n0003');
insert into patient values('p0007','환환7','여',111,99,88888888888,'서울',1212121212121,'보호7',88888888888,'','a0004','n0004');
insert into patient values('p0008','환환8','남',111,99,88888888888,'서울',1212121212121,'보호8',88888888888,'','a0005','n0005');

insert into nurse values('n0001','간호사1',77777777777,'간호사','p0001');
insert into nurse values('n0002','간호사2',77777777777,'간호사','p0002');
insert into nurse values('n0003','간호사3',77777777777,'간호사','p0003');
insert into nurse values('n0004','간호사4',77777777777,'간호사','p0004');
insert into nurse values('n0005','간호사5',77777777777,'간호사','p0005');

select doc_id,nur_id from patient;

select doc_id,count(doc_id) from patient group by doc_id;

select c.char_id,p.pat_id,p.pat_name,d.d_id,d.d_name,n.nur_id,n.nur_name
from chart c ,patient p, doctor d,nurse n;

create table ex01
as
select employee_id, emp_name, department_id from employees;

create table ex02
as
select employee_id, emp_name,job_id from employees;

delete ex01;

select * from ex02 order by employee_id;

reviewed 08/21/18
