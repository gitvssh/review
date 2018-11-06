//package sample1;
//
//import org.aopalliance.intercept.MethodInterceptor;
//import org.aopalliance.intercept.MethodInvocation;
//import org.springframework.util.StopWatch;
//
//public class LoggingAdvice implements MethodInterceptor{
//
//	@Override
//	public Object invoke(MethodInvocation invocation) throws Throwable {
//		
//		String methodName = invocation.getMethod().getName();//��� �޼��� �̸� ���
//		
//		StopWatch sw=new StopWatch();//�ܼ��� �����ġ ��� ���� ��ƿŬ����
//		sw.start(methodName);//�ð� ��������
//		
//		System.out.println("method : "+methodName+" is calling.");
//		Object rtnObj = invocation.proceed();//��ǥ���� �޼��� ����
//		//sayhello() ȣ��
//		
//		
//		sw.stop();
//		
//		System.out.println("method : "+methodName+" is calling.");
//		System.out.println("ó���ð� "+sw.getTotalTimeSeconds()+"��");
//		return rtnObj;
//	}
//
//}
