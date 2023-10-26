package aop08;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

//횡단(공통)관심 사항
public class LoggingAdvice {
	
	public void logAround(ProceedingJoinPoint jp) throws Throwable{
		String methodName = jp.getSignature().getName();
		StopWatch sw = new StopWatch();
		System.out.println("From [aop8.xml]");
		System.out.println("[LOG]METHOD : " + methodName + " 호출");
		sw.start();
		jp.proceed();
		sw.stop();
		System.out.println("[LOG]METHOD : " + methodName + " 수행 종료");
		System.out.println("[LOG]처리시간   : " + sw.getTotalTimeMillis()/1000 + " 초");
	}
}













