package board.service;

import java.util.List;

import model.Board;

public interface BoardDao {

	List<Board> getList();
	
	String insertBoard(Board board);
	
	Board getBoard(int num);
	
	Board getBoardUpdate(int num);
	
	void updateBoard(Board board);
	
	void deleteBoard(int num);
	
}
