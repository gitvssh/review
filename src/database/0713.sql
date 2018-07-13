select table_name from user_tables;

create table ex3_4(employee_id) select employee_id from employees where hire_date between '00/10/01' and '00/12/31';

select * from employees;
desc employees;
create table ex3_3(
    employee_id number,
    bonus_amt number default 0
);

select employee_id, hire_date 
from employees 
where hire_date between '00/10/01'and'00/12/31'
;

desc sales;

select * from sales;

select a.employee_id "직원 아이디",a.emp_name "직원 이름",b.prod_id "상품 아이디",c.prod_name "상품명",c.prod_category "상품 종류",c.prod_pack_size "상품 사이즈",c.prod_status "상품 상태", c.supplier_id "공급자" from employees a,sales b,products c where a.employee_id=b.employee_id and b.sales_date between '00/10/01' and '00/12/31' and b.prod_id=c.prod_id group by a.employee_id;

select employee_id, sales_month
from sales 
where
sales_month between '200010' and '200012'
group by employee_id, sales_month
;
