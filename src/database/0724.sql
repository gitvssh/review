select a.department_id, a.department_name, avg(b.salary)
from departments a,employees b
where a.department_id=b.department_id
group by a.department_id,a.department_name
having avg(b.salary)=(
select max(avg(salary))
from employees
group by department_id)
;

select a.department_id, a.department_name, avg(b.salary)
from departments a
inner join employees b
on(a.department_id=b.department_id)
group by a.department_id,a.department_name
having avg(b.salary)=(
select max(avg(salary))
from employees
group by department_id)
;

select a.employee_id, a.emp_name, department_id, b.department_name
from employees a
inner join departments b
using(department_id)
where hire_date>'2003/01/01';

select department_id, a.department_name, sum(b.salary)
from departments a
inner join employees b
using(department_id)
where emp_name like '%e%' or emp_name like '%o%'
group by department_id, a.department_name
having sum(b.salary)=(
select max(sum(salary))
from employees
where emp_name like '%e%' or emp_name like '%o%'
group by department_id)
;

select department_id, a.department_name, sum(b.salary)
from departments a
inner join employees b
using(department_id)
group by department_id, a.department_name;

select max(sum(salary))
from employees
where emp_name like '%e%' or emp_name like '%o%'
group by department_id;

select a.employee_id, a.emp_name,a.department_id, b.job_id, b.department_id
from employees a
left outer join job_history b
on( a.employee_id = b.employee_id
and a.department_id = b.department_id);

select distinct department_id from employees;
//카타시안 조인, 크로스 조인
select a.employee_id, a.emp_name, a.department_id, b.department_name
from employees a
cross join departments b
order by 1;

create table ex01(
    exp_id number(2)
);
create table ex02(
    exp_id number(2)
);
insert into ex01 values(10);
insert into ex01 values(20);
insert into ex01 values(40);

insert into ex02 values(10);
insert into ex02 values(20);
insert into ex02 values(30);

select * from ex02;

commit;
//내부조인
select a.exp_id, b.exp_id
from ex01 a, ex02 b
where a.exp_id=b.exp_id;
//안시조인
select a.exp_id, b.exp_id
from ex01 a
left join ex02 b
on(a.exp_id=b.exp_id);

select employee_id, emp_name,job_id, salary
from employees
where salary>(
select salary from employees
where lower(emp_name) like '%tucker%');

select a.employee_id, a.emp_name,department_id, b.department_name, a.job_id, a.salary
from employees a
left join departments b
using(department_id)
where a.salary>(
select avg(salary)
from employees)
minus
select a.employee_id, a.emp_name,a.department_id, b.department_name, a.job_id, a.salary
from employees a, departments b
where a.department_id=b.department_id and a.salary>(
select avg(salary)
from employees);

select a.employee_id, a.emp_name,department_id, b.department_name, a.job_id, a.salary
from employees a
left join departments b
using(department_id)
where a.salary>(
select avg(a.salary)
from employees a,departments b
where a.department_id=b.department_id and b.department_name = '경리부');

commit;

select employee_id,salary from employees;

rollback;

alter table ex01 modify exp_id number(6);

desc ex01;

commit;

savepoint aaa1;

update ex01 set exp_id = (select employee_id from employees where lower(emp_name) like '%tucker%');

select * from ex01;

rollback;

update ex01 set exp_id = 100;

savepoint aaa2;

update ex01
set exp_id = 200;

select * from employees;

select employee_id, emp_name, department_id
from employees
where department_id in(
select department_id
from employees
group by department_id
having avg(salary)>10000
);

select employee_id, emp_name, department_id
from employees
where lower(job_id) not like '%clerk%' and department_id in(
select department_id
from employees
group by department_id
having avg(salary)>4000);

//job_history에 department_id가 있는 부서의 이름