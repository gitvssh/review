package java.games;
import java.util.*;
public class Tools {
Scanner sc = new Scanner(System.in);
	/* 기타 게임 진행에 필요한 기능 클래스
	 * 화면출력, 랭킹계산, 정답확인
	 */
	void mainPrint() {
		System.out.println("=========================");
		System.out.println("=  숫   자   야   구   맞   추 기   =");
		System.out.println("=========================");
		System.out.println("= 1.새게임 2.명예의전당 0.종료 =");
		System.out.println("=========================");
	}
	
	/**순위, 이름, 클리어회수 출력
	 * 
	 * @param playedGame
	 */
	void rankPrint(List<Table> playedGame) {

		for(int i=0;i<playedGame.size();i++) {
			System.out.println(i+1+"위. "+playedGame.get(i).clearName + "님  기록: "+playedGame.get(i).clearNum);
		}
	}
	
	/** 플레이한 게임테이블리스트 받고 순위 정렬한뒤 정렬된 게임테이블리스트 리턴
	 */
	List ranking(List<Table> playedGame) {
		Collections.sort(playedGame, new Comparator<Table>() {
			@Override
			public int compare(Table o1, Table o2) {
				if (o1.clearNum < o2.clearNum) {
		            return -1;
		        } else if (o1.clearNum > o2.clearNum) {
		            return 1;
		        }
		        return 0;
			}
			
		});
		return playedGame;
	}
	
	/**정답체크
	 * 
	 * @param answer 제출받은 답안
	 * @param t 진행중인 게임 테이블
	 * @return 게임클리어시 true, 실패시 분석결과 출력
	 */
	boolean checkAnswer(String answer,Table t) {
		if(answer.length()!=3) {
			System.out.println("잘못된 입력입니다");
			return true;
		}
		t.history.push(answer);
		t.tryNum++;
		int strike = 0;
		int ball = 0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(i==j&&t.answer[i]==(answer.charAt(j)-'0')) {
					strike++;
				}
				if(i!=j&&t.answer[i]==(answer.charAt(j)-'0')) {
					ball++;
				}
			}
		}
		
		if(strike==3) {//게임클리어
			System.out.println("3Strike!! 정답입니다!!!");
			t.clearNum=t.tryNum;
			t.clearName=this.naming();
			return false;
		}
		else if(strike==0&&ball==0) {
			System.out.println("OUT입니다!");
			return true;
		}else {
			System.out.println(strike+" Strike, "+ball+" Ball 입니다.");
			return true;
		}
	}
	
	/**게임 클리어시 이름 입력선택
	 * 
	 * @return 기본값 AAA
	 */
	String naming() {
		while(true) {
			System.out.println("이름을 입력하시겠습니까?(y,n)");
			String check = sc.nextLine();
			if(check.equalsIgnoreCase("y")) {
				String name = sc.nextLine();
				System.out.println("입력하신 이름은 "+ name+" 입니다.");
				return name;
			}else if(check.equalsIgnoreCase("n")) {
				
				return "AAA";
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}//end while
	}//end naming
		
}

