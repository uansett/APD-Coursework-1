package environment;

public class Room extends Environment{
private Heater heater;
private double leakConstant;
private double areaInAreaUnits;

public Room(Heater heater, double roomAreaInSqMtr, double leakConstant, double temperature){
	
	super(temperature);
	
	this.heater = heater;
	this.areaInAreaUnits = roomAreaInSqMtr;
	this.leakConstant = leakConstant;
}



public void updateTemperature(double outsideTemp){
	this.temperature -= (this.temperature - outsideTemp)*leakConstant;
	this.temperature += heater.heatGainPerAreaUnit(this.temperature) / this.areaInAreaUnits;

}



}
