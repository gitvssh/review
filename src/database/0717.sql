select * from employees 
where substr(hire_date,4,2)=substr(add_months(sysdate,2),4,2);

select next_day(sysdate,'일요일') from dual;

select hire_date, next_day(hire_date,'일요일') "다음일요일" from employees;
select hire_date, last_day(hire_date) "마지막날" from employees;
select floor(salary/to_number(substr(last_day(sysdate),7,2))) "일당" from employees;

select to_date('22/11/21')-sysdate "1" from dual;

select sysdate-hire_date "근무일수" from employees;
select months_between(sysdate,hire_date) "근무월수" from employees;

create table membership(
    mem_id varchar2(10),
    name1 varchar2(10),
    name2 varchar2(10),
    phone1 varchar2(3),
    phone2 varchar2(4),
    phone3 varchar2(4),
    tel varchar2(9),
    gender varchar2(10),
    address varchar2(20),
    hobby varchar2(10),
    mem_date date,
    birth date
);

insert into membership values('a0001','이','순신','010','1111','1111','1234-1234','남','서울','책보기',sysdate,to_date('2000/12/31'));
insert into membership values('a0002','유','관순','010','2222','2222','2345-2345','여','경기','운동',sysdate,to_date('1999/03/01'));
insert into membership values('a0003','김','유신','010','3333','3333','3456-3456','남','경주','말타기',sysdate,to_date('1988/07/17'));
insert into membership values('a0004','안','창호','010','4444','4444','4567-4567','남','광주','사격',sysdate,to_date('1977/09/20'));
insert into membership values('a0005','최','영희','010','5555','5555','5678-5678','여','대전','여행',sysdate,to_date('2001/01/30'));

select * from membership;

update membership set name1='최' where mem_id='a0001';

select mem_id, name1||name2 "이름", phone1||'-'||phone2||'-'||phone3 "휴대폰번호" from membership
where gender='남' and substr(birth,4,2)='07';

select mem_id, name1||name2 "이름",
case when address='서울' then lpad(phone1,6,'02-')||'-'||phone2||'-'||phone3
when address='경기' then lpad(phone1,7,'031-')||'-'||phone2||'-'||phone3
when address='경주' then lpad(phone1,7,'053-')||'-'||phone2||'-'||phone3
when address='광주' then lpad(phone1,7,'041-')||'-'||phone2||'-'||phone3
else lpad(phone1,7,'063-')||'-'||phone2||'-'||phone3
end "전화번호"
from membership;

select to_char(12345,'$999,9999,9999') from dual;
select * from employees;
select to_char(salary*(1+nvl(commission_pct,0)),'$999,999,999,999') from employees;
select to_char(sysdate,'yyyy.mm.dd hh24:mi:ss day') from dual;
select to_char(sysdate,'yyyy:month-day') from dual;
select to_char(hire_date,'yyyy/mm/dd hh24:mi:ss day') from employees;
select '&22' from dual;

select to_char(to_date('20/7/24'),'day') from dual;

select to_number('123456') from dual;

select employee_id, emp_name,
case when manager_id is not null then to_char(manager_id)
else 'ceo'
end "manager_id"
from employees;

select employee_id,
nvl2(commission_pct,salary*(1+commission_pct)||'++',salary)
from employees;

select mem_id, name1||name2 "이름",
case when address='서울' then lpad(replace(tel,'-','.'),12,'02)')
when address='경기' then lpad(replace(tel,'-','.'),13,'031)')
when address='경주' then lpad(replace(tel,'-','.'),13,'053)')
when address='광주' then lpad(replace(tel,'-','.'),13,'041)')
else lpad(replace(tel,'-','.'),13,'063)')
end "전화번호"
from membership;

select * from customers;

select  from customers;

select cust_name, cust_year_of_birth, 
case when to_char(sysdate,'yyyy')-cust_year_of_birth<40 then '30대'
when to_char(sysdate,'yyyy')-cust_year_of_birth<50 then '40대'
when to_char(sysdate,'yyyy')-cust_year_of_birth<60 then '50대'
else '60대 이상'
end "연령대"
from customers;

select greatest(1,2,3,4,5) from dual;
select least(1,2,3,4,5) from dual;

select * from sales;

select * from employees order by department_id;

select department_id,count(department_id) from employees 
group by department_id
order by department_id;

select count(distinct manager_id) from employees;
//합계
select to_char(sum(salary)/11,'l999,999,999,999')||'만원' "변수" from employees;
//평균
select to_char(avg(salary)/11,'l999,999,999,999')||'만원' "변수" from employees;
select * from kor_loan_status;
select region, sum(loan_jan_amt) from kor_loan_status group by region;
select period, sum(loan_jan_amt) from kor_loan_status group by period;

select period,region, sum(loan_jan_amt)
from kor_loan_status
where period like '2013%'
group by period,region;

select a.manager_id,b.emp_name,sum(a.salary) "관리 월급", round(avg(a.salary),1) "평균"
from employees a, employees b
where a.manager_id=b.employee_id
group by a.manager_id,b.emp_name
order by sum(a.salary);

select * from sales;

select period, sum(loan_jan_amt) from kor_loan_status
group by period;
//min 최소값 반환 함수
select min(salary),max(salary) from employees;
select min(loan_jan_amt),max(loan_jan_amt) from kor_loan_status;

select period,region, max(loan_jan_amt) from kor_loan_status
group by period, region
order by max(loan_jan_amt);

select * from kor_loan_status
order by loan_jan_amt;

select department_id,max(avg(salary)) "부서평균급여" from employees
group by department_id;

select job_id, sum(salary) "월급합계"
from employees
group by job_id;

select department_id,sum(salary) from employees
where hire_date>to_date('00/01/01')
group by department_id;

select department_id,sum(salary) from employees
group by department_id;

select * from kor_loan_status;

select period, region,sum(loan_jan_amt)
from kor_loan_status
where period like '2011%'
group by period,region
order by region;

select job_id, sum(salary)
from employees
where substr(hire_date,4,2) between '07' and '12'
group by job_id
order by sum(salary);

select * from employees
where lower(emp_name) like '%e%';

select department_id,to_char(sum(salary*(1+nvl(commission_pct,0))),'$999,999,999,999') "합계",
to_char(avg(salary*(1+nvl(commission_pct,0))),'$999,999,999,999') "평균",
to_char(max(salary*(1+nvl(commission_pct,0))),'$999,999,999,999') "최대",
to_char(min(salary*(1+nvl(commission_pct,0))),'$999,999,999,999') "최소"
from employees
where to_char(hire_date,'yyyy') between'1998' and '2000'  and department_id is not null
group by department_id;

select distinct job_id
from employees
where to_char(hire_date,'yyyy') between'1998' and '2000'  and department_id is not null;

reviewed 08/14/18
