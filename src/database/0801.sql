create table member(
M_id varchar2(12),
M_password varchar2(16),
m_name varchar2(20),
m_birth number(8),
m_sex varchar2(2),
m_phonenum number(11),
m_event varchar2(20)
);


select * from member;

update member set m_event='0'
where m_sex = '여';

select m_id "아이디", m_password "비번", m_name "이름", m_birth "생년월일", m_sex "성별", m_phonenum "전화번호" ,
case when m_event ='1' then '대상'
else '비대상'
end "이벤트"
from member;