package zrc.SingletonPattern;

/**
 * 单例模式
 * 
 * @author rich 测试懒汉式单例模式
 */
public class SingletonPattern02 {
	// 类初始化时，不初始化这个对象（延时加载，真正使用时再加载）
	private static SingletonPattern02 instance;

	private SingletonPattern02() {

	}

	public static synchronized SingletonPattern02 getSingletonPattern02() {
		if (instance == null) {
			instance = new SingletonPattern02();
		}
		return instance;
	}
}
