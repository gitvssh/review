select table_name from user_tables;

select * from employees;

select abs(-10), abs(10) from dual;

select * from sales;

select trunc(amount_sold,-1) from sales;
//mod
select mod(11,2) from dual;

select employee_id from employees where mod(employee_id,2)=1;
select employee_id, 
case when mod(employee_id,2)=1 then '홀수'
when mod(employee_id,2)=0 then '짝수'
end "홀비", emp_name from employees;

select * from employees where emp_name = 'William Smith';
//대소문자 구별 X
select * from employees where lower(emp_name) = 'william smith';
select * from employees where upper(emp_name) = 'WILLIAM SMITH';
select initcap(emp_name) from employees where upper(emp_name) = 'WILLIAM SMITH';
//문자열 동시출력
select concat('ezen','academy'),'Happy'||'birthday to you'from dual;
select concat(emp_name,email) from employees;
select emp_name||' + '||email||' + '||employee_id "이름이랑 이메일 동시출력" from employees;

create table ex01(
    id varchar2(10),
    f_name varchar2(10),
    l_name varchar2(10),
    sex varchar2(4),
    tel1 varchar2(3),
    tel2 varchar2(4),
    tel3 varchar2(4),
    birth number(8),
    address varchar2(30)
);

insert into ex01 values('a001','이','순신','남','010','1111','1111',19880101,'서울');
insert into ex01 values('a002','유','관순','여','010','2222','2222',19780401,'부산');
insert into ex01 values('a003','김','유신','남','010','3333','3333',19680701,'경주');
insert into ex01 values('a004','최','영희','여','010','4444','4444',19981001,'광주');
insert into ex01 values('a005','안','창호','남','010','5555','5555',20000201,'대전');

select * from ex01;

select concat(f_name,l_name) "풀네임",tel1||'-'||tel2||'-'||tel3 "전화번호" from ex01;
select substr(birth,5,2) from ex01;

select concat(f_name,l_name) "name", birth as birth, substr(birth,5,2) "태어난 달", 
case when substr(birth,5,2) in(12,01,02) then '겨울'
when substr(birth,5,2) = any(03,04,05) then '봄'
when substr(birth,5,2) = some(06,07,08) then '여름'
else '가을'
end "계절" from ex01;

select * from employees;

select email from employees where substr(hire_date,4,2)='03';
//ltrim
select rtrim('abcdeghabc','abc') from dual;
select rtrim('    abcdefg       ') from dual;
select trim('    abcd  efg       ') from dual;