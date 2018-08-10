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
select ltrim('010-1111-1111',0) from dual;
//자리수만큼, 문자열 추가, 반복
select lpad(tel1,7,'0') from ex01;
desc ex01;
select * from ex01;
alter table ex01 add fax varchar2(9);
insert into ex01(fax) values('1111-1111');
update ex01 set fax='5555-5555' where id='a005';

create table ex02(
mem_id varchar2(10), 
mem_name varchar2(20), 
gender varchar2(10), 
phone varchar2(10), 
birth number(8), 
address varchar2(20), 
fax varchar2(9)
);

insert into ex02(mem_id, mem_name, gender, phone, birth, address, fax)
select id,f_name||l_name,sex,tel1||'-'||tel2||'-'||tel3, birth, address, fax from ex01;

alter table ex02 modify phone varchar2(15);

select * from ex02;
select mem_id, mem_name, gender, phone, birth, address,
case when address='서울' then lpad(fax,13,'(02)')
when address='부산' then lpad(fax,14,'(051)')
when address='경주' then lpad(fax,14,'(052)')
when address='광주' then lpad(fax,14,'(041)')
else lpad(fax,14,'(053)')
end 
from ex02;

select mem_id,mem_name,address,
case when address='서울' then '당첨'
else '꽝'
end as event
from ex02;

select replace('나는 너를 모르는데 너는 나를 알겟는가?','나','너') "1" from dual;

select replace(mem_name,'이','김') from ex02;

select * from employees;

select replace(lower(emp_name),'m','aa') "변경" from employees;

select trim('        a      bbb      ') from dual;
select replace('    a  b    ',' ','') from dual;

select replace(upper(emp_name),' ','') from employees;

select replace(phone_number,'.','-') "phone", translate(hire_date,'/','-') from employees;

select replace(job_id,'st_clerk','sm_clerk') from employees;

select a.employee_id,a.job_id,b.job_title,
case when lower(a.job_id)='st_man' then concat(a.email,'@st.com')
when lower(a.job_id)='mk_rep' then concat(a.email,'@mk.com')
when lower(a.job_id)='sa_man' then concat(a.email,'@sa.com')
else concat(a.email,'@ssg.com')
end "email"
from employees a, jobs b where a.job_id=b.job_id;

select instr('내가 만약 외로울 때면, 내가 만약 괴로울 때면, 내가 만약 즐거울 때면','만약',5,2) as i01 from dual;
select length('대한민국') from dual;

select a.employee_id, a.job_id, b.job_title, a.email,
case when lower(a.job_id)='st_man' then rpad(a.email,length(a.email)+7,'@st.com')
when lower(a.job_id)='mk_rep' then rpad(a.email,length(a.email)+7,'@mk.com')
when lower(a.job_id)='sa_man' then rpad(a.email,length(a.email)+7,'@sa.com')
else rpad(a.email,length(a.email)+8,'@ssg.com')
end "@email"
from employees a, jobs b
where a.job_id=b.job_id;

select sysdate,systimestamp from dual

select (sysdate-hire_date)/365 "총근무일수" from employees;

select 'D-day : '||floor((to_date('22/11/22')-sysdate)) from dual;
select add_months(sysdate,1) "다음달",sysdate "이번달", add_months(sysdate,-1)"지난달" from dual;

select hire_date, add_months(hire_date,1) from employees;
select trunc(months_between(sysdate,hire_date),-1) from employees;

select months_between(to_date('22/02/04'),sysdate) from dual;
select last_day(sysdate) from dual;

select ceil(months_between(sysdate,hire_date))*salary "현재까지 받은 월급" from employees;
select * from employees;

select case when floor(months_between(sysdate,hire_date)/12)<=10 then salary*floor(months_between(sysdate,hire_date))
when floor(months_between(sysdate,hire_date)/12)<=15 then salary*floor(months_between(sysdate,hire_date))
else salary*ceil(months_between(sysdate,hire_date))
end "100% 월급"
,floor(months_between(sysdate,hire_date)/12) "근속년수"
,case when floor(months_between(sysdate,hire_date)/12)<=10 then salary*0.94*floor(months_between(sysdate,hire_date))
when floor(months_between(sysdate,hire_date)/12)<=15 then salary*0.97*floor(months_between(sysdate,hire_date))
else salary*floor(months_between(sysdate,hire_date))
end "총 월급"
from employees;

commit;

reviewd 08/10/18
