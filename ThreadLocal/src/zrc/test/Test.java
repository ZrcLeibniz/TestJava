package zrc.test;

public class Test {
	public static void main(String[] args) {
		ThreadLocal<String> threadlocal = new ThreadLocal<>();
		threadlocal.set("≤‚ ‘");
		new Thread() {
			public void run() {
				String string = threadlocal.get();
				System.out.println(string);
			}
		}.start();
	}
}
