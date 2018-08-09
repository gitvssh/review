package chapter15;

import java.io.*;

public class InputMain01 {

	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("C:\\work\\input.txt");
			while(true) {
				int i = is.read();
				System.out.println("데이터 : "+i);
				if(i==-1) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
