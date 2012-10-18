package main;

import environment.Environment;
import environment.Heater;
import environment.Room;

public class TemperatureSimulator {

	
	public static void main(String[] args){
		// At what interval the simulation runs (in milliseconds)
		int timeInterval = 1000;
		
		// Initiate the objects
		Environment world = new Environment(18.0,0.1);
		Heater heater1 = new Heater(22.0, 2.0, 30.0);
		Room room1 = new Room(50.0, 0.05, 20, world);
		
		
		// Move heater in place
		heater1.moveToRoom(room1);
		

		// Start one thread for increasing, one for decreasing the temperature in the room.
		Runnable roomLeakRunnable = new TempLeakThreadImplementaion(room1,timeInterval);
		Thread leakThread = new Thread(roomLeakRunnable);
		leakThread.start();
		
		Runnable worldLeakRunnable = new TempLeakThreadImplementaion(world,timeInterval);
		Thread worldLeakThread = new Thread(worldLeakRunnable);
		worldLeakThread.start();
		
		Runnable heaterRunnable = new HeaterThreadImplementation(heater1, timeInterval);
		Thread heaterThread = new Thread(heaterRunnable);
		heaterThread.start();
		
		
		// Loop printing out the status for the heater and temperature of the room.
		double roomTemperature = room1.getTemperature();
		
		for(int i=0;i<100;i++){
			System.out.println("\n---Time slot "+ i+"\n");
			roomTemperature = room1.getTemperature();
			System.out.println("Out: "+world.getTemperature()+"\nIn: " + roomTemperature+ " \n\nThe heater is "+ ((heater1.isTurnedOn(roomTemperature))?"on":"off"));
			
			try {
				Thread.sleep(timeInterval);
			} catch (InterruptedException e) {
				System.out.println("\nThread terminated. Quitting.\n");
				return;
			}
			
		}
		
		
		
	}
	


}
