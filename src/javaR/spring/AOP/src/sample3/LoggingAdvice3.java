package sample3;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

@Aspect
public class LoggingAdvice3 {//POJO로 작성
	
	@Around("execution(public * sample3.*.sayHello())")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
		
		String methodName=joinPoint.getKind();
		StopWatch sw=new StopWatch();
		
		sw.start(methodName);
		
		System.out.println("method :"+methodName+" 호출 전");
		Object ob=joinPoint.proceed();
		
		sw.stop();
		System.out.println("method : "+methodName+" 호출 후");
		System.out.println("처리시간 : "+sw.getTotalTimeSeconds()+"초");
		
		return ob;
	}
}
