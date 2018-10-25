package sample1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		String methodName = invocation.getMethod().getName();//대상 메서드 이름 얻기
		
		StopWatch sw=new StopWatch();//단순한 스톱워치 기능 제공 유틸클래스
		sw.start(methodName);//시간 측정시작
		
		System.out.println("method : "+methodName+" is calling.");
		Object rtnObj = invocation.proceed();//대표업무 메서드 실행
		//sayhello() 호출
		
		
		sw.stop();
		
		System.out.println("method : "+methodName+" is calling.");
		System.out.println("처리시간 "+sw.getTotalTimeSeconds()+"초");
		return rtnObj;
	}

}
