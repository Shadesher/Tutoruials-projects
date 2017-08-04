
public class Worker implements Runnable {
	
	@Override
	public void run() {
		for(int a=0;a<2000;a++) {
		Main.increceNumber();
		}
	}
	
}