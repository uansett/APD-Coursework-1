package main;

import environment.Heater;

public class HeaterThreadImplementation implements Runnable{
private Heater heater;
private int timeInterval;
	
	
	public HeaterThreadImplementation(Heater heater, int timeInterval){
		this.heater = heater;
		this.timeInterval = timeInterval;
	}
	
	@Override
	public void run(){
		while(true){
			try {
				Thread.sleep(timeInterval);
				heater.heatRoom();
			} catch (InterruptedException e) {
				System.out.println("Heater thread stopped.");
				return;
			}
		
		}
		
	}

}
