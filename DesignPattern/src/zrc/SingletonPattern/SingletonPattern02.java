package zrc.SingletonPattern;

/**
 * ����ģʽ
 * 
 * @author rich ��������ʽ����ģʽ
 */
public class SingletonPattern02 {
	// ���ʼ��ʱ������ʼ�����������ʱ���أ�����ʹ��ʱ�ټ��أ�
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
