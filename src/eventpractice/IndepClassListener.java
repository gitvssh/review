package eventpractice;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class IndepClassListener extends JFrame {
	IndepClassListener(){
		setTitle("Action 이벤트 리스너 작성");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,150);
		setVisible(true);
		JButton btn = new JButton("Action");
		MyActionListener2 listener = new MyActionListener2();
		btn.addActionListener(listener);
		add(btn);
		}
		
		
	
	public static void main(String[] args) {
		new IndepClassListener();
	}

}
class MyActionListener2 implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if(b.getText().equals("Action"))
			b.setText("액션");
		else
			b.setText("Action");
	}
}
