package javaR.games;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javaR.util.*;

public class Main {
	
	/* 프로그램 제어클래스
	 *  새게임, 랭킹, 프로그램 종료
	 */
	static Tools tools = new Tools();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		List<Table> playedGame = new ArrayList<Table>();
		boolean contGame=true;
		String menu;
		
		while(contGame) {
			tools.mainPrint();
			menu = sc.nextLine();
			switch(menu) {
			case "1":
				playedGame.add(playingGame());
				break;
			case "2":
				tools.rankPrint(tools.ranking(playedGame));
				break;
			case "0":
				System.out.println("게임을 종료하시겠습니까?(y)");
				if(sc.nextLine().equalsIgnoreCase("y")){
					contGame = false;
					break;
				}else {
					System.out.println("잘못된 입력입니다.");
					break;
				}
				
			}
			
		}//end main_loop
		
	}//end main

	/**게임진행
	 * 
	 * @return 완료된 게임테이블
	 */
	static Table playingGame() {
		Table playedGame = new Table();
		boolean contInstGame = true;
		while(contInstGame)
		{
			System.out.println("숫자를 입력하세요.");
			String answer = sc.nextLine();
			contInstGame = tools.checkAnswer(answer, playedGame);
		}
		return playedGame;
	}
}//end class
