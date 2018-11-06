//package dao;
//
//import logic.User;
//
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
//
//public class UserDaoImpl implements UserDao {
//
//	private SimpleJdbcTemplate template;
//	
//	public void setTemplate(SimpleJdbcTemplate template){
//		this.template=template;
//	}
//	
//	private static final String SELECT_ID_PWD= "select user_id, password, user_name, postcode,"
//			+ " address, email, job, birthday from user_account"
//			+ " where user_id=? and password=?";
//	
//	@Override
//	public User findByUserIdAndPassword(String userId, String password) {
//		//BeanPropertyRowMapper 클래스는
//		//테이블의 컬럼이름과 User클래스의 DB필드이름을 대응(맵핑)시켜
//		//값을 지정 합니다.
//		
//		RowMapper<User> mapper=new BeanPropertyRowMapper<User>(User.class);
//		
//		return this.template.queryForObject(SELECT_ID_PWD, mapper, userId,password);
//	}
//
//}
