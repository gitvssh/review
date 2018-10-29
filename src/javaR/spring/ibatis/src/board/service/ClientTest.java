package board.service;

import java.util.List;
import model.Board;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientTest {
	
	private ApplicationContext ctx=new ClassPathXmlApplicationContext("config/applicationContext.xml");
	
	private BoardDaoImpl boardImpl=(BoardDaoImpl)ctx.getBean("boardDaoImpl");
	
	public static void main(String[] args){
		ClientTest A=new ClientTest();

		
		//1.insert
//		Board board=new Board(0,"이미숙","이미숙글","leem123@hanmail.net","안녕하세요","123",null,0,"127.0.0.1");
//		A.boardImpl.insertBoard(board);
		
		
		
//		Board board=A.boardImpl.getBoard(2);
//		System.out.println(board);
		//글수정
//		Board board=new Board();
//		board.setWriter("안미숙888");
//		board.setSubject("안미숙글888");
//		board.setEmail("an2@nate.com");
//		board.setContent("안미숙글888글입니다.");
//		board.setPwd("888");
//		board.setNum(1);
//		A.boardImpl.updateBoard(board);
		
		//5.글삭제
		List<Board> list=A.boardImpl.getList();
		
		for(Board board2 : list){
			System.out.println(board2);
		}
		System.out.println("===========삭제전========");
		
		A.boardImpl.deleteBoard(1);
		System.out.println("===========삭제후========");
		
		list=A.boardImpl.getList();
		
		for(Board board2 : list){
			System.out.println(board2);
		}
	}
}
