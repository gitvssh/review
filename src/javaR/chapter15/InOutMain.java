package javaR.chapter15;

import java.io.*;

public class InOutMain {

	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;

		try {
			is = new FileInputStream("C:\\work\\input.hwp");
			os = new FileOutputStream("C:\\output\\file\\out.hwp");
			
			byte[] bs = new byte[5];
			
			
			while (true) {
				int i = is.read(bs);
				if (i == -1) {
					break;
				}
				os.write(bs,0,i);
			}
			System.out.println("입력이 완료되었습니다.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
