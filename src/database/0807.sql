select * from employees a
where salary>=(select b.salary from employees b
where b.hire_date between '98/01/01' and '01/12/31' and a.employee_id= b.employee_id );