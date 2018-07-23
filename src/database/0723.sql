select * from exp_goods_asia
order by seq;

select goods
from exp_goods_asia
where country = '한국'
minus
select goods
from exp_goods_asia
where country = '일본';

select * from exp_goods_asia;
desc kor_loan_status;

select period, gubun, sum(loan_jan_amt)
from kor_loan_status
where period like '2013%'
group by rollup(period, gubun);

select a.department_id,b.department_name,sum(a.salary)
from employees a,departments b
where a.department_id=b.department_id
group by a.department_id,b.department_name;

select a.department_id "부서번호",b.department_name "부서명",to_char(a.hire_date,'yyyy') "입사년도",sum(a.salary) "합계"
from employees a,departments b
where a.department_id=b.department_id
group by a.department_id,b.department_name,rollup(to_char(a.hire_date,'yyyy'));


select a.department_id "부서번호",b.department_name "부서명",to_char(a.hire_date,'yyyy') "입사년도",avg(a.salary) "평균"
from employees a,departments b
where a.department_id=b.department_id
group by a.department_id,b.department_name,rollup(to_char(a.hire_date,'yyyy'));

select a.department_id "부서번호", b.department_name "부서명", avg(salary)
from employees a, departments b
where a.department_id=b.department_id
group by a.department_id, b.department_name
having avg(salary)=(select max(avg(salary))
from employees
group by department_id);

select avg(avg(salary))
from employees
group by department_id;

select a.department_id "부서번호", b.department_name "부서명", avg(salary)
from employees a, departments b
where a.department_id=b.department_id
group by a.department_id, b.department_name
having avg(salary)>=(select avg(avg(salary))
from employees
group by department_id);

desc kor_loan_status;

select period, region, sum(loan_jan_amt)
from kor_loan_status
group by period, region
having sum(loan_jan_amt)=
(select max(sum(loan_jan_amt))
from kor_loan_status
group by period,region);

select min(sum(loan_jan_amt))
from kor_loan_status
group by region;

select distinct a.department_id, b.department_name
from employees a, departments b
where a.salary>3000 and a.department_id=b.department_id;

select a.department_id, a.department_name
from departments a
where exists(select * from employees b where a.department_id=b.department_id and b.salary>3000);

select emp_name, salary
from employees
where salary>any
(select min(salary)
from employees
where department_id=30);

select a.employee_id,a.emp_name,a.department_id,b.department_name
from employees a, departments b
where a.department_id not in(select department_id from departments where manager_id is null) and a.department_id = b.department_id
order by employee_id;

select * from employees where manager_id is null;

select a.employee_id, a.emp_name, a.manager_id, b.emp_name
from employees a, employees b
where a.manager_id = b.employee_id;

select a.department_id,a.department_name,b.job_id, b.department_id
from departments a, job_history b
where a.department_id=b.department_id(+);

create table ex01(
    subject varchar2(20),
    score number(3)
);

create table ex02(
    subcode varchar2(20),
    score number(3)
);

insert into ex01 values('국어',100);
insert into ex01 values('영어',100);
insert into ex01 values('수학',100);

insert into ex02 values('b0001',5);
insert into ex02 values('b0002',5);
insert into ex02 values('b0003',5);

commit;

select distinct(department_id) from employees
order by department_id;

select department_id from departments;

select a.employee_id,a.emp_name, a.department_id, b.department_name
from employees a, departments b
where a.department_id(+)=b.department_id;

select a.employee_id, a.emp_name, a.job_id, b.department_id
from employees a, job_history b
where a.job_id=b.job_id(+);

select a.employee_id, a.emp_name, a.department_id, b.department_name
from employees a
inner join departments b on(a.department_id=b.department_id)
where a.hire_date >'03/01/01' and a.department_id=b.department_id;

select a.employee_id, a.emp_name, job_id, b.job_title
from employees a
inner join jobs b
using(job_id)
;

select a.employee_id, a.emp_name, department_id, b.department_name, a.salary
from employees a
inner join departments b
using(department_id)
where 12000>=a.salary and a.salary>=9000;

select a.employee_id, a.emp_name, a.department_id, b.department_name, a.salary
from employees a, departments b
where a.department_id=b.department_id and a.salary between 9000 and 12000;

select department_id, a.department_name, avg(b.salary)
from departments a
inner join employees b
using(department_id)
group by department_id, a.department_name
having avg(b.salary)=(
select max(avg(salary))
from employees
group by department_id);


select a.department_id, a.department_name, b.job_id, b.department_id
from departments a
left outer join job_history b
on(a.department_id=b.department_id);

select a.employee_id,a.emp_name,a.job_id,department_id
from employees a
right outer join departments
using(department_id);