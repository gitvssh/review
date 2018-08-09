package java.eventpractice;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlyingTextEx extends JFrame{
	JPanel contentPane = new JPanel();
	JLabel la = new JLabel("Hello");
	final int FLYING_UNIT = 10;
	
	FlyingTextEx(){
		setContentPane(contentPane);
	setTitle("상,하,좌,우 키를 이용하여 'hello'문자열 움직이기");
	setVisible(true);
	setSize(500,500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	contentPane.setLayout(null);
	contentPane.add(la);
	la.setLocation(50,50);
	la.setSize(100,20);
	contentPane.requestFocus();
	contentPane.addKeyListener(new MyKeyListener2());
	}
	
	class MyKeyListener2 extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch(keyCode) {
			case KeyEvent.VK_UP:
				la.setLocation(la.getX(),la.getY()-FLYING_UNIT);
				break;
			case KeyEvent.VK_DOWN:
				la.setLocation(la.getX(),la.getY()+FLYING_UNIT);
				break;
			case KeyEvent.VK_LEFT:
				la.setLocation(la.getX()-FLYING_UNIT,la.getY());
				break;
			case KeyEvent.VK_RIGHT:
				la.setLocation(la.getX()+FLYING_UNIT,la.getY());
				break;
				
			}
		}
	}
	
	public static void main(String[] args) {
		new FlyingTextEx();
	}

}
