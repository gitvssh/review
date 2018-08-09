package guipractice;
import java.awt.*;
import javax.swing.*;

import javafx.scene.paint.Color;

public class TestCase1 extends JFrame{

	TestCase1(){
		setTitle("테스트");
		setVisible(true);
		setSize(800,500);
		Container pan = getContentPane();
		pan.setLayout(null);
		pan.setBackground(java.awt.Color.BLUE);
		
		JPanel j1 = new JPanel();
		j1.setSize(350,400);
		j1.setBackground(java.awt.Color.cyan);
		j1.setLocation(10,10);
		
		JPanel j2 = new JPanel();
		j2.setSize(350,400);
		j2.setLocation(380,10);
		j2.setBackground(java.awt.Color.GREEN);
		
		pan.add(j1);
		pan.add(j2);
		j1.add(new JLabel("1번 글자"));
		j2.add(new JLabel("2번 글자"));
		pan.add(new JLabel("전체"));
		
	}
	
	public static void main(String[] args) {
		new TestCase1();

	}

}
