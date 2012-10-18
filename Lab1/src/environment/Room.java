package environment;


public class Room extends Environment{
private double areaInAreaUnits;
private Environment containerEnvironment;

public Room(double roomAreaInSqMtr, double leakConstant, double temperature, Environment containerEnvironment){
	
	super(temperature, leakConstant);
	this.containerEnvironment = containerEnvironment;
	this.areaInAreaUnits = roomAreaInSqMtr;
}



public void decreaseTemperature(){
	this.temperature -= (this.temperature - containerEnvironment.getTemperature())*leakConstant;
}


public double getArea(){
	return areaInAreaUnits;
}






}
