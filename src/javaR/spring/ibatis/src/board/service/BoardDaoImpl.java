//package board.service;
//
//import java.util.List;
//
//import model.Board;
//import org.springframework.orm.ibatis.SqlMapClientTemplate;
//
//public class BoardDaoImpl implements BoardDao {
//
//	private SqlMapClientTemplate sqlMapClientTemplate;
//
//	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
//		this.sqlMapClientTemplate = sqlMapClientTemplate;
//	}
//
//	@Override
//	public List<Board> getList() {
//		//Board.xml의 id를 사용
//		return sqlMapClientTemplate.queryForList("selectAllBoard");
//	}
//
//	@Override
//	public String insertBoard(Board board) {
//		// TODO Auto-generated method stub
//		String str="insert 성공";
//		sqlMapClientTemplate.insert("insertBoard", board);
//		return str;
//	}
//
//	@Override
//	public Board getBoard(int num) {
//		
//		sqlMapClientTemplate.update("readcountBoard",num);
//		
//		return (Board)sqlMapClientTemplate.queryForObject("selectBoard",num);
//	}
//
//	@Override
//	public Board getBoardUpdate(int num) {
//		return (Board)sqlMapClientTemplate.queryForObject("selectBoard",num);
//	}
//
//	@Override
//	public void updateBoard(Board board) {
//		sqlMapClientTemplate.update("updateBoard",board);
//	}
//
//	@Override
//	public void deleteBoard(int num) {
//		sqlMapClientTemplate.delete("deleteBoard",num);
//	}
//
//}
