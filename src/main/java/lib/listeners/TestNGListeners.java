package lib.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class TestNGListeners implements IAnnotationTransformer, IRetryAnalyzer {

	int count = 1;
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(this.getClass());
		System.out.println("Method Name is " +testMethod);
		System.out.println("Iteration Count is " +annotation.getInvocationCount());
		if(testMethod.getName().equals("CreateLead")) {
			annotation.setTimeOut(100000);
			annotation.setDataProvider("UAT");
		}
		if(testMethod.getName().equals("editLead")) {
			annotation.setEnabled(false);
		}
	}

	@Override
	public boolean retry(ITestResult result) {
		
		if(!result.isSuccess() & count < 2) {
			count ++;
			return true;
		}

		return false;
	}

}