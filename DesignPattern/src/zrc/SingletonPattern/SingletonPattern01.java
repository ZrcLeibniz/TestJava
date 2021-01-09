package zrc.SingletonPattern;

/**
 * 单例模式
 * 
 * @author rich 测试饿汉式单例模式
 */
public class SingletonPattern01 {
	private static SingletonPattern01 instance = new SingletonPattern01();

	// 将其设置为静态类型 类初始化时立即加载
	private SingletonPattern01() {

	}

	public static SingletonPattern01 getInstance() {
		return instance;
	}
}
