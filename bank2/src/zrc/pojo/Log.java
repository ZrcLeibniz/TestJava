package zrc.pojo;

public class Log {
	private int id;
	private String accin;
	private String accout;
	private double money;

	public Log() {
		super();
	}

	public Log(int id, String accin, String accout, double money) {
		super();
		this.id = id;
		this.accin = accin;
		this.accout = accout;
		this.money = money;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccin() {
		return accin;
	}

	public void setAccin(String accin) {
		this.accin = accin;
	}

	public String getAccout() {
		return accout;
	}

	public void setAccout(String accout) {
		this.accout = accout;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
}
