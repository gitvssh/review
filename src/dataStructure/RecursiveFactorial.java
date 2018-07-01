package dataStructure;

public class RecursiveFactorial {
	static int Factorial(int n) {
		if(n==0)
			return 1;
		else
			return n*Factorial(n-1);
	}

	public static void main(String[] args) {

		System.out.printf("1! = %d %n",Factorial(1));
		System.out.printf("2! = %d %n",Factorial(2));
		System.out.printf("3! = %d %n",Factorial(3));
		System.out.printf("4! = %d %n",Factorial(4));
		System.out.printf("9! = %d %n",Factorial(9));
	}

}
