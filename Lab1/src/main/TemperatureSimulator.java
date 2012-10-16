package main;

import environment.Environment;
import environment.Heater;
import environment.Room;

public class TemperatureSimulator {

	
	public static void main(String[] args){
		// Initiate the objects
		//// World
		Environment world = new Environment(18.0);
		
		//// Room and Heater
		Heater heater1 = new Heater(22.0, 2.0, 30.0);
		Room room1 = new Room(heater1, 50.0, 0.05, 20);
		
		double roomTemperature = room1.getTemperature();
		
		for(int i=0;i<1000;i++){
			room1.updateTemperature(world.getTemperature());
			roomTemperature = room1.getTemperature();
			System.out.println("Temperature is now " + roomTemperature+ " units, and the heater is "+ ((heater1.isTurnedOn(roomTemperature))?"on":"off"));
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("\nThread terminated. Quitting.\n");
				return;
			}
		}
		
		
		
	}
	


}
