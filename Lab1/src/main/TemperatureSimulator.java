package main;

import environment.Environment;
import environment.Heater;
import environment.Room;

public class TemperatureSimulator {

	
	public static void main(String[] args){
		// At what interval the simulation runs (in milliseconds)
		int timeInterval = 100;
		// How many iterations should the simulation should do
		int iterations = 100;
		// Variable settings
		double initialOutsideTemp = 18.0;
		double initialInsideTemp = 20.0;
		double roomTemperatureLeakConstant = 0.05;
		double worldTemperatureLeakConstant = 0.1;
		double initialRoomAreaInUnits = 50.0;
		double initialHeaterHeatingConstant = 30.0;
		double initialThermostatValue = 22.0;
		double initialThermostatOverheatValue = 2.0;
		
		
		
		// Initiate the objects
		Environment world = new Environment(initialOutsideTemp,worldTemperatureLeakConstant);
		Heater heater1 = new Heater(initialThermostatValue, initialThermostatOverheatValue, initialHeaterHeatingConstant);
		Room room1 = new Room(initialRoomAreaInUnits, roomTemperatureLeakConstant, initialInsideTemp, world);
		
		
		// Move heater in place
		heater1.moveToRoom(room1);
		

		// Start one thread for increasing, one for decreasing the temperature in the room.
		Runnable roomLeakRunnable = new TempLeakThreadImplementaion(room1,timeInterval);
		Thread roomLeakThread = new Thread(roomLeakRunnable);
		roomLeakThread.start();
		
		Runnable worldLeakRunnable = new TempLeakThreadImplementaion(world,timeInterval);
		Thread worldLeakThread = new Thread(worldLeakRunnable);
		worldLeakThread.start();
		
		Runnable heaterRunnable = new HeaterThreadImplementation(heater1, timeInterval);
		Thread heaterThread = new Thread(heaterRunnable);
		heaterThread.start();
		
		
		// Loop printing out the status for the heater and temperature of the room.
		double roomTemperature = room1.getTemperature();
		
		for(int i=0;i<iterations;i++){
			System.out.println("\n---Time slot "+ i+"\n");
			roomTemperature = room1.getTemperature();
			System.out.println("Out: "+world.getTemperature()+"\nIn: " + roomTemperature+ " \n\nThe heater is "+ ((heater1.isTurnedOn(roomTemperature))?"on":"off"));
			
			try {
				Thread.sleep(timeInterval);
			} catch (InterruptedException e) {
				System.out.println("\nPrinting thread stopped.");
			}
			
		}
		
		//All done, stop the temperature simulations
		heaterThread.interrupt();
		worldLeakThread.interrupt();
		roomLeakThread.interrupt();
		System.out.println("All done, quitting..");
		return;
		
		
		
		
	}
	


}
