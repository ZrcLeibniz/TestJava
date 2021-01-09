package zrc.SingletonPattern;
/**
 * 
 * 单例模式
 * @author rich
 * 测试静态内部类实现单例模式
 *
 */
public class SingletonPattern03 {
	private static class SingletonClassInstance{
		private static final SingletonPattern03 instance = new SingletonPattern03();
	} 
	private SingletonPattern03() {
		
	}
	public static SingletonPattern03 getInstance() {
		return SingletonClassInstance.instance;
	}
}
