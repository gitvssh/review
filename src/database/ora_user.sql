create table result(
    stu_id number(3),
    stu_name varchar2(20),
    kor number(3),
    eng number(3),
    math number(3),
    ave number(3,2),
    total number(3),
    rank number(3)
);

//입력시 빈공백, number 자리수
insert into result(stu_id,stu_name,kor,eng,math,ave,total,rank) values(1,'홍길동',80,80,80,(80+80+80)/3,80+80+80,'');

//desc 오름차순, order by default 내림차순(asc)
select * from employees order by employee_id desc;

commit;

//where 조건
select * from employees where employee_id>150 and salary>8300;

select * from employees where salary=9500 order by employee_id;

select * from employees where salary>10000 and department_id=80 order by employee_id;
//한개씩
select distinct department_id from employees;

select * from departments;

select emp_name,salary,department_id  from employees order by salary;

select distinct employee_id, emp_name, email, phone_number, hire_date, salary,parent_id, employees.department_id from employees, departments where employees.department_id=departments.department_id;

select * from employees where job_id='IT_PROG' and salary>5000;
//검색조건
select * from employees where employee_id>=140 or job_id='SA_REP' order by employee_id asc;

//join
select * from jobs;

select * from employees;

select distinct employees.job_id,jobs.job_title from employees,jobs where employees.job_id=jobs.job_id;

select distinct job_id from employees;

select * from departments;
//교차검색
select departments.*,employees.emp_name "manager ID" from departments,employees where departments.manager_id=employees.employee_id;
//가명
select a.*,b.emp_name "manager ID" from departments a,employees b where a.manager_id=b.employee_id;

select emp_name from employees where employee_id=200;

select a.prod_id,a.cust_id,a.channel_id,a.employee_id,b.emp_name "EMPLOYEE_NAME" from sales a,employees b where a.employee_id=b.employee_id;

select a.prod_id,a.cust_id,c.cust_name,a.channel_id,a.employee_id,b.emp_name "EMPLOYEE_NAME",a.sales_date 
from sales a,employees b,customers c 
where a.employee_id=b.employee_id and a.cust_id=c.cust_id;