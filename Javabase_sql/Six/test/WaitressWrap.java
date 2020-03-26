package test;
/**
 * 
 * @author 李泽坤
 *
 */
public class WaitressWrap implements Waiter {
	
	Waiter watier  = null;
	public WaitressWrap(Waiter watier){
		this.watier = watier;
	}
	

	@Override
	public void service() {
		System.out.println("微笑:::");
		watier.service();
	}

}
