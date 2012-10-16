package environment;

public class Room extends Environment{
private double temperature;
private Heater heater;
private double leakConstant;

public Room(Heater heater, double roomAreaInSqMtr, double leakConstant, double temperature){
	this.heater = heater;
	this.areaInSqMtr = roomAreaInSqMtr;
	this.leakConstant = leakConstant;
}


public void increaseTemperature(){
	this.temperature += heater.heatGainPerSqMtr(this.temperature) / this.areaInSqMtr;
}

public void decreaseTemperature(double outsideTemp){
	this.temperature -= (this.temperature - outsideTemp)*leakConstant;
}

public double getTemperature(){
	return this.temperature;
}


}
