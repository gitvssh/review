package java.eventpractice;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseListenerEx extends JFrame{
	JLabel la;
	MouseListenerEx(){
		setTitle("Mouse 이벤트 예제");
		setVisible(true);
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		setLayout(null);
		contentPane.addMouseListener(new MyMouseAdapter());
		
		la = new JLabel("이동");
		la.setSize(50,20);
		la.setLocation(30,30);
		contentPane.add(la);
		
	}
	
	class MyMouseAdapter extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			int x= e.getX();
			int y=e.getY();
			la.setLocation(x,y);
		}

	}
	
	public static void main(String[] args) {
		new MouseListenerEx();
	}

}
