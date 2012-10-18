package main;
import environment.Environment;

public class TempLeakThreadImplementaion implements Runnable{
private Environment room;
private int timeInterval;
	
	public TempLeakThreadImplementaion(Environment room, int timeInterval){
		this.room = room;
		this.timeInterval = timeInterval;
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(timeInterval);
				room.decreaseTemperature();
			} catch (InterruptedException e) {
				System.out.println("Temperature Leak Thread stopped.");
			}
			
		}
	}

}
