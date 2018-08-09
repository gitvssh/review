package games;
import java.util.*;
public class Table {
	/*게임 1회 진행에 쓰이는 테이블
	 * 필요정보 - 정답숫자, 정답숫자 생성메서드, 답안숫자 기록 스택, 최종결과까지 시도값,  최종결과후 클리어 이름(기본값 존재), 게임번호
	 */
	int[] answer;
	Stack<String> history = new Stack(); 
	int tryNum;
	int clearNum;
	String clearName;
	int gameNum;
	static int count = 0;
	
	/**	새 테이블 생성시, 정답숫자 생성
	 * 
	 */
	Table(){
		answer = makingAnswer();
		gameNum = ++count;
	}
	
	
	int[] makingAnswer() {
		int[] answerList = new int[10];
		for(int i=0;i<10;i++) {
			answerList[i] = i;
		} 
		for(int i=0;i<1;i++) {// mix
			int ranNum=(int)(Math.random()*10);
			int tmp = answerList[ranNum];
			answerList[ranNum] = answerList[0];
			answerList[0] = tmp;
		}
		int[] makedAnswer = new int[3];
		System.arraycopy(answerList, 0, makedAnswer, 0, 3);
		return makedAnswer;
	}
}
