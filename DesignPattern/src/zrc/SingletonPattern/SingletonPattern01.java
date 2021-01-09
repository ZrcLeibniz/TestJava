package zrc.SingletonPattern;

/**
 * ����ģʽ
 * 
 * @author rich ���Զ���ʽ����ģʽ
 */
public class SingletonPattern01 {
	private static SingletonPattern01 instance = new SingletonPattern01();

	// ��������Ϊ��̬���� ���ʼ��ʱ��������
	private SingletonPattern01() {

	}

	public static SingletonPattern01 getInstance() {
		return instance;
	}
}
