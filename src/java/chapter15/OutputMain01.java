package java.chapter15;

import java.io.*;

public class OutputMain01 {

	public static void main(String[] args) {

		OutputStream os = null;

		try {
			os = new FileOutputStream("C:\\output\\file\\output.txt");
			String str = "파일에 지금의 문구를 저장해보겠습니다.2";
			byte[] bs = str.getBytes();
			os.write(bs);
			System.out.println("데이터 저장이 완료되었습니다.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
