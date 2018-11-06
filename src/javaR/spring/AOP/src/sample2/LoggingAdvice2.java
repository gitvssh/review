//package sample2;
//
//import org.aspectj.lang.ProceedingJoinPoint;
////POJO(PlainOldJavaObjecT)�� �α� ��� Ŭ������
////advice �ν� �̿��ϴ� ���� �ٽ��̴�.
//import org.springframework.util.StopWatch;
////������κ�
////proccedingJointPoint���
//
//public class LoggingAdvice2 {
//	public Object logAround(ProceedingJoinPoint joinpoint) throws Throwable{
//		String methodName=joinpoint.getKind();
//		StopWatch sw=new StopWatch();
//		
//		sw.start(methodName);
//		System.out.println("�޼��� ȣ�� �� "+methodName);
//		
//		Object reobj=joinpoint.proceed();
//		
//		System.out.println("�޼��� ȣ�� �� "+methodName);
//		
//		sw.stop();
//		
//		System.out.println("ó���ð� :"+sw.getTotalTimeSeconds()+"��");
//		
//		return reobj;
//	}
//}
