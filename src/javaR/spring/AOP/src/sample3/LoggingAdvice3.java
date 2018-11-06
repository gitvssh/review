//package sample3;
//
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.springframework.util.StopWatch;
//
//@Aspect
//public class LoggingAdvice3 {//POJO�� �ۼ�
//	
//	@Around("execution(public * sample3.*.sayHello())")
//	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
//		
//		String methodName=joinPoint.getKind();
//		StopWatch sw=new StopWatch();
//		
//		sw.start(methodName);
//		
//		System.out.println("method :"+methodName+" ȣ�� ��");
//		Object ob=joinPoint.proceed();
//		
//		sw.stop();
//		System.out.println("method : "+methodName+" ȣ�� ��");
//		System.out.println("ó���ð� : "+sw.getTotalTimeSeconds()+"��");
//		
//		return ob;
//	}
//}
