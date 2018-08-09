package eventpractice;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InnerClassListener extends JFrame{
	InnerClassListener(){
		setTitle("Action 이벤트 리스너 작성");
		setVisible(true);
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener3());
		add(btn);
		
	}
	private class MyActionListener3 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Action"))
				b.setText("액션");
			else
				b.setText("Action");
			
			setTitle(b.getText());
		}
	}
	
	public static void main(String[] args) {
		new InnerClassListener();
	}

}
