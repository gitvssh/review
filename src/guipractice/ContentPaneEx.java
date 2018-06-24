package guipractice;

import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame{

	ContentPaneEx(){
		setTitle("CotentPane과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.orange);
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		setSize(350,150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ContentPaneEx();
		
		
	}

}
