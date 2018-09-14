package algorithms;

public class Util {
	static boolean isPrime(int num){
		if(num==1)
			return false;
		else if(num<4)
			return true;
		else if(num%2==0)
			return false;
		else if(num<9)
			return true;
		else if(num%3==0)
			return false;
		else{
			int r = (int)Math.sqrt((double)num);
			int f = 5;
			while(f<=r){
				if(num%f==0)
					return false;
				if(num%(f+2)==0)
					return false;
				f+=6;
			}
		}
		return true;
	}
}
