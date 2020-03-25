package lock.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自定义原子类。理解原子引用
 * 解决ABA问题？新增版本控制，类似于修改版本号（可以自增也可以使用时间戳）
 * @author 王浩
 *
 */
public class AtomicReferenceDemo {
	public static void main(String[] args) {
		User u1 = new User("u1", 22);
		User u2 = new User("u2", 23);
		AtomicReference<User> ref = new AtomicReference<User>();
		ref.set(u1);
		System.out.println(ref.compareAndSet(u1, u2)+"\t"+ref.get().toString());
		System.out.println(ref.compareAndSet(u1, u2)+"\t"+ref.get().toString());
	}
}

class User {
	String username;
	int age;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public User(String username, int age) {
		this.username = username;
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + "]";
	}
	
}
