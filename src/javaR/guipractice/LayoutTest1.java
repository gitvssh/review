package javaR.guipractice;
import java.awt.*;
import javax.swing.*;

public class LayoutTest1 extends JFrame{

	LayoutTest1() {
		setTitle("타이틀 먼저");
		setVisible(true);
		setSize(300,200);
		Container pan = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pan.setLayout(new GridLayout(4,2));
		
		pan.add(new JLabel("이름"));
		pan.add(new JTextField(""));
		pan.add(new JLabel("학번"));
		pan.add(new JTextField(""));
		pan.add(new JLabel("학과"));
		pan.add(new JTextField(""));
		pan.add(new JLabel("과목"));
		pan.add(new JTextField(""));
		
	}
	
	public static void main(String[] args) {
		LayoutTest1 l = new LayoutTest1();
		
	}

}
