package designmode.behavior.responsibilitychain.interceptor;

/**
 * 拦截器（责任链原理）测试
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), "designmode.behavior.responsibilitychain.interceptor.MyInterceptor");
		proxy.sayHelloWorld();
	}

}
