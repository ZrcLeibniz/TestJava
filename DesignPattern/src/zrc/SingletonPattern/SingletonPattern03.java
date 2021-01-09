package zrc.SingletonPattern;
/**
 * 
 * ����ģʽ
 * @author rich
 * ���Ծ�̬�ڲ���ʵ�ֵ���ģʽ
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
