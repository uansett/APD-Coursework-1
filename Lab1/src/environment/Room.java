package environment;

public class Room extends Environment{
private Heater heater;
private double areaInSqMtr;
private double leakConstant;

public Room(Heater heater, double roomAreaInSqMtr, double leakConstant){
	this.heater = heater;
	this.areaInSqMtr = roomAreaInSqMtr;
}

public void leakTemperature(double outsideTemp){
	this.temperature -= leakAmount(this.temperature, outsideTemp,this.leakConstant);
}

private double leakAmount(double insideTemp, double outsideTemp, double leakConstant){
	return ((insideTemp - outsideTemp)*leakConstant);
}

}
