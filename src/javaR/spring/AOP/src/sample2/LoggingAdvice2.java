package sample2;

import org.aspectj.lang.ProceedingJoinPoint;
//POJO(PlainOldJavaObjecT)의 로그 출력 클래스를
//advice 로써 이용하는 것이 핵심이다.
import org.springframework.util.StopWatch;
//공통사용부분
//proccedingJointPoint사용

public class LoggingAdvice2 {
	public Object logAround(ProceedingJoinPoint joinpoint) throws Throwable{
		String methodName=joinpoint.getKind();
		StopWatch sw=new StopWatch();
		
		sw.start(methodName);
		System.out.println("메서드 호출 전 "+methodName);
		
		Object reobj=joinpoint.proceed();
		
		System.out.println("메서드 호출 후 "+methodName);
		
		sw.stop();
		
		System.out.println("처리시간 :"+sw.getTotalTimeSeconds()+"초");
		
		return reobj;
	}
}
