desc user_tables;

select employee_id "사원번호", emp_name "사원명", salary "월급", (salary+salary*nvl(commission_pct,0))*12 "연봉"
from employees;

select * from employees
where to_char(hire_date,'yyyy/mm/dd')>'1982/01/01';

6. 부서가 IT이면서 직급이 PROGRAMMER 인 사원을 검색하는 쿼리를 작성하시오.
사원번호, 사원명, 부서번호, 부서명, 직급번호, 직급명 

select e.employee_id "사원번호", e.emp_name "사원명", e.department_id "부서번호", d.department_name "부서명", e.job_id "직급번호", j.job_title "직급명"
from employees e, departments d, jobs j
where e.department_id=d.department_id and e.job_id=j.job_id and lower(d.department_name) like '%it%' and lower(j.job_title)='programmer';

7. 급여가 3000달러에서 8000달러 인 사원을 검색하는 쿼리를 작성하시오.

select * from employees
where salary between 3000 and 8000;

8. 급여가 2000달러 또는 3000달러 또는 4000달러인 사원을 검색하는 쿼리를 작성하시오.

select * from employees
where salary in(2000,3000,4000);

9. 사원들 중에서 이름이 K로 시작하는 사원의 사원번호, 사원명을 검색하는 쿼리를 작성하시오.

select employee_id "사원번호", emp_name "사원명"
from employees
where lower(emp_name) like 'k%';

10.  사원명 세 번째 글자가 a인 사원을 검색하는 쿼리를 작성하시오.

select * from employees
where substr(emp_name,3) like 'a%';

11.  커미션이 NULL 이 아닌 사원을 검색하는 쿼리를 작성하시오.

select * from employees
where commission_pct is not null;

12.  사원명이 Z 부터 시작하도록 검색 쿼리를 작성하시오.

select * from employees
order by emp_name desc;

13.  각 사원들의 년봉을 소수점 2자리에서 반올림해서 표현하는 쿼리를 작성하시오.

select round((salary+salary*nvl(commission_pct,0))*12,2) "연봉"
from employees;

14.  사번이 홀수 있는 사원을 검색하는 쿼리를 작성하시오.

select * from employees
where mod(employee_id,2)=1;

15.  9월에 입사한 사원을 검색하는 쿼리를 작성하시오.

select * from employees
where substr(hire_date,4,2)='09';

16.  급여를 10자리로 표현을 해서 남은 왼쪽 자리는 0으로 채우는 쿼리를 작성하시오.

select to_char(salary,'0000000000') from employees;

17.  사원명의 공백을 없애고 출력하는 쿼리를 작성하시오.

select replace(emp_name,' ','') from employees;

18. 사원명과 이메일을 합쳐서 출력하는 쿼리를 작성하시오.

select concat(emp_name,email) from employees;

19.  사원들의 근무일수를 구하는 쿼리를 작성하시오.

select floor(sysdate-hire_date)||'일' from employees;

20.  사원들의 근무개월수를 구하는 쿼리를 작성하시오. * 소수점이하 삭제

select floor(months_between(sysdate,hire_date))||'개월' from employees;

21.  입사날짜를 예) 2000-12-31이라는 형태로 출력하는 쿼리를 작성하시오.

select to_char(hire_date,'yyyy-mm-dd') "입사날짜" from employees;

22.  급여를 \를 표시해서 출력하는 쿼리를 작성하시오. 1달러 = 1200원 계산
자리수는 12자리로 표현하고, 없는 자리수에는 0으로 표시

select to_char(salary*1200,'l000000000000') from employees;

23.직급에 따라 급여를 인상하려 한다. 
직급이 man 인 사원은 5%, asst 사원은 10%, prog인 사원은 15%, , clerk인 사원은 20%, 
그외 3%를 인상한 구문을 구하시오. 
( 사원번호,사원명, 현재월급, 직급, 인상월급 )

select employee_id "사원번호", emp_name "사원명", salary "현재월급", job_id "직급", case
when lower(substr(job_id,4))='man' then salary*(1.05)
when lower(substr(job_id,4))='asst' then salary*(1.10)
when lower(substr(job_id,4))='porg' then salary*(1.15)
when lower(substr(job_id,4))='clerk' then salary*(1.20)
else salary*(1.03)
end "인상월급"
from employees;

24.  부서테이블의 parent번호가 90이면서 부서별 월급의 최대값을 구하시오.
(부서번호, 최대값(월급))

select a.department_id "부서번호", max(a.salary) "부서별 최대월급"
from employees a
where exists(
select * from departments b
where b.parent_id = 90 and a.department_id=b.department_id)
group by a.department_id;

25.  입사년도별 최대 월급을 받는 사람들의 사원번호, 사원명, 월급,년도를 구하시오

select a.employee_id "사원번호", a.emp_name "사원명", a.salary "월급" ,to_char(a.hire_date,'yyyy') "입사년도"  
from employees a
where a.salary in(select max(b.salary)
from employees b
group by to_char(b.hire_date,'yyyy')
having to_char(a.hire_date,'yyyy')=to_char(b.hire_date,'yyyy'))
order by to_char(a.hire_date,'yyyy');


26.  부서별 평균 급여가 6000이상인 부서번호와 부서별 평균 급여를 출력하는 쿼리를 작성하시오.
select department_id "부서번호", avg(salary) "부서별 평균 급여"
from employees
group by department_id
having avg(salary)>=6000
order by department_id;

27.  매니저가 Steven king인 사원의 사원번호, 사원이름, 급여,매니저번호,매니저(사원)이름을
구하는 쿼리를 작성하시오..

select a.employee_id "사원번호", a.emp_name "사원이름", a.salary "급여", a.manager_id "매니저번호", b.emp_name "매니저 이름"
from employees a, employees b
where a.manager_id=b.employee_id and lower(b.emp_name)='steven king';

28.  Douglas Grant 와 같은 부서 사원들을 출력하는 쿼리를 작성하시오.

select * from employees
where department_id=(
select department_id from employees
where emp_name = 'Douglas Grant');


33.  50번 부서에 근무하는 사원의 이름과 부서명을 출력하는 쿼리를 작성하시오.
* 서브쿼리를 사용할 것

select a.emp_name "사원이름", b.department_name "부서명"
from employees a, departments b
where a.department_id = b.department_id and a.department_id =(
select distinct department_id from employees
where department_id = 50);

34.  급여가 10000달러 이상을 받는 사원이 근무하는 부서의 부서 사원들을 출력하는 쿼리를 작성하시오.

select * from employees
where department_id in(
select distinct department_id
from employees
where salary>=10000);