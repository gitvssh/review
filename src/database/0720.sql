select employees.employee_id, employees.department_id, departments.department_name
from employees, departments
where employees.department_id(+) = departments.department_id
order by employees.employee_id;

select  a.employee_id,a.department_id,department_name,a.job_id,job_title
from employees a, departments b, jobs c
where a.department_id=b.department_id and a.job_id=c.job_id
order by a.employee_id;

select department_id,department_name
from departments a
where exists
(select * from employees b
where b.salary>3000 and a.department_id=b.department_id);

select department_id,department_name
from departments a
where exists(
select * from employees b
where a.department_id=b.department_id and b.salary>(
select avg(salary)
from employees));

select department_id, department_name
from departments a
where a.department_id in(select b.department_id
from employees b
where b.salary>3000);
