package number;

import java.math.BigInteger;

/**
 * int(高精度)
 * 用于：int类型占四个字节，所以其范围为0x80000000-0x7fffffff，超出则用大整数
 * @author 王浩
 *
 */
public class DemoForBigInteger {

	public static void main(String[] args) {
		// BigInteger提供了十进制的构造器
		BigInteger a = new BigInteger("-2222222222222222");
		BigInteger b; 
		// 取绝对值
		b = a.abs();
		System.out.println(b);
		// 两个大整数之和
		b = a.add(new BigInteger("2222222222222222"));
		System.out.println(b);
	    // ...BigInteger给我们提供了很多API，详情可看官方文档
	}
}
