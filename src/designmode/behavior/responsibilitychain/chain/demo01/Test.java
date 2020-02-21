package designmode.behavior.responsibilitychain.chain.demo01;

import designmode.behavior.responsibilitychain.interceptor.HelloWorld;
import designmode.behavior.responsibilitychain.interceptor.HelloWorldImpl;
import designmode.behavior.responsibilitychain.interceptor.InterceptorJdkProxy;

/**
 * 责任链模式测试
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		HelloWorld proxy1 = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), "designmode.behavior.responsibilitychain.chain.demo01.Interceptor1");
		HelloWorld proxy2 = (HelloWorld) InterceptorJdkProxy.bind(proxy1, "designmode.behavior.responsibilitychain.chain.demo01.Interceptor2");
		HelloWorld proxy3 = (HelloWorld) InterceptorJdkProxy.bind(proxy2, "designmode.behavior.responsibilitychain.chain.demo01.Interceptor3");
		proxy3.sayHelloWorld();
	}
}
