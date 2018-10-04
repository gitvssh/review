package javaR.guipractice;

import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame{

	ContentPaneEx(){
		setTitle("CotentPane과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.orange);
		
		
		contentPane.setLayout(new BorderLayout(20,20));
		contentPane.add(new JButton("OK"),BorderLayout.WEST);
		contentPane.add(new JButton("Cancel"),BorderLayout.CENTER);
		contentPane.add(new JButton("Ignore"),BorderLayout.EAST);
		contentPane.add(new JButton("OK"),BorderLayout.NORTH);
		contentPane.add(new JButton("Cancel"),BorderLayout.SOUTH);
		contentPane.add(new JButton("Ignore"));
		
		setSize(350,150);
		setVisible(true);
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
	}
	
	public static void main(String[] args) {
		new ContentPaneEx();
		
		
	}

}
