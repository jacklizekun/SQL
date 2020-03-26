package domain;
/**
 * 
 * @author 李泽坤
 *
 */
public class Account {

	private String name02;
	private int money;
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getName02() {
		return name02;
	}
	public void setName02(String name02) {
		this.name02 = name02;
	}
	@Override
	public String toString() {
		return "Account [name02=" + name02 + ", money=" + money + "]";
	}
	
	
}
