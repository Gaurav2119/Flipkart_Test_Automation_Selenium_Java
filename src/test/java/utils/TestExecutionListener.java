package utils;

import java.util.List;

import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.IMethodInstance;

public class TestExecutionListener implements IMethodInterceptor{
	
	@Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<String> testsToRun = Util.testToBeExecuted();
        
        if (testsToRun == null || testsToRun.isEmpty()) {
			throw new RuntimeException("No test classes to run.");
		}

        methods.removeIf(method -> {
            String className = method.getMethod().getTestClass().getRealClass().getSimpleName();
            return !testsToRun.contains(className);
        });

        return methods;
    }
}
