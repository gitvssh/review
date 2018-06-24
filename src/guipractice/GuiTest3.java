package guipractice;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.xml.internal.ws.api.server.Container;
import java.awt.*;

public class GuiTest3 {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("타이틀문자열");
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		
		JButton b = new JButton("Click");
		
		java.awt.Container c = frame.getContentPane();
		c.add(b);
		JPanel p = new JPanel();
		frame.setContentPane(p);
		
		
		//버튼이 안붙음, 그리고 getcontentPane에 오류가 생김, 앞에 container가 변경되야됨 why?<--jframe을 상속받지 않고 참조변수로 선언한 프레임이기때문
	}

}
