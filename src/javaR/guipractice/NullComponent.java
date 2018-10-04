package javaR.guipractice;
import javax.swing.*;
import java.awt.*;

public class NullComponent extends JFrame{
	
	NullComponent(){
		setTitle("배치관리자 없는 컨테이너");
		setVisible(true);
		setSize(300,300);
		Container pan = getContentPane();
		JPanel j1 = new JPanel(null);
		j1.setBackground(Color.black);
		j1.setSize(30,30);
		JPanel j2 = new JPanel(null);
		j2.setBackground(Color.white);
		j2.setSize(30,30);
		JPanel j3 = new JPanel(null);
		j3.setBackground(Color.YELLOW);
		j3.setSize(30,30);
		j3.setLocation(150,150);
		pan.add(j1);
		pan.add(j2);
		pan.add(j3);
		
		pan.setLayout(null);
		
		for(int i=0;i<10;i++) {
		JButton but1 = new JButton(Integer.toString(i));
		but1.setLocation(i*15,i*15);
		but1.setSize(50,20);
		add(but1);
		}
	}
	
	public static void main(String[] args) {
		new NullComponent();
	}

}
